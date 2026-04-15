package com.example.hrjdemo.ui.theme.utils.network

import android.content.Context
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton
import com.example.hrjdemo.BuildConfig
import okhttp3.OkHttpClient
import com.example.authenticationmodule.PreferenceHelperToken
import com.example.authenticationmodule.AuthAPICall
import com.example.hrjdemo.ui.theme.utils.apicall.ApiInterface
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.CertificatePinner
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    }


    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideAuthenticator(
        @ApplicationContext context: Context   // ✅ @ApplicationContext — no static reference
    ): Authenticator {
        return object : Authenticator {
            override fun authenticate(route: Route?, response: Response): Request? {
                // Avoid infinite retry loop — if already tried once, give up
                if (response.request.header("Authorization") != null &&
                    responseCount(response) >= 2
                ) {
                    return null
                }

                // ✅ runBlocking is safe here because OkHttp's Authenticator already runs
                // on a background IO thread — we are NOT blocking the main thread.
                val authResult = runBlocking {
                    AuthAPICall.run(
                        context,
                        UrlClass.tokenUrl(),
                        UrlClass.tokenRequest()
                    )
                } ?: return null  // Return null to propagate 401 if refresh fails

                return response.request.newBuilder()
                    .header("Authorization", "${authResult.token_type} ${authResult.access_token}")
                    .build()
            }

            private fun responseCount(response: Response): Int {
                var count = 1
                var priorResponse = response.priorResponse
                while (priorResponse != null) {
                    count++
                    priorResponse = priorResponse.priorResponse
                }
                return count
            }
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @ApplicationContext context: Context,
        loggingInterceptor: HttpLoggingInterceptor,
        authenticator: Authenticator
    ): OkHttpClient {
        val sha = ""
        val builder =
            OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor { chain ->
                val token = PreferenceHelperToken.getTokenDetails(context)

                val request = chain.request().newBuilder()
                if (token != null) {
                    request.addHeader(
                        "Authorization", "${token.token_type} ${token.access_token}"
                    )
                }
                chain.proceed(request.build())
            }.connectTimeout(60, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)

        if (sha.isNotEmpty()) {
            val host = "hrjdemoserv.loyltwo3ks.com"

            val certificatePinner = CertificatePinner.Builder().add(host, sha).build()

            builder.certificatePinner(certificatePinner)
        }

        return builder.authenticator(authenticator).build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://hrjdemoserv.loyltwo3ks.com/Mobile/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }
}