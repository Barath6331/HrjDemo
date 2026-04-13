package com.example.hrjdemo.ui.theme.utils.model

import android.graphics.Bitmap
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "Browser")
    var browser: String? = null,
    @Json(name = "LoggedDeviceName")
    var loggedDeviceName: String? = null,
    @Json(name = "Password")
    var password: String? = null,
    @Json(name = "PushID")
    var pushID: String? = null,
    @Json(name = "SessionId")
    var sessionId: String? = null,
    @Json(name = "UserActionType")
    var userActionType: String? = null,
    @Json(name = "UserIp")
    var userIp: String? = null,
    @Json(name = "UserName")
    var userName: String? = null,
    @Json(name = "UserType")
    var userType: String? = null,
    @Json(name = "LoggedDeviceID")
    val loggedDeviceID: String? = null,
)

@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "lstMerchantImageDetails")
    var lstMerchantImageDetails: Any? = null,
    @Json(name = "merchantImageDetails")
    var merchantImageDetails: Any? = null,
    @Json(name = "objUserDetailedInfo")
    var objUserDetailedInfo: Any? = null,
    @Json(name = "userId")
    var userId: Int? = null,
    @Json(name = "userList")
    var userList: List<User>? = null
)

@JsonClass(generateAdapter = true)
data class User(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "c_MerchantId")
    var cMerchantId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "commonUserMobile")
    var commonUserMobile: Any? = null,
    @Json(name = "commonUserName")
    var commonUserName: Any? = null,
    @Json(name = "country")
    var country: Any? = null,
    @Json(name = "countryCode")
    var countryCode: Any? = null,
    @Json(name = "currency")
    var currency: Any? = null,
    @Json(name = "custAccountNumber")
    var custAccountNumber: String? = null,
    @Json(name = "custAccountType")
    var custAccountType: Any? = null,
    @Json(name = "customerGrade")
    var customerGrade: Any? = null,
    @Json(name = "customerTypeID")
    var customerTypeID: Int? = null,
    @Json(name = "dob")
    var dob: Any? = null,
    @Json(name = "email")
    var email: String? = null,
    @Json(name = "encrypted_OTP_PIN")
    var encryptedOTPPIN: Any? = null,
    @Json(name = "isBlacklisted")
    var isBlacklisted: Int? = null,
    @Json(name = "isDormant")
    var isDormant: Int? = null,
    @Json(name = "isGeofenceActive")
    var isGeofenceActive: Int? = null,
    @Json(name = "isOnHold")
    var isOnHold: Int? = null,
    @Json(name = "isUserActive")
    var isUserActive: Int? = null,
    @Json(name = "language")
    var language: Any? = null,
    @Json(name = "locationCountryID")
    var locationCountryID: Int? = null,
    @Json(name = "locationId")
    var locationId: Int? = null,
    @Json(name = "locationName")
    var locationName: String? = null,
    @Json(name = "locationType")
    var locationType: Any? = null,
    @Json(name = "memberSince")
    var memberSince: Any? = null,
    @Json(name = "merchantEmailID")
    var merchantEmailID: String? = null,
    @Json(name = "merchantId")
    var merchantId: Int? = null,
    @Json(name = "merchant_logo")
    var merchantLogo: Any? = null,
    @Json(name = "merchantMobileNo")
    var merchantMobileNo: String? = null,
    @Json(name = "merchantName")
    var merchantName: Any? = null,
    @Json(name = "mobile")
    var mobile: String? = null,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "parentLocationId")
    var parentLocationId: Int? = null,
    @Json(name = "parentLocationName")
    var parentLocationName: Any? = null,
    @Json(name = "password")
    var password: String? = null,
    @Json(name = "pinStatus")
    var pinStatus: Int? = null,
    @Json(name = "prefix")
    var prefix: String? = null,
    @Json(name = "result")
    var result: Int? = null,
    @Json(name = "roleName")
    var roleName: Any? = null,
    @Json(name = "status")
    var status: String? = null,
    @Json(name = "superParentLocationId")
    var superParentLocationId: Int? = null,
    @Json(name = "userGender")
    var userGender: String? = null,
    @Json(name = "userId")
    var userId: Int? = null,
    @Json(name = "userImage")
    var userImage: Any? = null,
    @Json(name = "userLastName")
    var userLastName: String? = null,
    @Json(name = "userName")
    var userName: String? = null,
    @Json(name = "userType")
    var userType: String? = null,
    @Json(name = "verifiedStatus")
    var verifiedStatus: Int? = null,
    @Json(name = "isDelete")
    val isDelete: Int? = null,
    @Json(name = "membershipID")
    val membershipID: String? = null,
    @Json(name = "customerName")
    val customerName: String? = null,
    @Json(name = "deletedDate")
    val deletedDate: String? = null,
    @Json(name = "accountStatus")
    val accountStatus: String? = null
)

@JsonClass(generateAdapter = true)
data class ForgotPasswordRequest(
    var UserName: String? = null
)


/*SaveAndGetOTPDetails Request*/
@JsonClass(generateAdapter = true)
data class SaveAndGetOTPDetailsRequest(
    val MerchantUserName: String,
    val MobileNo: String,
    val OTPType: String,
    val UserId: Int,
    val UserName: String
)

/*SaveAndGetOTPDetails Response*/
@JsonClass(generateAdapter = true)
data class SaveAndGetOTPDetailsResponse(
    @Json(name = "adminList")
    var adminList: Any? = null,
    @Json(name = "merchantEmailSMSDetails")
    var merchantEmailSMSDetails: Any? = null,
    @Json(name = "merchantEmailSMSParameterDetails")
    var merchantEmailSMSParameterDetails: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)


/*
@JsonClass(generateAdapter = true)
data class ForgotPasswordResponse(
    var forgotPasswordMobileAppResult: Boolean? = null
)

*/



@JsonClass(generateAdapter = true)
data class CustomerExistancyRequest(
    val ActionType: String? = null,
    val Location: Locations? = null
)

@JsonClass(generateAdapter = true)
data class Locations(
    val UserName: String? = null,
)


@JsonClass(generateAdapter = true)
data class CustomerExistancyResponse(
    val CheckCustomerExistancyAndVerificationResult: Int? = null
)

/*** Registration Request ***/

@JsonClass(generateAdapter = true)
data class RegistrationRequest(
    @Json(name = "actiontype")
    var actiontype: String? = null,
    @Json(name = "objcustomerjson")
    var objcustomerjson: ObjcustomerjsonRegister? = null
)

@JsonClass(generateAdapter = true)
data class ObjcustomerjsonRegister(
    @Json(name = "address1")
    var address1: String? = null,
    @Json(name = "cityid")
    var cityid: String? = null,
    @Json(name = "CountryId")
    var countryId: Int? = null,
    @Json(name = "customertypeid")
    var customertypeid: Int? = null,
    @Json(name = "email")
    var email: String? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "LastName")
    var lastName: String? = null,
    @Json(name = "Mobile")
    var mobile: String? = null,
    @Json(name = "PreferedDealerName")
    var preferedDealerName: String? = null,
    @Json(name = "ReferrerCode")
    var referrerCode: String? = null,
    @Json(name = "RegistrationSource")
    var registrationSource: String? = null,
    @Json(name = "StateId")
    var stateId: Int? = null,
    @Json(name = "Zip")
    var zip: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "UpiHolderName")
    var upiHolderName: String? = null,
    @Json(name = "UpiId")
    var upiId: String? = null,
    @Json(name = "UpiAttachment")
    var upiAttachment: String? = null,
) : Serializable


@JsonClass(generateAdapter = true)
data class RegistrationResponse(
    @Json(name = "lstCustomer")
    var lstCustomer: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

/*** ReferalCode Existancy Request ***/
@JsonClass(generateAdapter = true)
data class ReferalCodeExistancyRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "Location")
    var location: Locationn? = null
)

@JsonClass(generateAdapter = true)
data class Locationn(
    @Json(name = "UserName")
    var userName: String? = null
)

@JsonClass(generateAdapter = true)
data class TermsConditionRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null
)

@JsonClass(generateAdapter = true)
data class TermsConditionResponse(
    @Json(name = "lstTermsAndCondition")
    var lstTermsAndCondition: List<LstTermsAndCondition>? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstTermsAndCondition(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "actorId")
    var actorId: Int? = null,
    @Json(name = "actorRole")
    var actorRole: Any? = null,
    @Json(name = "color")
    var color: String? = null,
    @Json(name = "createDate")
    var createDate: String? = null,
    @Json(name = "fileName")
    var fileName: String? = null,
    @Json(name = "html")
    var html: String? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "language")
    var language: String? = null,
    @Json(name = "languageId")
    var languageId: Int? = null,
    @Json(name = "segmentId")
    var segmentId: Int? = null,
    @Json(name = "segmentName")
    var segmentName: String? = null,
    @Json(name = "segmentType")
    var segmentType: Any? = null,
    @Json(name = "statusName")
    var statusName: String? = null,
    @Json(name = "tcName")
    var tcName: String? = null,
    @Json(name = "termsAndConditionsId")
    var termsAndConditionsId: Int? = null,
    @Json(name = "token")
    var token: Any? = null,
    @Json(name = "wefDate")
    var wefDate: String? = null
)


/*** OTP Validation Request ***/
@JsonClass(generateAdapter = true)
data class OTPValidationRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "MobileNo")
    val mobileNo: String? = null,
    @Json(name = "OTP")
    val oTP: String? = null,
    @Json(name = "UserName")
    val userName: String? = null
)

/*** OTP Validation Response ***/
@JsonClass(generateAdapter = true)
data class OTPValidationResponse(
    @Json(name = "lstMerchantImageDetails")
    val lstMerchantImageDetails: Any? = null,
    @Json(name = "merchantImageDetails")
    val merchantImageDetails: Any? = null,
    @Json(name = "objUserDetailedInfo")
    val objUserDetailedInfo: Any? = null,
    @Json(name = "returnMessage")
    val returnMessage: String? = null,
    @Json(name = "userId")
    val userId: Int? = null,
    @Json(name = "userList")
    val userList: List<Userr?>? = null
)

@JsonClass(generateAdapter = true)
data class Userr(
    @Json(name = "actionType")
    val actionType: Int? = null,
    @Json(name = "c_MerchantId")
    val cMerchantId: Int? = null,
    @Json(name = "cityName")
    val cityName: Any? = null,
    @Json(name = "commonUserMobile")
    val commonUserMobile: Any? = null,
    @Json(name = "commonUserName")
    val commonUserName: Any? = null,
    @Json(name = "country")
    val country: Any? = null,
    @Json(name = "countryCode")
    val countryCode: Any? = null,
    @Json(name = "currency")
    val currency: Any? = null,
    @Json(name = "custAccountNumber")
    val custAccountNumber: Any? = null,
    @Json(name = "custAccountType")
    val custAccountType: Any? = null,
    @Json(name = "customerGrade")
    val customerGrade: Any? = null,
    @Json(name = "customerTypeID")
    val customerTypeID: Int? = null,
    @Json(name = "dob")
    val dob: Any? = null,
    @Json(name = "email")
    val email: Any? = null,
    @Json(name = "encrypted_OTP_PIN")
    val encryptedOTPPIN: String? = null,
    @Json(name = "isBlacklisted")
    val isBlacklisted: Int? = null,
    @Json(name = "isDelete")
    val isDelete: Int? = null,
    @Json(name = "isDormant")
    val isDormant: Int? = null,
    @Json(name = "isGeofenceActive")
    val isGeofenceActive: Int? = null,
    @Json(name = "isOnHold")
    val isOnHold: Int? = null,
    @Json(name = "isUserActive")
    val isUserActive: Int? = null,
    @Json(name = "language")
    val language: Any? = null,
    @Json(name = "languageId")
    val languageId: Int? = null,
    @Json(name = "locationCountryID")
    val locationCountryID: Int? = null,
    @Json(name = "locationId")
    val locationId: Int? = null,
    @Json(name = "locationName")
    val locationName: Any? = null,
    @Json(name = "locationType")
    val locationType: Any? = null,
    @Json(name = "memberSince")
    val memberSince: Any? = null,
    @Json(name = "merchantEmailID")
    val merchantEmailID: Any? = null,
    @Json(name = "merchantId")
    val merchantId: Int? = null,
    @Json(name = "merchant_logo")
    val merchantLogo: Any? = null,
    @Json(name = "merchantMobileNo")
    val merchantMobileNo: Any? = null,
    @Json(name = "merchantName")
    val merchantName: Any? = null,
    @Json(name = "mobile")
    val mobile: Any? = null,
    @Json(name = "name")
    val name: Any? = null,
    @Json(name = "parentCustomerTypeId")
    val parentCustomerTypeId: Int? = null,
    @Json(name = "parentLocationId")
    val parentLocationId: Int? = null,
    @Json(name = "parentLocationName")
    val parentLocationName: Any? = null,
    @Json(name = "password")
    val password: Any? = null,
    @Json(name = "pinStatus")
    val pinStatus: Int? = null,
    @Json(name = "prefix")
    val prefix: Any? = null,
    @Json(name = "result")
    val result: Int? = null,
    @Json(name = "roleName")
    val roleName: Any? = null,
    @Json(name = "sapCode")
    val sapCode: Any? = null,
    @Json(name = "status")
    val status: Any? = null,
    @Json(name = "superParentLocationId")
    val superParentLocationId: Int? = null,
    @Json(name = "userGender")
    val userGender: String? = null,
    @Json(name = "userId")
    val userId: Int? = null,
    @Json(name = "userImage")
    val userImage: Any? = null,
    @Json(name = "userLastName")
    val userLastName: Any? = null,
    @Json(name = "userName")
    val userName: Any? = null,
    @Json(name = "userType")
    val userType: Any? = null,
    @Json(name = "verifiedStatus")
    val verifiedStatus: Int? = null
)


//email existency chek request

@JsonClass(generateAdapter = true)
data class EmailExistencyChekRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "Location")
    var emailData: EmailData? = null
)

@JsonClass(generateAdapter = true)
data class EmailData(
    @Json(name = "UserName")
    var userName: String? = null
)


@JsonClass(generateAdapter = true)
data class EmailExistencyResponse(
    var result: Int? = null
)


