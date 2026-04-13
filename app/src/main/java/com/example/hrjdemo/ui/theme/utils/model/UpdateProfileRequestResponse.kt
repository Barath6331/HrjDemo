package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class UpdateProfileRequest(
    var ActionType: String? = null,
    var ActorId: String? = null,
    var IsMobileRequest: Int? = null,
    var ObjCustomerDetails: ObjCustomerDetailss? = null,
    var lstCustomerOfficalInfoJson: lstCustomerOfficalInfoJsons? = null,
    var ObjCustomerJson: ObjCustomerJsonsss? = null
)

@JsonClass(generateAdapter = true)
data class lstCustomerOfficalInfoJsons(
    var BankTransferMode: String? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerDetailss(
    var JAnniversary: String? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJsonsss(
    var AccountNumber: String? = null,
    var AcountHolderName: String? = null,
    var Address1: String? = null,
    var AddressId: Int? = null,
    var BankName: String? = null,
    var CustomerId: String? = null,
    var CustomerTypeID: Int? = null,
    var Email: String? = null,
    var FirstName: String? = null,
    var IFSCCode: String? = null,
    var IsActive: String? = null,
    var JDOB: String? = null,
    var LoyaltyIdAutoGen: String? = null,
    var MerchantId: Int? = null,
    var CountryId: Int? = null,
    var LocationId: Int? = null,
    var Mobile: String? = null,
    var RegStatusid: Int? = null,
    var RegistrationSource: String? = null,
    var StateId: String? = null,
    var WalletNumber: String? = null,
    var Zip: String? = null,
    var cityid: String? = null,
    var BankTransferMode: String? = null,
    var BankPassbookImage: String? = null,
    var UPI_ID: String? = null,
    var loyaltyId: String? = null
)

/*Update Profile Response*/
@JsonClass(generateAdapter = true)
data class UpdateProfileResponse(
    var returnMessage: String? = null,
    var returnValue: Int? = null,
    var totalRecords: Int? = null
)


/*Update Profile Image Request*/

@JsonClass(generateAdapter = true)
data class UpdateProfileImageRequest(
    val ActorId: String? = null,
    val ObjCustomerJson: ObjCustomerJsons? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJsons(
    val LoyaltyId: String? = null,
    val DisplayImage: String? = null
)

/*Update Profile Image Response*/
@JsonClass(generateAdapter = true)
data class UpdateProfileImageResponse(
    var returnMessage: String? = null,
    var returnValue: Int? = null,
    var totalRecords: Int? = null
)
