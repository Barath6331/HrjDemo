package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


/*  State Request */
@JsonClass(generateAdapter = true)
data class StateListRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "CountryID")
    val countryID: String? = null,
    @Json(name = "IsActive")
    val isActive: String? = null,
    @Json(name = "SortColumn")
    val sortColumn: String? = null,
    @Json(name = "SortOrder")
    val sortOrder: String? = null,
    @Json(name = "StartIndex")
    val startIndex: String? = null
)

/*  State Response */
@JsonClass(generateAdapter = true)
data class StateListResponse(
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "stateList")
    var stateList: List<StateList>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class StateList(
    @Json(name = "countryCode")
    var countryCode: Any? = null,
    @Json(name = "countryId")
    var countryId: Int? = null,
    @Json(name = "countryName")
    var countryName: String? = null,
    @Json(name = "countryType")
    var countryType: Any? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "mobilePrefix")
    var mobilePrefix: Any? = null,
    @Json(name = "row")
    var row: Int? = null,
    @Json(name = "stateCode")
    var stateCode: String? = null,
    @Json(name = "stateId")
    var stateId: Int? = null,
    @Json(name = "stateName")
    var stateName: String? = null
)

/*  City Request */

@JsonClass(generateAdapter = true)
data class CityListRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "IsActive")
    val isActive: String? = null,
    @Json(name = "SortColumn")
    val sortColumn: String? = null,
    @Json(name = "SortOrder")
    val sortOrder: String? = null,
    @Json(name = "StartIndex")
    val startIndex: String? = null,
    @Json(name = "StateId")
    val stateId: String? = null
)

/*  City Response */

@JsonClass(generateAdapter = true)
data class CityListResponse(
    @Json(name = "cityList")
    val cityList: List<City>? = null,
    @Json(name = "returnMessage")
    val returnMessage: Any? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "totalRecords")
    val totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class City(
    @Json(name = "cityCode")
    val cityCode: String? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: String? = null,
    @Json(name = "countryCode")
    val countryCode: Any? = null,
    @Json(name = "countryId")
    val countryId: Int? = null,
    @Json(name = "countryName")
    val countryName: Any? = null,
    @Json(name = "countryType")
    val countryType: Any? = null,
    @Json(name = "isActive")
    val isActive: Boolean? = null,
    @Json(name = "mobilePrefix")
    val mobilePrefix: Any? = null,
    @Json(name = "row")
    val row: Int? = null,
    @Json(name = "stateCode")
    val stateCode: Any? = null,
    @Json(name = "stateId")
    val stateId: Int? = null,
    @Json(name = "stateName")
    val stateName: String? = null
)

/*Customer Verify Request */
@JsonClass(generateAdapter = true)
data class CheckCustomerRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "Location")
    val location: Location? = null
)

@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "UserName")
    val userName: String? = null
)


/*Customer Verify Response */
@JsonClass(generateAdapter = true)
data class CheckCustomerResponse(
    @Json(name = "CheckCustomerExistancyAndVerificationJsonResult")
    val checkCustomerExistancyAndVerificationJsonResult: Int? = null
)

/* OTP Request */
@JsonClass(generateAdapter = true)
data class OtpRequest(
    @Json(name = "MerchantUserName")
    val merchantUserName: String? = null,
    @Json(name = "MobileNo")
    val mobileNo: String? = null,
    @Json(name = "OTPType")
    val oTPType: String? = null,
    @Json(name = "EmailID")
    val emailID: String? = null,
    @Json(name = "UserId")
    val userId: String? = null,
    @Json(name = "UserName")
    val userName: String? = null,
    @Json(name = "Name")
    val name: String? = null
)

/* OTP Response */
@JsonClass(generateAdapter = true)
data class OtpResponse(
    @Json(name = "adminList")
    val adminList: Any? = null,
    @Json(name = "merchantEmailSMSDetails")
    val merchantEmailSMSDetails: Any? = null,
    @Json(name = "merchantEmailSMSParameterDetails")
    val merchantEmailSMSParameterDetails: Any? = null,
    @Json(name = "returnMessage")
    val returnMessage: String? = null,
    @Json(name = "returnValue")
    val returnValue: Int? = null,
    @Json(name = "TotalRecords")
    val totalRecords: Int? = null
)

/* Area Request */
@JsonClass(generateAdapter = true)
data class AreaRequest(
    @Json(name = "ActionType")
    val actionType: Int? = null
)

/* Area Response */
@JsonClass(generateAdapter = true)
data class AreaResponse(
    @Json(name = "AreaList")
    val areaList: List<Area>? = null,
    @Json(name = "ReturnMessage")
    val returnMessage: Any? = null,
    @Json(name = "ReturnValue")
    val returnValue: Int? = null,
    @Json(name = "TotalRecords")
    val totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class Area(
    @Json(name = "AreaId")
    val areaId: Int? = null,
    @Json(name = "AreaName")
    val areaName: String? = null
)

@JsonClass(generateAdapter = true)
data class CommonSpinners(
    var name: String? = null,
    var id: Int? = null,
    val type: String? = null
)

//language request@JsonClass(generateAdapter = true)
@JsonClass(generateAdapter = true)
data class LanguageRequest(
    @Json(name = "ActionType")
    val actionType: Int? = null
)

@JsonClass(generateAdapter = true)
data class LanguageResponse(
    @Json(name = "actionType")
    val actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    val languagedetails: List<LanguageList>? = null
)

@JsonClass(generateAdapter = true)
data class LanguageList(
    @Json(name = "attributeContents")
    val attributeContents: Any? = null,
    @Json(name = "attributeCurrencyId")
    val attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    val attributeNames: Any? = null,
    @Json(name = "attributeType")
    val attributeType: Any? = null,
    @Json(name = "attributeValue")
    val attributeValue: String? = null,
    @Json(name = "categoryCode")
    val categoryCode: Any? = null,
    @Json(name = "cityId")
    val cityId: Int? = null,
    @Json(name = "cityNames")
    val cityNames: Any? = null,
    @Json(name = "currency")
    val currency: Int? = null,
    @Json(name = "imageUrl")
    val imageUrl: Any? = null,
    @Json(name = "totalEarning")
    val totalEarning: Double? = null
)

//Teritory Request
@JsonClass(generateAdapter = true)
data class TeritoryRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null
)

//Teritory Response

@JsonClass(generateAdapter = true)
data class TeritoryResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var teritorydetails: List<Teritory>? = null
)

@JsonClass(generateAdapter = true)
data class Teritory(
    @Json(name = "attributeContents")
    var attributeContents: String? = null,
    @Json(name = "attributeCurrencyId")
    var attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    var attributeNames: String? = null,
    @Json(name = "attributeType")
    var attributeType: String? = null,
    @Json(name = "attributeValue")
    var attributeValue: String? = null,
    @Json(name = "categoryCode")
    var categoryCode: Any? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityNames")
    var cityNames: Any? = null,
    @Json(name = "currency")
    var currency: Int? = null,
    @Json(name = "imageUrl")
    var imageUrl: Any? = null,
    @Json(name = "totalEarning")
    var totalEarning: Double? = null
)








