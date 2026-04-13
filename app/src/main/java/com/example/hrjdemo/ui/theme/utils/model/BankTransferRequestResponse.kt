package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


/*Transfer Credits Request*/
@JsonClass(generateAdapter = true)
data class SaveCatalogueRedemptionDetailsRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "CustomerUserID")
    var customerUserID: String? = null,
    @Json(name = "ObjCatalogueDetails")
    var objCatalogueDetails: ObjCatalogueLists? = null,
    @Json(name = "SourceMode")
    var sourceMode: String? = null,
    @Json(name = "TransferMode")
    var transferMode: String? = null
)

@JsonClass(generateAdapter = true)
data class ObjCatalogueLists(
    @Json(name = "CatalogueId")
    var catalogueId: String? = null,
    @Json(name = "DomainName")
    var domainName: String? = null,
    @Json(name = "NoOfPointsDebit")
    var noOfPointsDebit: String? = null,
    @Json(name = "RedemptionTypeId")
    var redemptionTypeId: String? = null
)

/*Transfer Credits Response*/
@JsonClass(generateAdapter = true)
data class SaveCatalogueRedemptionDetailsResponse(
    @Json(name = "membershipID")
    var membershipID: Any? = null,
    @Json(name = "objCatalogueList")
    var objCatalogueList: Any? = null,
    @Json(name = "pdfLink")
    var pdfLink: Any? = null,
    @Json(name = "redemptionReferenceNumber")
    var redemptionReferenceNumber: Any? = null,
    @Json(name = "redemptionStatus")
    var redemptionStatus: Any? = null,
    @Json(name = "responseCode")
    var responseCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null,
    @Json(name = "uniqueID")
    var uniqueID: Any? = null,
    @Json(name = "userId")
    var userId: Int? = null
)