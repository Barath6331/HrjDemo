package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class ScanRequest(
    val Address: String? = null,
    val City: String? = null,
    val Country: String? = null,
    val Latitude: String? = null,
    val Longitude: String? = null,
    val LoyaltyID: String? = null,
    val PinCode: String? = null,
    val AccessedDate: String? = null,
    var QRCodeSaveRequestList: List<QRCodeSaveRequest>? = null,
    val SourceType: String? = null,
    val State: String? = null
)

@JsonClass(generateAdapter = true)
data class QRCodeSaveRequest(
    var QRCode: String? = null,
    var ScanType: Int? = null,
    var Latitude: String? = null,
    var Longitude: String? = null
)


@JsonClass(generateAdapter = true)
data class ScanResponse(
    @Json(name = "qrCodeSaveResponseList")
    var qrCodeSaveResponseList: List<QrCodeSaveResponse>? = null
)

@JsonClass(generateAdapter = true)
data class QrCodeSaveResponse(
    @Json(name = "actionType")
    var actionType: Int? = null,
    @Json(name = "actorId")
    var actorId: Int? = null,
    @Json(name = "actorRole")
    var actorRole: Any? = null,
    @Json(name = "address")
    var address: Any? = null,
    @Json(name = "city")
    var city: Any? = null,
    @Json(name = "codeStatus")
    var codeStatus: Int? = null,
    @Json(name = "country")
    var country: Any? = null,
    @Json(name = "customerName")
    var customerName: Any? = null,
    @Json(name = "isActive")
    var isActive: Boolean? = null,
    @Json(name = "isNotional")
    var isNotional: Int? = null,
    @Json(name = "isScanedSource")
    var isScanedSource: Int? = null,
    @Json(name = "latitude")
    var latitude: String? = null,
    @Json(name = "longitude")
    var longitude: String? = null,
    @Json(name = "loyaltyID")
    var loyaltyID: String? = null,
    @Json(name = "mobile")
    var mobile: Any? = null,
    @Json(name = "pinCode")
    var pinCode: Any? = null,
    @Json(name = "pointAwarded")
    var pointAwarded: Any? = null,
    @Json(name = "qrCode")
    var qrCode: String? = null,
    @Json(name = "remarks")
    var remarks: Any? = null,
    @Json(name = "sourceType")
    var sourceType: Int? = null,
    @Json(name = "state")
    var state: Any? = null,
    @Json(name = "status")
    var status: Any? = null,
    @Json(name = "token")
    var token: Any? = null
)

/*** QR Code Valid Check request ***/
@JsonClass(generateAdapter = true)
data class QrCodeValidateRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ScratchCode")
    var scratchCode: String? = null
)

/*** QR Code Valid Check response ***/
@JsonClass(generateAdapter = true)
data class QrCodeValidateResponse(
    @Json(name = "customerEmailID")
    var customerEmailID: Any? = null,
    @Json(name = "customer_ID")
    var customerID: Any? = null,
    @Json(name = "customer_Name")
    var customerName: Any? = null,
    @Json(name = "is_Valid")
    var isValid: Boolean? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null,
    @Json(name = "validationStatus")
    var validationStatus: String? = null
)

@JsonClass(generateAdapter = true)
data class EncryptCodeRequest(
    @Json(name = "EncryptCode")
    var encryptCode: String? = null
)

@JsonClass(generateAdapter = true)
data class EncryptCodeResponse(
    @Json(name = "createdDate")
    var createdDate: String? = null,
    @Json(name = "customerTypeCode")
    var customerTypeCode: Any? = null,
    @Json(name = "decreptedCode")
    var decreptedCode: String? = null,
    @Json(name = "dtScratchCodesList")
    var dtScratchCodesList: Any? = null,
    @Json(name = "generatedCodesCount")
    var generatedCodesCount: Double? = null,
    @Json(name = "generatedFor")
    var generatedFor: String? = null,
    @Json(name = "hrjBatchNo")
    var hrjBatchNo: Any? = null,
    @Json(name = "invoiceNo")
    var invoiceNo: Any? = null,
    @Json(name = "lineInPlant")
    var lineInPlant: Any? = null,
    @Json(name = "lwsBatchNo")
    var lwsBatchNo: Any? = null,
    @Json(name = "mfgDate")
    var mfgDate: String? = null,
    @Json(name = "month")
    var month: Int? = null,
    @Json(name = "plantCode")
    var plantCode: Any? = null,
    @Json(name = "plantName")
    var plantName: Any? = null,
    @Json(name = "productCode")
    var productCode: Any? = null,
    @Json(name = "productDesc")
    var productDesc: Any? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "productType")
    var productType: Any? = null,
    @Json(name = "qrUsegereport")
    var qrUsegereport: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "scQueueID")
    var scQueueID: Int? = null,
    @Json(name = "scratchCode")
    var scratchCode: Any? = null,
    @Json(name = "scratchCodeTable")
    var scratchCodeTable: Any? = null,
    @Json(name = "scratchCodesList")
    var scratchCodesList: Any? = null,
    @Json(name = "segment")
    var segment: Any? = null,
    @Json(name = "size")
    var size: Any? = null,
    @Json(name = "sku")
    var sku: Any? = null,
    @Json(name = "srtrName")
    var srtrName: Any? = null,
    @Json(name = "subSegment")
    var subSegment: Any? = null,
    @Json(name = "tileType")
    var tileType: Any? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null,
    @Json(name = "totalRows")
    var totalRows: Int? = null,
    @Json(name = "usedScratchCodesList")
    var usedScratchCodesList: Any? = null,
    @Json(name = "vertical")
    var vertical: Any? = null,
    @Json(name = "year")
    var year: Int? = null
)