package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationResponse
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsResponse
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("GetAttributeDetailsMobileApp")
    suspend fun getAccountType(@Body accountTypeRequest: AccountTypeRequest): Response<AccountTypeResponse>

    @POST("CheckCustomerExistancyAndVerification")
    suspend fun checkMobileNumberExistency(@Body emailCheckRequest: EmailExistencyChekRequest): Response<Int>

    @POST("SaveAndGetOTPDetails")
    suspend fun sentOtp(@Body saveAndGetOTPDetailsRequest: SaveAndGetOTPDetailsRequest): Response<SaveAndGetOTPDetailsResponse>

    @POST("IsvalidateOTP")
    suspend fun validateOtp(@Body oTPValidationRequest: OTPValidationRequest) : Response<OTPValidationResponse>

    @POST("CheckIsAuthenticatedMobileApp")
    suspend fun getLoginDetails(@Body loginRequest: LoginRequest): Response<LoginResponse>
}