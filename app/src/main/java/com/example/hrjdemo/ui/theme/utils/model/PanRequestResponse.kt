package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

//Get Pan Details
@JsonClass(generateAdapter = true)
data class PanRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)

@JsonClass(generateAdapter = true)
data class PanResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: List<LstPanDetailPan>? = null,
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
data class LstPanDetailPan(
    @Json(name = "aAdharId")
    var aAdharId: Any? = null,
    @Json(name = "aAdharName")
    var aAdharName: Any? = null,
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
    var panId: String? = null,
    @Json(name = "panImage")
    var panImage: String? = null,
    @Json(name = "panName")
    var panName: String? = null,
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


//Pan Register Attempt

@JsonClass(generateAdapter = true)
data class RegisterAttemptRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "IdentificationId")
    var identificationId: Int? = null,
    @Json(name = "IsActive")
    var isActive: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "userid")
    var userid: Int? = null
)
@JsonClass(generateAdapter = true)
data class RegisterAttemptResponse(
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)


/*Pan Existency Request*/
@JsonClass(generateAdapter = true)
data class PanExistencyRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Location")
    var location: LocationPan? = null
)

@JsonClass(generateAdapter = true)
data class LocationPan(
    @Json(name = "UserName")
    var userName: String? = null
)

/*Pan Existency Response*/
@JsonClass(generateAdapter = true)
data class PanExistencyResponse(
    @Json(name = "returnMessage")
    val returnMessage: Any? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "totalRecords")
    val totalRecords: Int? = null
)

/*Pan Validation Request*/
@JsonClass(generateAdapter = true)
data class PanValidateRequest(
    @Json(name = "ActorId")
    var ActorId: String? = null,
    @Json(name = "AAdharNumber")
    var aAdharNumber: String? = null,
    @Json(name = "DateOfBirth")
    var dateOfBirth: String? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "MobileNumber")
    var mobile: String? = null,
    @Json(name = "PanNumber")
    var panNumber: String? = null,

)

@JsonClass(generateAdapter = true)
data class PanValidateResponse(
    @Json(name = "lstPanDetails")
    var lstPanDetails: Any? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    var objPanDetailsRetrieverequest: ObjPanDetailsRetrieverequest? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

/*Pan Validation Response*/
@JsonClass(generateAdapter = true)
data class ObjPanDetailsRetrieverequest(
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
    var firstName: String? = null,
    @Json(name = "identificationList")
    var identificationList: Any? = null,
    @Json(name = "identity_ID")
    var identityID: Int? = null,
    @Json(name = "identityStatus")
    var identityStatus: Any? = null,
    @Json(name = "isAAdharValid")
    var isAAdharValid: Int? = null,
    @Json(name = "isAAdharPANlinkStatus")
    var isAAdharPANlinkStatus: Int? = null,
    @Json(name = "isAAdharValidMessage")
    var isAAdharValidMessage: String? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "isPanValid")
    var isPanValid: Int? = null,
    @Json(name = "l_IdentityTypeID")
    var lIdentityTypeID: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: Any? = null,
    @Json(name = "otp")
    var otp: Any? = null,
    @Json(name = "panImage")
    var panImage: Any? = null,
    @Json(name = "panNumber")
    var panNumber: String? = null,
    @Json(name = "promotID")
    var promotID: String? = null,
    @Json(name = "refferID")
    var refferID: Any? = null,
    @Json(name = "responseCode")
    var responseCode: Int? = null,
    @Json(name = "token")
    var token: Any? = null,
    @Json(name = "transactionID")
    var transactionID: Any? = null
)

/*Pan details save Request*/
@JsonClass(generateAdapter = true)
data class SavePanDetailsRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "IsPanValid")
    var isPanValid: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "PanNumber")
    var panNumber: String? = null
)

/*Pan details save Response*/
@JsonClass(generateAdapter = true)
data class SavePanDetailsResponse(
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

/*Get Pan Details Request*/
@JsonClass(generateAdapter = true)
data class GetIDProofDetailsRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "ActorId")
    val actorId: String? = null,
    @Json(name = "LoyaltyId")
    val loyaltyId: String? = null
)

/*Get Pan Details Response*/
@JsonClass(generateAdapter = true)
data class GetIDProofDetailsResponse(
    @Json(name = "lstPanDetails")
    val lstPanDetails: List<LstPanDetail?>? = null,
    @Json(name = "objPanDetailsRetrieverequest")
    val objPanDetailsRetrieverequest: Any? = null,
    @Json(name = "returnMessage")
    val returnMessage: Any? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "totalRecords")
    val totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstPanDetail(
    @Json(name = "aAdharId")
    val aAdharId: Any? = null,
    @Json(name = "aAdharImage")
    val aAdharImage: Any? = null,
    @Json(name = "aAdharName")
    val aAdharName: String? = null,
    @Json(name = "adharId")
    val adharId: Any? = null,
    @Json(name = "adharIdentity_ID")
    val adharIdentityID: Int? = null,
    @Json(name = "adharName")
    val adharName: Any? = null,
    @Json(name = "code")
    val code: Int? = null,
    @Json(name = "data")
    val `data`: Any? = null,
    @Json(name = "dateOfBirth")
    val dateOfBirth: Any? = null,
    @Json(name = "dob")
    val dob: Any? = null,
    @Json(name = "firstName")
    val firstName: Any? = null,
    @Json(name = "identity_ID")
    val identityID: Int? = null,
    @Json(name = "identityName")
    val identityName: Any? = null,
    @Json(name = "identityNumber")
    val identityNumber: Any? = null,
    @Json(name = "isAAdharValid")
    val isAAdharValid: Int? = null,
    @Json(name = "isPanValid")
    val isPanValid: Int? = null,
    @Json(name = "isVerified")
    val isVerified: Any? = null,
    @Json(name = "l_IdentityTypeID")
    val lIdentityTypeID: Int? = null,
    @Json(name = "lastName")
    val lastName: Any? = null,
    @Json(name = "loyaltyId")
    val loyaltyId: Any? = null,
    @Json(name = "modifiedBy")
    val modifiedBy: Int? = null,
    @Json(name = "modifiedDate")
    val modifiedDate: Any? = null,
    @Json(name = "otherId")
    val otherId: Any? = null,
    @Json(name = "otherName")
    val otherName: Any? = null,
    @Json(name = "otherrIdentity_ID")
    val otherrIdentityID: Int? = null,
    @Json(name = "panId")
    val panId: Any? = null,
    @Json(name = "panImage")
    val panImage: Any? = null,
    @Json(name = "panName")
    val panName: String? = null,
    @Json(name = "panNumber")
    val panNumber: Any? = null,
    @Json(name = "referenceCheckImg")
    val referenceCheckImg: Any? = null,
    @Json(name = "referenceStatus")
    val referenceStatus: Int? = null,
    @Json(name = "referenceTypeID")
    val referenceTypeID: Int? = null,
    @Json(name = "reffer_ID")
    val refferID: Any? = null,
    @Json(name = "remarks")
    val remarks: Any? = null,
    @Json(name = "result")
    val result: String? = null,
    @Json(name = "status")
    val status: Any? = null,
    @Json(name = "timestamp")
    val timestamp: Int? = null,
    @Json(name = "transaction_id")
    val transactionId: Any? = null,
    @Json(name = "verifiedBy")
    val verifiedBy: Any? = null,
    @Json(name = "verifiedStatus")
    val verifiedStatus: Any? = null
)