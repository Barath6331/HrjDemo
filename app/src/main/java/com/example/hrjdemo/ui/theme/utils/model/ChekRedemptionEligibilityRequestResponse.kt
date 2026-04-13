package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

//physical product reedem eligibility request
@JsonClass(generateAdapter = true)
data class RedemptioEligibilityRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "CatalogueTypeId")
    var catalogueTypeId: String? = null
)

//physical product reedem eligibility response
@JsonClass(generateAdapter = true)
data class RedemptionEligibilityResponse(
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "tdsList")
    var tdsList: Any? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

//evoucher and bank transfer eligibility request

@JsonClass(generateAdapter = true)
data class VocuherEligibilityRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "PointsDebit")
    var pointsDebit: String? = null,
    @Json(name = "CatalogueTypeId")
    var catalogueTypeId: String? = null
)


////evoucher and bank transfer eligibility response
@JsonClass(generateAdapter = true)
data class VocherEligibilityResponse(
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "tdsList")
    var tdsList: Any? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)