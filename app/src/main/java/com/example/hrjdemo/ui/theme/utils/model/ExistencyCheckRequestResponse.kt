package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class ExistencyRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Location")
    var location: Locationss? = null
)

@JsonClass(generateAdapter = true)
data class Locationss(
    @Json(name = "UserName")
    var userName: String? = null
)

@JsonClass(generateAdapter = true)
data class ExistencyResponse(
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)