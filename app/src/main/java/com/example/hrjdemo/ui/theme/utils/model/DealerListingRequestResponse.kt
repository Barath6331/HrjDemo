package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class DealerLisingRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "Latitude")
    var latitude: String? = null,
    @Json(name = "Longitude")
    var longitude: String? = null,
    @Json(name = "PageNo")
    var pageNo: Int? = null,
    @Json(name = "StarIndex")
    var starIndex: Int? = null
)


@JsonClass(generateAdapter = true)
data class DealerListingResponse(
    @Json(name = "dealerDetails")
    var dealerDetails: List<DealerDetail>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class DealerDetail(
    @Json(name = "image")
    var image: Any? = null,
    @Json(name = "latitude")
    var latitude: String? = null,
    @Json(name = "longitude")
    var longitude: String? = null,
    @Json(name = "name")
    var name: String? = null
)