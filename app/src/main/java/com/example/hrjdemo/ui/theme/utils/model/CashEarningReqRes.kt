package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

/*** Cash Earning Request ***/

@JsonClass(generateAdapter = true)
data class CashEarningRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "FromDate")
    val fromDate: String? = null,
    @Json(name = "Status")
    val status: String? = null,
    @Json(name = "ToDate")
    val toDate: String? = null,
    @Json(name = "UserId")
    val userId: String? = null,
    @Json(name = "StartIndex")
    var startIndex: Int? = null,
    @Json(name = "PageSize")
    var pageSize: Int? = null
)

/*** Cash Earning Response ***/
@JsonClass(generateAdapter = true)
data class CashEarningResponse(
    @Json(name = "objCustomerAccountInfo")
    val objCustomerAccountInfo: List<ObjCustomerAccountInfo>? = null,
    @Json(name = "returnMessage")
    val returnMessage: Any? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "totalRecords")
    val totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerAccountInfo(
    @Json(name = "absent_Count")
    val absentCount: Int? = null,
    @Json(name = "accountStatusId")
    val accountStatusId: Int? = null,
    @Json(name = "address")
    val address: Any? = null,
    @Json(name = "attendanceDate")
    val attendanceDate: String? = null,
    @Json(name = "bonusDate")
    val bonusDate: Any? = null,
    @Json(name = "bonusName")
    val bonusName: String? = null,
    @Json(name = "bonusValue")
    val bonusValue: Any? = null,
    @Json(name = "callRemarks")
    val callRemarks: Any? = null,
    @Json(name = "callStatusId")
    val callStatusId: Int? = null,
    @Json(name = "cashBack")
    val cashBack: Int? = null,
    @Json(name = "cashBackValue")
    val cashBackValue: Int? = null,
    @Json(name = "cashEarning")
    val cashEarning: Int? = null,
    @Json(name = "catalougeId")
    val catalougeId: Int? = null,
    @Json(name = "color")
    val color: Any? = null,
    @Json(name = "company")
    val company: Any? = null,
    @Json(name = "customerGrade")
    val customerGrade: Any? = null,
    @Json(name = "customerId")
    val customerId: Int? = null,
    @Json(name = "customerImage")
    val customerImage: Any? = null,
    @Json(name = "customerLogo")
    val customerLogo: Any? = null,
    @Json(name = "designation")
    val designation: Any? = null,
    @Json(name = "district")
    val district: Any? = null,
    @Json(name = "encashBalance")
    val encashBalance: Int? = null,
    @Json(name = "firstName")
    val firstName: Any? = null,
    @Json(name = "isBlacklisted")
    val isBlacklisted: Int? = null,
    @Json(name = "isConnected")
    val isConnected: Boolean? = null,
    @Json(name = "isDormant")
    val isDormant: Int? = null,
    @Json(name = "isOnHold")
    val isOnHold: Int? = null,
    @Json(name = "issueDescription")
    val issueDescription: Any? = null,
    @Json(name = "languageId")
    val languageId: Int? = null,
    @Json(name = "languageName")
    val languageName: Any? = null,
    @Json(name = "lastName")
    val lastName: Any? = null,
    @Json(name = "liveClassRoom")
    val liveClassRoom: Int? = null,
    @Json(name = "locationId")
    val locationId: Int? = null,
    @Json(name = "locationName")
    val locationName: Any? = null,
    @Json(name = "loyaltyId")
    val loyaltyId: Any? = null,
    @Json(name = "merchantId")
    val merchantId: Int? = null,
    @Json(name = "month_Name")
    val monthName: Any? = null,
    @Json(name = "month_No")
    val monthNo: Int? = null,
    @Json(name = "nativeStateId")
    val nativeStateId: Int? = null,
    @Json(name = "nativeStateName")
    val nativeStateName: Any? = null,
    @Json(name = "newPassword")
    val newPassword: Any? = null,
    @Json(name = "nomineeAge")
    val nomineeAge: Int? = null,
    @Json(name = "nomineeRelationShipId")
    val nomineeRelationShipId: Int? = null,
    @Json(name = "onlineAcademy")
    val onlineAcademy: Int? = null,
    @Json(name = "ownerName")
    val ownerName: Any? = null,
    @Json(name = "pinStatus")
    val pinStatus: Int? = null,
    @Json(name = "pointBalance")
    val pointBalance: Int? = null,
    @Json(name = "present")
    val present: Boolean? = null,
    @Json(name = "present_Count")
    val presentCount: Int? = null,
    @Json(name = "profilePicture")
    val profilePicture: Any? = null,
    @Json(name = "redemptionDate")
    val redemptionDate: String? = null,
    @Json(name = "redemptionId")
    val redemptionId: Int? = null,
    @Json(name = "redemptionThreshold")
    val redemptionThreshold: Int? = null,
    @Json(name = "referenceNo")
    val referenceNo: String? = null,
    @Json(name = "referralCode")
    val referralCode: Any? = null,
    @Json(name = "remarks")
    val remarks: String? = null,
    @Json(name = "requiredPoints")
    val requiredPoints: Int? = null,
    @Json(name = "sfaCode")
    val sfaCode: Any? = null,
    @Json(name = "status")
    val status: String? = null,
    @Json(name = "storeName")
    val storeName: Any? = null,
    @Json(name = "tahasilImage")
    val tahasilImage: Any? = null,
    @Json(name = "tardy")
    val tardy: Boolean? = null,
    @Json(name = "tardy_Count")
    val tardyCount: Int? = null,
    @Json(name = "title")
    val title: Any? = null,
    @Json(name = "userId")
    val userId: Int? = null,
    @Json(name = "verificationStatus")
    val verificationStatus: Any? = null,
    @Json(name = "verifiedStatus")
    val verifiedStatus: Int? = null,
    @Json(name = "walletNumber")
    val walletNumber: Any? = null,
    @Json(name = "cashPaid")
    val cashPaid: String? = null,
    @Json(name = "redemptionRefNo")
    val redemptionRefNo: String? = null,
    @Json(name = "tdS_percentage")
    val tdS_percentage: String? = null,
    @Json(name = "applicableTDS")
    val applicableTDS: String? = null
)

/*** Claim Submit Request ***/
@JsonClass(generateAdapter = true)
data class ClaimSubmitRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "objCustomerAccountInfo")
    val objCustomerAccountInfo: ObjCustomerAccountInfoClaimSubmit? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerAccountInfoClaimSubmit(
    @Json(name = "RedemptionId")
    val redemptionId: String? = null,
    @Json(name = "UserId")
    val userId: String? = null
)

/*** Claim Submit Response ***/
@JsonClass(generateAdapter = true)
data class ClaimSubmitResponse(
    @Json(name = "objCustomerAccountInfo")
    val objCustomerAccountInfo: Any? = null,
    @Json(name = "returnMessage")
    val returnMessage: Any? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "totalRecords")
    val totalRecords: Int? = null
)

/*** Common Spinner ***/
data class CommonSpinnerss(
    var name: String? = null,
    var id: Int? = null,
)

