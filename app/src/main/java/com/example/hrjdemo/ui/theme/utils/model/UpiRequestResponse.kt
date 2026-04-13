package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

//upi existency api

@JsonClass(generateAdapter = true)
data class UpiExistencyRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "Location")
    var location: UpiLocation? = null
)

@JsonClass(generateAdapter = true)
data class UpiLocation(
    @Json(name = "UserName")
    var userName: String? = null
)


//upi existency response

@JsonClass(generateAdapter = true)
data class UpiExistencyResponse(
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)


@JsonClass(generateAdapter = true)
data class UpiSumbissionRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "IsMobileRequest")
    var isMobileRequest: Int? = null,
    @Json(name = "lstCustomerOfficalInfoJson")
    var lstCustomerOfficalInfoJson: LstCustomerUpiOfficalInfoJson? = null,
    @Json(name = "ObjCustomerJson")
    var objCustomerJson: ObjCustomerJsonUpi? = null
)

@JsonClass(generateAdapter = true)
data class LstCustomerUpiOfficalInfoJson(
    @Json(name = "BankTransferMode")
    var bankTransferMode: String? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJsonUpi(
    @Json(name = "BankTransferMode")
    var bankTransferMode: String? = null,
    @Json(name = "CustomerId")
    var customerId: String? = null,
    @Json(name = "IsUPIVerified")
    var isUPIVerified: String? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "MerchantId")
    var merchantId: Int? = null,
    @Json(name = "UPIAttachment")
    var uPIAttachment: String? = null,
    @Json(name = "UPI_ID")
    var uPIID: String? = null,
    @Json(name = "UPIName")
    var uPIName: String? = null
)


//upi sumbission response

@JsonClass(generateAdapter = true)
data class UpiSumbissionResponse(
    @Json(name = "lstCustomer")
    var lstCustomer: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)


