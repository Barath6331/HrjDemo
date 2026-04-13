package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/** Proof Type Listing Request and Response ***/

@JsonClass(generateAdapter = true)
data class ProofTypeListRequest(
    @Json(name = "ActionType")
    val actionType: String? = null
)

@JsonClass(generateAdapter = true)
data class ProofTypeListResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: List<LstAttributesDetail5>? = null
)

@JsonClass(generateAdapter = true)
data class LstAttributesDetail5(
    @Json(name = "attributeContents")
    var attributeContents: Any? = null,
    @Json(name = "attributeCurrencyId")
    var attributeCurrencyId: Any? = null,
    @Json(name = "attributeId")
    var attributeId: Int? = null,
    @Json(name = "attributeNames")
    var attributeNames: Any? = null,
    @Json(name = "attributeType")
    var attributeType: Any? = null,
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
