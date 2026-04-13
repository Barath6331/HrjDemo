package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

/*** Customer Type Request ***/
@JsonClass(generateAdapter = true)
data class AccountTypeRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null
)

/*** Customer Type Response ***/
@JsonClass(generateAdapter = true)
data class AccountTypeResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: List<LstAttributesDetail>? = null
)

@JsonClass(generateAdapter = true)
data class LstAttributesDetail(
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
    var attributeValue: Any? = null
)