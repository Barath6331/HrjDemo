package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("CheckIsAuthenticatedMobileApp")
    suspend fun getLoginDetails(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("GetAttributeDetailsMobileApp")
    suspend fun getAccountType(@Body accountTypeRequest: AccountTypeRequest): Response<AccountTypeResponse>
}