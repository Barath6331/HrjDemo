package com.example.hrjdemo.ui.theme.utils.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class PlumberListingRequest(
    @Json(name = "ActionType")
    val actionType: Int?,
    @Json(name = "ActorId")
    val actorId: Int?,
    @Json(name = "PageSize")
    val pageSize: Int?,
    @Json(name = "StartIndex")
    val startIndex: Int?
)

@JsonClass(generateAdapter = true)
data class PlumberListingResponse(
    @Json(name = "lstPlumberDetails")
    val lstPlumberDetails: List<LstPlumberDetail>?,
    @Json(name = "objPlumberDetailsRetrieverequest")
    val objPlumberDetailsRetrieverequest: Any?,
    @Json(name = "returnMessage")
    val returnMessage: Any?,
    @Json(name = "returnValue")
    val returnValue: Int?,
    @Json(name = "totalRecords")
    val totalRecords: Int?
)

@JsonClass(generateAdapter = true)
data class LstPlumberDetail(
    @Json(name = "bonousPoints")
    val bonousPoints: Int?,
    @Json(name = "mobileNumber")
    val mobileNumber: String?,
    @Json(name = "plumberID")
    val plumberID: Int?,
    @Json(name = "plumberName")
    val plumberName: String?,
    @Json(name = "result")
    val result: Any?
)

