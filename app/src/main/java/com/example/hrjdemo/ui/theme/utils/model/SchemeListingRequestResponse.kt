package com.loyaltyworks.hrjohnson.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)


data class SchemeListingRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null
)


@JsonClass(generateAdapter = true)
data class SchemeListingResponse(
    @Json(name = "lstBrand")
    var lstBrand: Any? = null,
    @Json(name = "ltyTieredAwardFilterList")
    var ltyTieredAwardFilterList: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "schemeConfigurationDetails")
    var schemeConfigurationDetails: List<SchemeConfigurationDetail>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class SchemeConfigurationDetail(
    @Json(name = "awardType")
    var awardType: Any? = null,
    @Json(name = "awardingType")
    var awardingType: Any? = null,
    @Json(name = "brandIDS")
    var brandIDS: Any? = null,
    @Json(name = "categoryId")
    var categoryId: Int? = null,
    @Json(name = "categoryIdS")
    var categoryIdS: Any? = null,
    @Json(name = "categoryName")
    var categoryName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: String? = null,
    @Json(name = "createdDate")
    var createdDate: String? = null,
    @Json(name = "cusSegmentId")
    var cusSegmentId: Any? = null,
    @Json(name = "cusSegmentType")
    var cusSegmentType: Any? = null,
    @Json(name = "cusSegmentTypeId")
    var cusSegmentTypeId: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "maxValue")
    var maxValue: Any? = null,
    @Json(name = "maxvalue")
    var maxvalue: Int? = null,
    @Json(name = "merchantId")
    var merchantId: Int? = null,
    @Json(name = "minValue")
    var minValue: Any? = null,
    @Json(name = "modifiedBy")
    var modifiedBy: Any? = null,
    @Json(name = "modifiedDate")
    var modifiedDate: Any? = null,
    @Json(name = "montaryValue")
    var montaryValue: Double? = null,
    @Json(name = "montaryvalue")
    var montaryvalue: Int? = null,
    @Json(name = "productIDS")
    var productIDS: Any? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "rewards")
    var rewards: Int? = null,
    @Json(name = "rows")
    var rows: Int? = null,
    @Json(name = "schemeAwardingRule")
    var schemeAwardingRule: String? = null,
    @Json(name = "schemeAwardingRuleID")
    var schemeAwardingRuleID: Int? = null,
    @Json(name = "schemeAwardingcriteria")
    var schemeAwardingcriteria: Any? = null,
    @Json(name = "schemeConfigurationID")
    var schemeConfigurationID: Int? = null,
    @Json(name = "schemeDescription")
    var schemeDescription: String? = null,
    @Json(name = "schemeName")
    var schemeName: String? = null,
    @Json(name = "schemeScoreType")
    var schemeScoreType: Any? = null,
    @Json(name = "schemeType")
    var schemeType: Any? = null,
    @Json(name = "slabRange")
    var slabRange: Any? = null,
    @Json(name = "status")
    var status: Int? = null,
    @Json(name = "tieredPointType")
    var tieredPointType: Int? = null,
    @Json(name = "totalRows")
    var totalRows: Int? = null,
    @Json(name = "validFrom")
    var validFrom: String? = null,
    @Json(name = "validTo")
    var validTo: String? = null
)


//scheme detail  request

@JsonClass(generateAdapter = true)
data class SchemeDetailsRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "SchemeConfigurationID")
    var schemeConfigurationID: String? = null
)
//scheme detail  response

@JsonClass(generateAdapter = true)
data class SchemeDetailsResponse(
    @Json(name = "lstBrand")
    var lstBrand: Any? = null,
    @Json(name = "lstCusSchemeConfList")
    var lstCusSchemeConfList: Any? = null,
    @Json(name = "ltyTieredAwardFilterList")
    var ltyTieredAwardFilterList: List<LtyTieredAwardFilter>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "schemeConfigurationDetails")
    var schemeConfigurationDetails: List<SchemeConfigurationDetails?>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LtyTieredAwardFilter(
    @Json(name = "awardType")
    var awardType: Any? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "maxValue")
    var maxValue: Double? = null,
    @Json(name = "minValue")
    var minValue: Any? = null,
    @Json(name = "montaryValue")
    var montaryValue: Double? = null,
    @Json(name = "montaryvalue")
    var montaryvalue: Int? = null,
    @Json(name = "rewards")
    var rewards: Double? = null,
    @Json(name = "rows")
    var rows: Int? = null,
    @Json(name = "schemeAwardingRuleID")
    var schemeAwardingRuleID: Int? = null,
    @Json(name = "schemeConfigurationID")
    var schemeConfigurationID: Int? = null,
    @Json(name = "slabRange")
    var slabRange: String? = null,
    @Json(name = "tieredPointType")
    var tieredPointType: Int? = null
)

@JsonClass(generateAdapter = true)
data class SchemeConfigurationDetails(
    @Json(name = "achivedValue")
    var achivedValue: Int? = null,
    @Json(name = "awardType")
    var awardType: Any? = null,
    @Json(name = "awardingType")
    var awardingType: String? = null,
    @Json(name = "brandIDS")
    var brandIDS: Any? = null,
    @Json(name = "categoryId")
    var categoryId: Int? = null,
    @Json(name = "categoryIdS")
    var categoryIdS: Any? = null,
    @Json(name = "categoryName")
    var categoryName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: Any? = null,
    @Json(name = "createdDate")
    var createdDate: Any? = null,
    @Json(name = "cusSegmentId")
    var cusSegmentId: String? = null,
    @Json(name = "cusSegmentType")
    var cusSegmentType: Any? = null,
    @Json(name = "cusSegmentTypeId")
    var cusSegmentTypeId: Any? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: Any? = null,
    @Json(name = "l_PointsRule")
    var lPointsRule: Int? = null,
    @Json(name = "maxValue")
    var maxValue: Any? = null,
    @Json(name = "maxvalue")
    var maxvalue: Int? = null,
    @Json(name = "merchantId")
    var merchantId: Int? = null,
    @Json(name = "minValue")
    var minValue: Any? = null,
    @Json(name = "modifiedBy")
    var modifiedBy: Any? = null,
    @Json(name = "modifiedDate")
    var modifiedDate: Any? = null,
    @Json(name = "montaryValue")
    var montaryValue: Double? = null,
    @Json(name = "montaryvalue")
    var montaryvalue: Int? = null,
    @Json(name = "processType")
    var processType: Any? = null,
    @Json(name = "productFilterId")
    var productFilterId: Any? = null,
    @Json(name = "productIDS")
    var productIDS: Any? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "rewards")
    var rewards: Int? = null,
    @Json(name = "rows")
    var rows: Int? = null,
    @Json(name = "schemeAwardingRule")
    var schemeAwardingRule: String? = null,
    @Json(name = "schemeAwardingRuleID")
    var schemeAwardingRuleID: Int? = null,
    @Json(name = "schemeAwardingcriteria")
    var schemeAwardingcriteria: String? = null,
    @Json(name = "schemeConfigurationID")
    var schemeConfigurationID: Int? = null,
    @Json(name = "schemeDescription")
    var schemeDescription: String? = null,
    @Json(name = "schemeName")
    var schemeName: String? = null,
    @Json(name = "schemeScoreType")
    var schemeScoreType: Any? = null,
    @Json(name = "schemeType")
    var schemeType: Any? = null,
    @Json(name = "slabRange")
    var slabRange: Any? = null,
    @Json(name = "status")
    var status: Int? = null,
    @Json(name = "targetValue")
    var targetValue: Int? = null,
    @Json(name = "tieredPointType")
    var tieredPointType: Int? = null,
    @Json(name = "totalRows")
    var totalRows: Int? = null,
    @Json(name = "validFrom")
    var validFrom: String? = null,
    @Json(name = "validTo")
    var validTo: String? = null
)