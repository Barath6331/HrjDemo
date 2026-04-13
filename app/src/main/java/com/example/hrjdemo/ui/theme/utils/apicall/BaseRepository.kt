package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


open class BaseRepository {

    suspend fun <T> safeApiCall(call: suspend () -> Response<T>): NetworkResult<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response = call()
                val body = response.body()
                if (response.isSuccessful && body != null) {
                    NetworkResult.Success(body)
                } else {
                    val errorMsg = response.errorBody()?.string() ?: response.message()
                    NetworkResult.Error(errorMsg, response.code())
                }

            } catch (e: Exception) {
                NetworkResult.Error(e.message.toString())
            }
        }
    }
}