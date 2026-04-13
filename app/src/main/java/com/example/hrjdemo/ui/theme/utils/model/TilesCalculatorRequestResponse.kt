package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//Design size
@JsonClass(generateAdapter = true)
data class DesignSizeRequest(
    @Json(name = "ActionType")
    var actionType: String? = null
)

@JsonClass(generateAdapter = true)
data class DesignSizeResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: List<LstAttributesDetailDesignSize>? = null
)

@JsonClass(generateAdapter = true)
data class LstAttributesDetailDesignSize(
    @Json(name = "attributeContents")
    var attributeContents: Any? = null,
    @Json(name = "attributeCurrencyId")
    var attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    var attributeNames: Any? = null,
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

//Design name
@JsonClass(generateAdapter = true)
data class DesignNameRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "HelpTopicID")
    var helpTopicID: String? = null
)

@JsonClass(generateAdapter = true)
data class DesignNameResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: List<LstAttributesDetailDesignName>? = null
)

@JsonClass(generateAdapter = true)
data class LstAttributesDetailDesignName(
    @Json(name = "attributeContents")
    var attributeContents: Any? = null,
    @Json(name = "attributeCurrencyId")
    var attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    var attributeNames: Any? = null,
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

//Material Description
@JsonClass(generateAdapter = true)
data class MaterialDescriptionRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "HelpTopicID")
    var helpTopicID: String? = null
)

@JsonClass(generateAdapter = true)
data class MaterialDescriptionResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: List<LstAttributesDetailMaterialDiscription>? = null
)

@JsonClass(generateAdapter = true)
data class LstAttributesDetailMaterialDiscription(
    @Json(name = "attributeContents")
    var attributeContents: Any? = null,
    @Json(name = "attributeCurrencyId")
    var attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    var attributeNames: Any? = null,
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

@JsonClass(generateAdapter = true)
data class CalculationRequest(
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Breadth")
    var breadth: String? = null,
    @Json(name = "DiamationID")
    var diamationID: Int? = null,
    @Json(name = "FitID")
    var fitID: Int? = null,
    @Json(name = "Length")
    var length: String? = null,
    @Json(name = "ProductID")
    var productID: String? = null,
    @Json(name = "SizeId")
    var sizeId: String? = null
)

@JsonClass(generateAdapter = true)
data class CalculationResponse(
    @Json(name = "basE64")
    var basE64: Any? = null,
    @Json(name = "quotaions")
    var quotaions: List<Quotaion>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class Quotaion(
    @Json(name = "areaCouver")
    var areaCouver: String? = null,
    @Json(name = "diamation")
    var diamation: String? = null,
    @Json(name = "fite")
    var fite: String? = null,
    @Json(name = "membershipID")
    var membershipID: String? = null,
    @Json(name = "mobile")
    var mobile: String? = null,
    @Json(name = "productDescription")
    var productDescription: String? = null,
    @Json(name = "quanity")
    var quanity: String? = null,
    @Json(name = "totalAmount")
    var totalAmount: String? = null
)


@JsonClass(generateAdapter = true)
data class PdfDownloadRequest(
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Breadth")
    var breadth: String? = null,
    @Json(name = "DiamationID")
    var diamationID: Int? = null,
    @Json(name = "FitID")
    var fitID: Int? = null,
    @Json(name = "Length")
    var length: String? = null,
    @Json(name = "PDF")
    var pDF: Int? = null,
    @Json(name = "ProductID")
    var productID: String? = null,
    @Json(name = "SizeId")
    var sizeId: String? = null
)

@JsonClass(generateAdapter = true)
data class PdfDownloadResponse(
    @Json(name = "basE64")
    var basE64: String? = null,
    @Json(name = "quotaions")
    var quotaions: List<Quotaions>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class Quotaions(
    @Json(name = "areaCouver")
    var areaCouver: String? = null,
    @Json(name = "diamation")
    var diamation: String? = null,
    @Json(name = "fite")
    var fite: String? = null,
    @Json(name = "membershipID")
    var membershipID: String? = null,
    @Json(name = "mobile")
    var mobile: String? = null,
    @Json(name = "productDescription")
    var productDescription: String? = null,
    @Json(name = "quanity")
    var quanity: String? = null,
    @Json(name = "totalAmount")
    var totalAmount: String? = null
)