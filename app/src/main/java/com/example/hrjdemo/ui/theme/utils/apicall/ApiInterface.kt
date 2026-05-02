package com.example.hrjdemo.ui.theme.utils.apicall

import com.example.hrjdemo.ui.theme.utils.model.EmailExistencyChekRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginRequest
import com.example.hrjdemo.ui.theme.utils.model.LoginResponse
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationRequest
import com.example.hrjdemo.ui.theme.utils.model.OTPValidationResponse
import com.example.hrjdemo.ui.theme.utils.model.RegistrationRequest
import com.example.hrjdemo.ui.theme.utils.model.RegistrationResponse
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsRequest
import com.example.hrjdemo.ui.theme.utils.model.SaveAndGetOTPDetailsResponse
import com.loyaltyworks.hrjohnson.model.AccountTypeRequest
import com.loyaltyworks.hrjohnson.model.AccountTypeResponse
import com.loyaltyworks.hrjohnson.model.CityListRequest
import com.loyaltyworks.hrjohnson.model.CityListResponse
import com.loyaltyworks.hrjohnson.model.DealerLisingRequest
import com.loyaltyworks.hrjohnson.model.DealerListingResponse
import com.loyaltyworks.hrjohnson.model.HistoryNotificationRequest
import com.loyaltyworks.hrjohnson.model.HistoryNotificationResponse
import com.loyaltyworks.hrjohnson.model.MyEarningRequest
import com.loyaltyworks.hrjohnson.model.MyEarningResponse
import com.loyaltyworks.hrjohnson.model.PromotionListRequest
import com.loyaltyworks.hrjohnson.model.PromotionListResponse
import com.loyaltyworks.hrjohnson.model.StateListRequest
import com.loyaltyworks.hrjohnson.model.StateListResponse
import com.loyaltyworks.hrjohnson.model.UpdatedDashboardSingleApiRequest
import com.loyaltyworks.hrjohnson.model.UpdatedDashboardSingleApiResponse
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
    suspend fun validateOtp(@Body oTPValidationRequest: OTPValidationRequest): Response<OTPValidationResponse>

    @POST("CheckIsAuthenticatedMobileApp")
    suspend fun getLoginDetails(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("GetStateDetailsMobileApp")
    suspend fun getState(@Body stateListRequest: StateListRequest): Response<StateListResponse>

    @POST("GetCityDetailsMobileApp")
    suspend fun getCity(@Body cityListRequest: CityListRequest): Response<CityListResponse>

    @POST("SaveCustomerRegistrationDetailsMobileApp")
    suspend fun registrationApi(@Body registrationRequest: RegistrationRequest) : Response<RegistrationResponse>

    @POST("GetDashBoardDetailsApi")
    suspend fun getDashboardDetails(@Body updatedDashboardSingleApiRequest:UpdatedDashboardSingleApiRequest): Response<UpdatedDashboardSingleApiResponse>

    @POST("GetRewardTransactionDetailsMobileApp")
    suspend fun myEarningList(@Body myEarningRequest: MyEarningRequest): Response<MyEarningResponse>

    @POST("GetPushHistoryDetails")
    suspend fun notificationList(@Body historyNotificationRequest: HistoryNotificationRequest): Response<HistoryNotificationResponse>

    @POST("GetDealerDetails")
    suspend fun dealerLocatorList(@Body dealerLisingRequest: DealerLisingRequest) : Response<DealerListingResponse>

    @POST("GetPromotionDetailsMobileApp")
    suspend fun getOffersAndPromotions(@Body promotionListRequest: PromotionListRequest) : Response<PromotionListResponse>
}