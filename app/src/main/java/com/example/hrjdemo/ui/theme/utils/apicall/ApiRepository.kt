package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyResponse
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationResponse
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsResponse
import com.example.hrjdemo.ui.theme.utils.network.NetworkResult
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiInterface: ApiInterface) : BaseRepository() {

    suspend fun getAccountType(accountTypeRequest: AccountTypeRequest): NetworkResult<AccountTypeResponse> {
        return safeApiCall {
            apiInterface.getAccountType(accountTypeRequest)
        }
    }

    suspend fun checkExistency(emailExistencyChekRequest: EmailExistencyChekRequest): NetworkResult<Int> {
        return safeApiCall { apiInterface.checkMobileNumberExistency(emailExistencyChekRequest) }
    }

    suspend fun sentOtp(saveAndGetOTPDetailsRequest: SaveAndGetOTPDetailsRequest): NetworkResult<SaveAndGetOTPDetailsResponse> {
        return safeApiCall { apiInterface.sentOtp(saveAndGetOTPDetailsRequest) }
    }

    suspend fun validateOtp(otpValidationRequest: OTPValidationRequest): NetworkResult<OTPValidationResponse> {
        return safeApiCall {
            apiInterface.validateOtp(otpValidationRequest)
        }
    }

    suspend fun getLoginDetails(loginRequest: LoginRequest): NetworkResult<LoginResponse> {
        return safeApiCall {
            apiInterface.getLoginDetails(loginRequest)
        }
    }
}