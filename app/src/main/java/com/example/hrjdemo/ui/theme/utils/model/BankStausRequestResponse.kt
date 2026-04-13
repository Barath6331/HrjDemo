package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


// Request
@JsonClass(generateAdapter = true)
data class BankNWalletRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null
)

// Response
@JsonClass(generateAdapter = true)
data class BankNWalletResponse(
    @Json(name = "lstCustBankDetailsApproval")
    var lstCustBankDetailsApproval: List<LstCustBankDetailsApprovalBank>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstCustBankDetailsApprovalBank(
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
    @Json(name = "dob")
    var dob: Any? = null,
    @Json(name = "emailId")
    var emailId: Any? = null,
    @Json(name = "firstName")
    var firstName: Any? = null,
    @Json(name = "ifscCode")
    var ifscCode: String? = null,
    @Json(name = "isEdit")
    var isEdit: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "loyaltyID")
    var loyaltyID: Any? = null,
    @Json(name = "mobile")
    var mobile: Any? = null,
    @Json(name = "nameStatus")
    var nameStatus: Any? = null,
    @Json(name = "panName")
    var panName: Any? = null,
    @Json(name = "panNameStatus")
    var panNameStatus: Any? = null,
    @Json(name = "panNo")
    var panNo: Any? = null,
    @Json(name = "pointConversion")
    var pointConversion: Int? = null,
    @Json(name = "remarks")
    var remarks: Any? = null,
    @Json(name = "tdsRule")
    var tdsRule: Int? = null,
    @Json(name = "tdsPercentage")
    var tdsPercentage: Int? = null,
    @Json(name = "uniqueId")
    var uniqueId: Any? = null,
    @Json(name = "upi")
    var upi: Any? = null,
    @Json(name = "upiAccountStatus")
    var upiAccountStatus: Int? = null,
    @Json(name = "upiStatus")
    var upiStatus: String? = null,
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
    var walletVerifiedStatus: Boolean? = null,
)