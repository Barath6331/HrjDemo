package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json


@JsonClass(generateAdapter = true)
data class SmsRequest(
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "MobileNo")
    var mobileNo: String? = null
)

@JsonClass(generateAdapter = true)
data class SmsResponse(
    @Json(name = "lstCustomer")
    var lstCustomer: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)