package com.example.hrjdemo.ui.theme.utils.model

import android.graphics.Bitmap
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/*

@JsonClass(generateAdapter = true)
data class EnrollPlumberRequest(
    @Json(name = "actiontype")
    var actiontype: String? = null,
    @Json(name = "lstidentityinfo")
    var lstidentityinfo: List<Lstidentityinfo>? = null,
    @Json(name = "ObjCustomerJson")
    var objCustomerJson: ObjCustomerJson? = null
)

@JsonClass(generateAdapter = true)
data class Lstidentityinfo(
    @Json(name = "IdentityDocument")
    var identityDocument: String? = null,
    @Json(name = "identityid")
    var identityid: String? = null,
    @Json(name = "identityno")
    var identityno: String? = null,
    @Json(name = "identitytype")
    var identitytype: String? = null,
    @Json(name = "IsNewIdentity")
    var isNewIdentity: String? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJson(
    @Json(name = "Address1")
    var address1: String? = null,
    @Json(name = "Anniversary")
    var anniversary: String? = null,
    @Json(name = "CSMUserid")
    var cSMUserid: String? = null,
    @Json(name = "CityId")
    var cityId: String? = null,
    @Json(name = "CountryId")
    var countryId: String? = null,
    @Json(name = "CustomerTypeId")
    var customerTypeId: String? = null,
    @Json(name = "DOB")
    var dOB: String? = null,
    @Json(name = "Email")
    var email: String? = null,
    @Json(name = "FirmName")
    var firmName: String? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "Gender")
    var gender: String? = null,
    @Json(name = "IsSmartphone")
    var isSmartphone: String? = null,
    @Json(name = "IsWhatsapp")
    var isWhatsapp: String? = null,
    @Json(name = "LanguageId")
    var languageId: String? = null,
    @Json(name = "MappedDealerID")
    var mappedDealerID: String? = null,
    @Json(name = "MerchantId")
    var merchantId: String? = null,
    @Json(name = "Mobile")
    var mobile: String? = null,
    @Json(name = "NativeStateId")
    var nativeStateId: String? = null,
    @Json(name = "PlumberMap")
    var plumberMap: String? = null,
    @Json(name = "RegistrationSource")
    var registrationSource: String? = null,
    @Json(name = "StateId")
    var stateId: String? = null,
    @Json(name = "TerritoryId")
    var territoryId: String? = null,
    @Json(name = "Zip")
    var zip: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)
*/


@JsonClass(generateAdapter = true)
data class EnrollPlumberRequest(
    @Json(name = "actiontype")
    var actiontype: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "ObjCustomerJson")
    var objCustomerJson: ObjCustomerJson? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJson(
    @Json(name = "Address1")
    var address1: String? = null,
    @Json(name = "Anniversary")
    var anniversary: String? = null,
    @Json(name = "CSMUserid")
    var cSMUserid: String? = null,
    @Json(name = "CityId")
    var cityId: String? = null,
    @Json(name = "CountryId")
    var countryId: String? = null,
    @Json(name = "CustomerTypeId")
    var customerTypeId: String? = null,
    @Json(name = "DOB")
    var dOB: String? = null,
    @Json(name = "Email")
    var email: String? = null,
    @Json(name = "FirmName")
    var firmName: String? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "Gender")
    var gender: String? = null,
    @Json(name = "IsSmartphone")
    var isSmartphone: String? = null,
    @Json(name = "IsWhatsapp")
    var isWhatsapp: String? = null,
    @Json(name = "LanguageId")
    var languageId: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "MappedDealerID")
    var mappedDealerID: String? = null,
    @Json(name = "MerchantId")
    var merchantId: String? = null,
    @Json(name = "Mobile")
    var mobile: String? = null,
    @Json(name = "NativeStateId")
    var nativeStateId: String? = null,
    @Json(name = "PlumberMap")
    var plumberMap: String? = null,
    @Json(name = "RegistrationSource")
    var registrationSource: String? = null,
    @Json(name = "StateId")
    var stateId: String? = null,
    @Json(name = "TerritoryId")
    var territoryId: String? = null,
    @Json(name = "Zip")
    var zip: String? = null,
    @Json(name = "UpiHolderName")
    var upiHolderName: String? = null,
    @Json(name = "UpiId")
    var upiId: String? = null,
    @Json(name = "UpiAttachment")
    var upiAttachment: String? = null,

):java.io.Serializable

@JsonClass(generateAdapter = true)
data class EnrollPlumberResponse(
    @Json(name = "lstCustomer")
    var lstCustomer: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)