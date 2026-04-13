package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

//Get Aadhaar Details
@JsonClass(generateAdapter = true)
data class AadhaarRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)

@JsonClass(generateAdapter = true)
data class AadhaarResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: List<LstPanDetailAadhaar>? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    var objPanDetailsRetrieverequest: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstPanDetailAadhaar(
    @Json(name = "aAdharId")
    var aAdharId: String? = null,
    @Json(name = "aAdharName")
    var aAdharName: String? = null,
    @Json(name = "aadharImageFront")
    var aadharImageFront: String? = null,
    @Json(name = "aadharImageBack")
    var aadharImageBack: String? = null,
    @Json(name = "code")
    var code: Int? = null,
    @Json(name = "data")
    var `data`: Any? = null,
    @Json(name = "dob")
    var dob: String? = null,
    @Json(name = "isVerified")
    var isVerified: String? = null,
    @Json(name = "message")
    var message: Any? = null,
    @Json(name = "modifiedBy")
    var modifiedBy: Int? = null,
    @Json(name = "modifiedDate")
    var modifiedDate: String? = null,
    @Json(name = "panId")
    var panId: Any? = null,
    @Json(name = "panImage")
    var panImage: Any? = null,
    @Json(name = "panName")
    var panName: Any? = null,
    @Json(name = "result")
    var result: String? = null,
    @Json(name = "remarks")
    var remarks: String? = null,
    @Json(name = "status")
    var status: Any? = null,
    @Json(name = "timestamp")
    var timestamp: Int? = null,
    @Json(name = "transaction_id")
    var transactionId: Any? = null,
    @Json(name = "verifiedBy")
    var verifiedBy: String? = null,
    @Json(name = "verifiedStatus")
    var verifiedStatus: Any? = null
)

//Aadhaar Register Attempt
@JsonClass(generateAdapter = true)
data class AadhaarRegisterAttemptRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "IdentificationId")
    var identificationId: Int? = null,
    @Json(name = "LoyaltyID")
    var loyaltyID: String? = null
)
@JsonClass(generateAdapter = true)
data class AadhaarRegisterAttemptResponse(
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

//Aadhaar Existency Request
@JsonClass(generateAdapter = true)
data class AadhaarExistencyRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Location")
    var location: LocationsAadhaar? = null
)

@JsonClass(generateAdapter = true)
data class LocationsAadhaar(
    @Json(name = "UserName")
    var userName: String? = null
)

//Aadhaar Existency Response
@JsonClass(generateAdapter = true)
data class AadhaarExistencyResponse(
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

/**Aadhaar validate Request */
@JsonClass(generateAdapter = true)
data class AadhaarValidateRequest(
    @Json(name = "AAdharNumber")
    var aAdharNumber: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "MobileNumber")
    var mobileNumber: String? = null
)

//Aadhaar validate Response
@JsonClass(generateAdapter = true)
data class AadhaarValidateResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: Any? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    var objPanDetailsRetrieverequest: ObjPanDetailsRetrieverequests? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class ObjPanDetailsRetrieverequests(
    @Json(name = "aAdharImage")
    var aAdharImage: Any? = null,
    @Json(name = "aAdharNumber")
    var aAdharNumber: Any? = null,
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "actorId")
    var actorId: Int? = null,
    @Json(name = "actorRole")
    var actorRole: Any? = null,
    @Json(name = "checkReferenceList")
    var checkReferenceList: Any? = null,
    @Json(name = "dateOfBirth")
    var dateOfBirth: Any? = null,
    @Json(name = "firstName")
    var firstName: Any? = null,
    @Json(name = "identificationList")
    var identificationList: Any? = null,
    @Json(name = "identity_ID")
    var identityID: Int? = null,
    @Json(name = "identityStatus")
    var identityStatus: String? = null,
    @Json(name = "isAAdharValid")
    var isAAdharValid: Int? = null,
    @Json(name = "isAAdharValidMessage")
    var isAAdharValidMessage: Any? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "isPanValid")
    var isPanValid: Int? = null,
    @Json(name = "l_IdentityTypeID")
    var lIdentityTypeID: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "otp")
    var otp: Any? = null,
    @Json(name = "panImage")
    var panImage: Any? = null,
    @Json(name = "panNumber")
    var panNumber: Any? = null,
    @Json(name = "promotID")
    var promotID: String? = null,
    @Json(name = "refferID")
    var refferID: Any? = null,
    @Json(name = "responseCode")
    var responseCode: Int? = null,
    @Json(name = "token")
    var token: Any? = null,
    @Json(name = "transactionID")
    var transactionID: String? = null
)

//Aadhaar validate OTP Request*/
@JsonClass(generateAdapter = true)
data class AadhaarOTPRequest(
    @Json(name = "AAdharNumber")
    var aAdharNumber: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "OTP")
    var oTP: String? = null,
    @Json(name = "RefferID")
    var refferID: String? = null,
    @Json(name = "MobileNumber")
    var mobileNumber: String? = null
)

//Aadhaar validate OTP Response*/
@JsonClass(generateAdapter = true)
data class AadhaarOTPResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: Any? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    var objPanDetailsRetrieverequest: ObjPanDetailsRetrieverequestss? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class ObjPanDetailsRetrieverequestss(
    @Json(name = "aAdharImage")
    var aAdharImage: Any? = null,
    @Json(name = "aAdharNumber")
    var aAdharNumber: String? = null,
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "actorId")
    var actorId: Int? = null,
    @Json(name = "actorRole")
    var actorRole: Any? = null,
    @Json(name = "address")
    var address: String? = null,
    @Json(name = "dateOfBirth")
    var dateOfBirth: String? = null,
    @Json(name = "firstName")
    var firstName: String? = null,
    @Json(name = "gender")
    var gender: String? = null,
    @Json(name = "identityStatus")
    var identityStatus: String? = null,
    @Json(name = "isAAdharPANlinkStatus")
    var isAAdharPANlinkStatus: Int? = null,
    @Json(name = "isAAdharValid")
    var isAAdharValid: Int? = null,
    @Json(name = "isAAdharValidMessage")
    var isAAdharValidMessage: Any? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "isNameAsPerPan")
    var isNameAsPerPan: Any? = null,
    @Json(name = "isPanValid")
    var isPanValid: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "otp")
    var otp: Any? = null,
    @Json(name = "panImage")
    var panImage: Any? = null,
    @Json(name = "panNumber")
    var panNumber: Any? = null,
    @Json(name = "panStatus")
    var panStatus: Any? = null,
    @Json(name = "promotID")
    var promotID: String? = null,
    @Json(name = "refferID")
    var refferID: Any? = null,
    @Json(name = "responseCode")
    var responseCode: Int? = null,
    @Json(name = "token")
    var token: Any? = null,
    @Json(name = "transactionID")
    var transactionID: String? = null
)



//save aadhaar details request

@JsonClass(generateAdapter = true)
data class SaveAadhaarReqeust(
    @Json(name = "AAdharNumber")
    var aAdharNumber: String? = null,
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "IdentityDocumentBack")
    var identityDocumentBack: String? = null,
    @Json(name = "IdentityDocumentFront")
    var identityDocumentFront: String? = null,
    @Json(name = "IsAAdharValid")
    var isAAdharValid: Int? = null,
    @Json(name = "IsBackImage")
    var isBackImage: Int? = null,
    @Json(name = "IsFrontImage")
    var isFrontImage: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)

//save aadhaar details response

@JsonClass(generateAdapter = true)
data class SaveAadhaarResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: Any? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    var objPanDetailsRetrieverequest: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)