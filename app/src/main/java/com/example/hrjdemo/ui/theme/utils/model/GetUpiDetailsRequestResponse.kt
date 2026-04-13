package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json



//Get upi request
@JsonClass(generateAdapter = true)
data class GetUpiRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null
)



//Get upi response
@JsonClass(generateAdapter = true)
data class GetUpiResponse(
    @Json(name = "lstCustBankDetailsApproval")
    var lstCustBankDetailsApproval: List<LstCustBankDetailsApproval?>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstCustBankDetailsApproval(
    @Json(name = "aadharNameStatus")
    var aadharNameStatus: Any? = null,
    @Json(name = "aadharNo")
    var aadharNo: Any? = null,
    @Json(name = "accountNumber")
    var accountNumber: String? = null,
    @Json(name = "accountStatus")
    var accountStatus: Any? = null,
    @Json(name = "accountStatusID")
    var accountStatusID: Int? = null,
    @Json(name = "acountHolderName")
    var acountHolderName: String? = null,
    @Json(name = "approvedBy")
    var approvedBy: Any? = null,
    @Json(name = "approvedDate")
    var approvedDate: String? = null,
    @Json(name = "bankBranch")
    var bankBranch: Any? = null,
    @Json(name = "bankDetailImage")
    var bankDetailImage: Any? = null,
    @Json(name = "bankDetailsID")
    var bankDetailsID: Int? = null,
    @Json(name = "bankName")
    var bankName: String? = null,
    @Json(name = "bankReferenceId")
    var bankReferenceId: Any? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "customerID")
    var customerID: Int? = null,
    @Json(name = "customerStatus")
    var customerStatus: Any? = null,
    @Json(name = "customerType")
    var customerType: Any? = null,
    @Json(name = "dob")
    var dob: Any? = null,
    @Json(name = "emailId")
    var emailId: Any? = null,
    @Json(name = "firstName")
    var firstName: Any? = null,
    @Json(name = "identityId")
    var identityId: Int? = null,
    @Json(name = "ifscCode")
    var ifscCode: String? = null,
    @Json(name = "isEdit")
    var isEdit: Int? = null,
    @Json(name = "isVerfied")
    var isVerfied: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "loyaltyID")
    var loyaltyID: Any? = null,
    @Json(name = "mobile")
    var mobile: Any? = null,
    @Json(name = "nameStatus")
    var nameStatus: Any? = null,
    @Json(name = "panBankAttachment")
    var panBankAttachment: Any? = null,
    @Json(name = "panFrontAttachment")
    var panFrontAttachment: Any? = null,
    @Json(name = "panName")
    var panName: Any? = null,
    @Json(name = "panNameStatus")
    var panNameStatus: Any? = null,
    @Json(name = "panNo")
    var panNo: Any? = null,
    @Json(name = "pointConversion")
    var pointConversion: Double? = null,
    @Json(name = "profileStatus")
    var profileStatus: Any? = null,
    @Json(name = "proofStatus")
    var proofStatus: Any? = null,
    @Json(name = "remarks")
    var remarks: Any? = null,
    @Json(name = "tdsPercentage")
    var tdsPercentage: Int? = null,
    @Json(name = "tdsRule")
    var tdsRule: Int? = null,
    @Json(name = "uniqueId")
    var uniqueId: Any? = null,
    @Json(name = "upI_ID")
    var upIID: String? = null,
    @Json(name = "upi")
    var upi: Any? = null,
    @Json(name = "upiAccountStatus")
    var upiAccountStatus: Int? = null,
    @Json(name = "upiAttachment")
    var upiAttachment: Any? = null,
    @Json(name = "upiName")
    var upiName: Any? = null,
    @Json(name = "upiStatus")
    var upiStatus: String? = null,
    @Json(name = "uploadedBy")
    var uploadedBy: Any? = null,
    @Json(name = "verificationStatus")
    var verificationStatus: Int? = null,
    @Json(name = "walletAccountStatus")
    var walletAccountStatus: Int? = null,
    @Json(name = "walletFullName")
    var walletFullName: Any? = null,
    @Json(name = "walletNumber")
    var walletNumber: Any? = null,
    @Json(name = "walletStatus")
    var walletStatus: Any? = null,
    @Json(name = "walletVerifiedStatus")
    var walletVerifiedStatus: Boolean? = null
)


//Upi Sumbission Request

@JsonClass(generateAdapter = true)
data class UpiSumbissionRequests(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "CustomerUserID")
    var customerUserID: String? = null,
    @Json(name = "ObjCatalogueDetails")
    var objCatalogueDetails: Upi? = null,
    @Json(name = "SourceMode")
    var sourceMode: String? = null,
    @Json(name = "TransferMode")
    var transferMode: String? = null
)

@JsonClass(generateAdapter = true)
data class Upi(
    @Json(name = "CatalogueId")
    var catalogueId: String? = null,
    @Json(name = "DomainName")
    var domainName: String? = null,
    @Json(name = "NoOfPointsDebit")
    var noOfPointsDebit: String? = null,
    @Json(name = "RedemptionTypeId")
    var redemptionTypeId: String? = null,
    @Json(name = "UPI_ID")
    var uPIID: String? = null,
    @Json(name = "UPIName")
    var upiName: String? = null,
)


//Upi Sumbission Response

@JsonClass(generateAdapter = true)
data class UpiSumbissionResponses(
    @Json(name = "membershipID")
    var membershipID: Any? = null,
    @Json(name = "objCatalogueList")
    var objCatalogueList: Any? = null,
    @Json(name = "pdfLink")
    var pdfLink: Any? = null,
    @Json(name = "redemptionReferenceNumber")
    var redemptionReferenceNumber: Any? = null,
    @Json(name = "redemptionStatus")
    var redemptionStatus: Any? = null,
    @Json(name = "responseCode")
    var responseCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null,
    @Json(name = "uniqueID")
    var uniqueID: Any? = null,
    @Json(name = "userId")
    var userId: Int? = null
)