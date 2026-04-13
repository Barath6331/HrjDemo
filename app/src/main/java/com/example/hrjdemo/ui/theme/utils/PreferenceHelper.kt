package com.example.hrjdemo.ui.theme.utils

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PreferenceHelper @Inject constructor(@ApplicationContext context: Context, private val moshi: Moshi) {

    companion object {
        private const val PreferenceName = "LoyaltyPreferenceHelper"
        private const val CampaingDetails = "LoyaltyPreferenceHelper_dashboardDetails"
        private const val LoginDetails = "LoyaltyPreferenceHelper_loginDetails"
    }

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        PreferenceName,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

   /* fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    fun setBooleanValue(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBooleanValue(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun setStringValue(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getStringValue(key: String): String {
        return sharedPreferences.getString(key, "") ?: ""
    }

    private fun loginAdapter(): JsonAdapter<LoginResponse> {
        return moshi.adapter(LoginResponse::class.java)
    }

    fun setLoginDetails(loginResponse: LoginResponse) {
        val json = loginAdapter().toJson(loginResponse)
        sharedPreferences.edit().putString(LoginDetails, json).apply()
    }

    fun getLoginDetails(): LoginResponse? {
        val stringValue = sharedPreferences.getString(LoginDetails, "")
        return if (!stringValue.isNullOrEmpty()) {
            loginAdapter().fromJson(stringValue)
        } else {
            null
        }
    }

    private fun campaignAdapter(): JsonAdapter<LstCampaign> {
        return moshi.adapter(LstCampaign::class.java)
    }

    fun setCampaignDetails(lstCampaign: LstCampaign) {
        val json = campaignAdapter().toJson(lstCampaign)
        sharedPreferences.edit().putString(CampaingDetails, json).apply()
    }

    fun getCampaignDetails(): LstCampaign? {
        val stringValue = sharedPreferences.getString(CampaingDetails, "")
        return if (!stringValue.isNullOrEmpty()) {
            campaignAdapter().fromJson(stringValue)
        } else {
            null
        }
    }*/
}