package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiInterface: ApiInterface) : BaseRepository() {

    suspend fun getLoginDetails(loginRequest: LoginRequest): NetworkResult<LoginResponse> {
        return safeApiCall {
            apiInterface.getLoginDetails(loginRequest)
        }
    }

    suspend fun getAccountType(accountTypeRequest: AccountTypeRequest): NetworkResult<AccountTypeResponse> {
        return safeApiCall {
            apiInterface.getAccountType(accountTypeRequest)
        }
    }

}