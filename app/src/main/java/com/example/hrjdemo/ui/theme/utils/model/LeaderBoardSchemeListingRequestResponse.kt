package com.loyaltyworks.hrjohnson.model
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json


//leader board scheme listing request

@JsonClass(generateAdapter = true)
data class LeaderBoardSchemeListingRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null
)

//leader board scheme listing response

@JsonClass(generateAdapter = true)
data class LeaderBoardSchemeListingResponse(
    @Json(name = "lstBrand")
    var lstBrand: Any? = null,
    @Json(name = "lstCusSchemeConfList")
    var lstCusSchemeConfList: List<Any?>? = null,
    @Json(name = "lstCustomerSchemeLeadorBoardlist")
    var lstCustomerSchemeLeadorBoardlist: Any? = null,
    @Json(name = "ltyTieredAwardFilterList")
    var ltyTieredAwardFilterList: List<Any?>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "schemeConfigurationDetails")
    var schemeConfigurationDetails: List<LeaderBoardSchemeConfigurationDetail>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LeaderBoardSchemeConfigurationDetail(
    @Json(name = "achivedValue")
    var achivedValue: Int? = null,
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
    @Json(name = "expiryDays")
    var expiryDays: Any? = null,
    @Json(name = "expirydate")
    var expirydate: Any? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "is_allowanced")
    var isAllowanced: Int? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "l_PointsRule")
    var lPointsRule: Int? = null,
    @Json(name = "l_Scheme_Awarding_Rule")
    var lSchemeAwardingRule: String? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: Any? = null,
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
    @Json(name = "noExpiry")
    var noExpiry: Boolean? = null,
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
    @Json(name = "totalWinners")
    var totalWinners: Int? = null,
    @Json(name = "validFrom")
    var validFrom: String? = null,
    @Json(name = "validTo")
    var validTo: String? = null
)



//leaderboard listing request

@JsonClass(generateAdapter = true)
data class LeaderboardListingRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "SchemeConfigurationID")
    var schemeConfigurationID: String? = null
)


//leaderboard listing response
/*

@JsonClass(generateAdapter = true)
data class LeaderBoardListingResponse(
    @Json(name = "lstBrand")
    var lstBrand: Any? = null,
    @Json(name = "lstCusSchemeConfList")
    var lstCusSchemeConfList: List<LstCusSchemeConf>? = null,
    @Json(name = "lstCustomerSchemeLeadorBoardlist")
    var lstCustomerSchemeLeadorBoardlist: Any?= null,
    @Json(name = "ltyTieredAwardFilterList")
    var ltyTieredAwardFilterList: List<Any>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "schemeConfigurationDetails")
    var schemeConfigurationDetails: List<LeaderBoardList>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstCusSchemeConf(
    @Json(name = "firstName")
    var firstName: String? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: String? = null,
    @Json(name = "points")
    var points: String? = null,
    @Json(name = "rank")
    var rank: Int? = null,
    @Json(name = "remarks")
    var remarks: Any? = null
)

@JsonClass(generateAdapter = true)
data class LeaderBoardList(
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
    @Json(name = "expiryDays")
    var expiryDays: Any? = null,
    @Json(name = "expirydate")
    var expirydate: Any? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "is_allowanced")
    var isAllowanced: Int? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "l_PointsRule")
    var lPointsRule: Int? = null,
    @Json(name = "l_Scheme_Awarding_Rule")
    var lSchemeAwardingRule: String? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: Any? = null,
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
    @Json(name = "noExpiry")
    var noExpiry: Boolean? = null,
    @Json(name = "processType")
    var processType: Any? = null,
    @Json(name = "productFilterId")
    var productFilterId: Any? = null,
    @Json(name = "productIDS")
    var productIDS: String? = null,
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
    @Json(name = "totalWinners")
    var totalWinners: Int? = null,
    @Json(name = "validFrom")
    var validFrom: String? = null,
    @Json(name = "validTo")
    var validTo: String? = null
)
*/


//Leaderboard Listing response

@JsonClass(generateAdapter = true)
data class LeaderBoardListingResponse(
    @Json(name = "lstBrand")
    var lstBrand: Any? = null,
    @Json(name = "lstCusSchemeConfList")
    var lstCusSchemeConfList: List<LstCusSchemeConf>? = null,
    @Json(name = "lstCustomerSchemeLeadorBoardlist")
    var lstCustomerSchemeLeadorBoardlist: Any? = null,
    @Json(name = "ltyTieredAwardFilterList")
    var ltyTieredAwardFilterList: List<Any>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "schemeConfigurationDetails")
    var schemeConfigurationDetails: List<LeaderBoardList>? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstCusSchemeConf(
    @Json(name = "firstName")
    var firstName: String? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: String? = null,
    @Json(name = "points")
    var points: String? = null,
    @Json(name = "rank")
    var rank: Int? = null,
    @Json(name = "remarks")
    var remarks: Any? = null
)

@JsonClass(generateAdapter = true)
data class LeaderBoardList(
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
    @Json(name = "expiryDays")
    var expiryDays: Any? = null,
    @Json(name = "expirydate")
    var expirydate: Any? = null,
    @Json(name = "giftName")
    var giftName: Any? = null,
    @Json(name = "isAboveMin")
    var isAboveMin: Double? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "is_allowanced")
    var isAllowanced: Int? = null,
    @Json(name = "is_current_customer")
    var isCurrentCustomer: String? = null,
    @Json(name = "isFirstRow")
    var isFirstRow: Int? = null,
    @Json(name = "isLastRow")
    var isLastRow: Int? = null,
    @Json(name = "l_PointsRule")
    var lPointsRule: Int? = null,
    @Json(name = "l_Scheme_Awarding_Rule")
    var lSchemeAwardingRule: String? = null,
    @Json(name = "loyalty_ID")
    var loyaltyID: Any? = null,
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
    @Json(name = "noExpiry")
    var noExpiry: Boolean? = null,
    @Json(name = "processType")
    var processType: Any? = null,
    @Json(name = "productFilterId")
    var productFilterId: Any? = null,
    @Json(name = "productIDS")
    var productIDS: String? = null,
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
    @Json(name = "totalWinners")
    var totalWinners: Int? = null,
    @Json(name = "validFrom")
    var validFrom: String? = null,
    @Json(name = "validTo")
    var validTo: String? = null
)