package com.example.hrjdemo.ui.theme.utils.model

import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class SumbitEwarrntyDetailsRequest(
    @Json(name = "ActionType")
    val actionType: String?,
    @Json(name = "ActorId")
    val actorId: String?,
    @Json(name = "CustPinCode")
    val custPinCode: String?,
    @Json(name = "CustomerName")
    val customerName: String?,
    @Json(name = "DealName")
    val dealName: String?,
    @Json(name = "EmailId")
    val emailId: String?,
    @Json(name = "InvoiceDate")
    val invoiceDate: String?,
    @Json(name = "IsnewInvoiceImage")
    val isnewInvoiceImage: String?,
    @Json(name = "InvoiceImage")
    val invoiceImage: String?,
    @Json(name = "InvoiceNumber")
    val invoiceNumber: String?,
    @Json(name = "MobileNum")
    val mobileNum: String?,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)

@JsonClass(generateAdapter = true)
data class SubmitEwarrntyDetailsResponse(
    @Json(name = "lstEWarranty")
    val lstEWarranty: List<Any?>?,
    @Json(name = "returnMessage")
    val returnMessage: String?,
    @Json(name = "returnValue")
    val returnValue: Int?,
    @Json(name = "totalRecords")
    val totalRecords: Int?,
    @Json(name = "warrantyFilePath")
    val warrantyFilePath: Any?
)

/* chek customer mobile number exist or not */
@JsonClass(generateAdapter = true)
data class CustomerMobileNumberExistencyChekRequest(
    @Json(name = "ActionType")
    val actionType: String?,
    @Json(name = "Location")
    val location: Location?
)


@JsonClass(generateAdapter = true)
data class Location(
    @Json(name = "UserName")
    val userName: String?
)

@JsonClass(generateAdapter = true)
data class CustomerMobileNumberExistencyChekResponse(
    val CheckCustomerExistancyAndVerificationResult: Int? = null
)

/* end */


/* for ewarrnty listing request response */

@JsonClass(generateAdapter = true)
data class EwarrantyListingRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "NoOfRows")
    var noOfRows: Int? = null,
    @Json(name = "StartIndex")
    var startIndex: Int? = null
)


@JsonClass(generateAdapter = true)
data class EwarrantyListingResponse(
    @Json(name = "encryptWarranty")
    var encryptWarranty: Any? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: Any? = null,
    @Json(name = "lstEWarranty")
    var lstEWarranty: List<LstEWarranty>? = null,
    @Json(name = "lstScannedCode")
    var lstScannedCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstEWarranty(
    @Json(name = "address")
    var address: Any? = null,
    @Json(name = "areaId")
    var areaId: Int? = null,
    @Json(name = "areaName")
    var areaName: Any? = null,
    @Json(name = "brandId")
    var brandId: Int? = null,
    @Json(name = "brandName")
    var brandName: Any? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "contractorName")
    var contractorName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: Any? = null,
    @Json(name = "customerID")
    var customerID: Int? = null,
    @Json(name = "customerName")
    var customerName: String? = null,
    @Json(name = "dealName")
    var dealName: String? = null,
    @Json(name = "eWarrantyDate")
    var eWarrantyDate: String? = null,
    @Json(name = "eWarrantyID")
    var eWarrantyID: Int? = null,
    @Json(name = "eWarrantyQty")
    var eWarrantyQty: Int? = null,
    @Json(name = "emailId")
    var emailId: String? = null,
    @Json(name = "generatorEmailId")
    var generatorEmailId: Any? = null,
    @Json(name = "generatorMobile")
    var generatorMobile: Any? = null,
    @Json(name = "invoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "invoiceImage")
    var invoiceImage: String? = null,
    @Json(name = "invoiceNum")
    var invoiceNum: String? = null,
    @Json(name = "invoiceStatus")
    var invoiceStatus: Int? = null,
    @Json(name = "isWarranty")
    var isWarranty: Int? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "mobileNum")
    var mobileNum: String? = null,
    @Json(name = "monthOfScanning")
    var monthOfScanning: Any? = null,
    @Json(name = "plantName")
    var plantName: Any? = null,
    @Json(name = "prodWarrantyDesc")
    var prodWarrantyDesc: Any? = null,
    @Json(name = "productCode")
    var productCode: Any? = null,
    @Json(name = "productDiscript")
    var productDiscript: Any? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "qrCode")
    var qrCode: Any? = null,
    @Json(name = "scannedCode")
    var scannedCode: Any? = null,
    @Json(name = "sizeDesc")
    var sizeDesc: Any? = null,
    @Json(name = "subHelpTopicId")
    var subHelpTopicId: Int? = null,
    @Json(name = "successQRCount")
    var successQRCount: Int? = null,
    @Json(name = "thickDesc")
    var thickDesc: Any? = null,
    @Json(name = "total_Row")
    var totalRow: Int? = null,
    @Json(name = "warrantyFilePath")
    var warrantyFilePath: Any? = null,
    @Json(name = "warrantyPoints")
    var warrantyPoints: Double? = null,
    @Json(name = "zipCode")
    var zipCode: String? = null
) : Serializable


/* end ewarrnty listing request response */



/* submit ewarranty for new customer  */
@JsonClass(generateAdapter = true)
data class CreateCustomerRequest(
    @Json(name = "actiontype")
    var actiontype: String? = null,
    @Json(name = "ObjCustomerJson")
    var objCustomerJson: ObjCustomerJson2? = null
)

@JsonClass(generateAdapter = true)
data class ObjCustomerJson2(
    @Json(name = "CSMUserid")
    var cSMUserid: String? = null,
    @Json(name = "CustomerTypeId")
    var customerTypeId: String? = null,
    @Json(name = "DisplayImage")
    var displayImage: String? = null,
    @Json(name = "Email")
    var email: String? = null,
    @Json(name = "EwarrentReg")
    var ewarrentReg: String? = null,
    @Json(name = "FirstName")
    var firstName: String? = null,
    @Json(name = "InvoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "InvoiceNumber")
    var invoiceNumber: String? = null,
    @Json(name = "MerchantId")
    var merchantId: String? = null,
    @Json(name = "Mobile")
    var mobile: String? = null,
    @Json(name = "PreferedDealerName")
    var preferedDealerName: String? = null,
    @Json(name = "RegistrationSource")
    var registrationSource: String? = null,
    @Json(name = "Zip")
    var zip: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)

@JsonClass(generateAdapter = true)
data class createCustomerResponse(
    @Json(name = "lstCustomer")
    var lstCustomer: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

/* end   */


/* ewarrnty update request response start */


@JsonClass(generateAdapter = true)
data class EwarrantyUpdateRequest(
    @Json(name = "ActionType")
    var actionType: String? = null,
    @Json(name = "ActorId")
    var actorId: String? = null,
    @Json(name = "CustPinCode")
    var custPinCode: String? = null,
    @Json(name = "CustomerName")
    var customerName: String? = null,
    @Json(name = "DealName")
    var dealName: String? = null,
    @Json(name = "EmailId")
    var emailId: String? = null,
    @Json(name = "InvoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "InvoiceImage")
    var invoiceImage: String? = null,
    @Json(name = "InvoiceNumber")
    var invoiceNumber: String? = null,
    @Json(name = "IsnewInvoiceImage")
    var isnewInvoiceImage: String? = null,
    @Json(name = "MobileNum")
    var mobileNum: String? = null,
    @Json(name = "Warrantyid")
    var warrantyid: String? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null
)


@JsonClass(generateAdapter = true)
data class EwarratnyupdateResponse(
    @Json(name = "lstEWarranty")
    var lstEWarranty: List<Any?>? = null,
    @Json(name = "returnMessage")
    var returnMessage: String? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null,
    @Json(name = "warrantyFilePath")
    var warrantyFilePath: Any? = null
)


/* end */


/* send sms request response start */


@JsonClass(generateAdapter = true)
data class SmsSendingRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "SMSSend")
    var sMSSend: Int? = null
)

@JsonClass(generateAdapter = true)
data class SmsSendingResponse(
    @Json(name = "encryptWarranty")
    var encryptWarranty: String? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: Any? = null,
    @Json(name = "lstEWarranty")
    var smsList: List<SmsList?>? = null,
    @Json(name = "lstScannedCode")
    var lstScannedCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class SmsList(
    @Json(name = "address")
    var address: Any? = null,
    @Json(name = "areaId")
    var areaId: Int? = null,
    @Json(name = "areaName")
    var areaName: Any? = null,
    @Json(name = "brandId")
    var brandId: Int? = null,
    @Json(name = "brandName")
    var brandName: Any? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "contractorName")
    var contractorName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: Any? = null,
    @Json(name = "customerID")
    var customerID: Int? = null,
    @Json(name = "customerName")
    var customerName: String? = null,
    @Json(name = "dealName")
    var dealName: Any? = null,
    @Json(name = "eWarrantyDate")
    var eWarrantyDate: Any? = null,
    @Json(name = "eWarrantyID")
    var eWarrantyID: Int? = null,
    @Json(name = "eWarrantyQty")
    var eWarrantyQty: Int? = null,
    @Json(name = "emailId")
    var emailId: Any? = null,
    @Json(name = "generatorEmailId")
    var generatorEmailId: Any? = null,
    @Json(name = "generatorMobile")
    var generatorMobile: Any? = null,
    @Json(name = "invoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "invoiceImage")
    var invoiceImage: Any? = null,
    @Json(name = "invoiceNum")
    var invoiceNum: String? = null,
    @Json(name = "isWarranty")
    var isWarranty: Int? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "mobileNum")
    var mobileNum: String? = null,
    @Json(name = "monthOfScanning")
    var monthOfScanning: Any? = null,
    @Json(name = "plantName")
    var plantName: Any? = null,
    @Json(name = "prodWarrantyDesc")
    var prodWarrantyDesc: Any? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "scannedCode")
    var scannedCode: Any? = null,
    @Json(name = "sizeDesc")
    var sizeDesc: Any? = null,
    @Json(name = "subHelpTopicId")
    var subHelpTopicId: Int? = null,
    @Json(name = "successQRCount")
    var successQRCount: Int? = null,
    @Json(name = "thickDesc")
    var thickDesc: Any? = null,
    @Json(name = "total_Row")
    var totalRow: Int? = null,
    @Json(name = "warrantyFilePath")
    var warrantyFilePath: Any? = null,
    @Json(name = "zipCode")
    var zipCode: Any? = null
)


@JsonClass(generateAdapter = true)
data class ShareurlRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
)

@JsonClass(generateAdapter = true)
data class ShareurlResponse(
    @Json(name = "encryptWarranty")
    var encryptWarranty: String? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: Any? = null,
    @Json(name = "lstEWarranty")
    var shareList: List<ShareList?>? = null,
    @Json(name = "lstScannedCode")
    var lstScannedCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class ShareList(
    @Json(name = "address")
    var address: Any? = null,
    @Json(name = "areaId")
    var areaId: Int? = null,
    @Json(name = "areaName")
    var areaName: Any? = null,
    @Json(name = "brandId")
    var brandId: Int? = null,
    @Json(name = "brandName")
    var brandName: Any? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "contractorName")
    var contractorName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: Any? = null,
    @Json(name = "customerID")
    var customerID: Int? = null,
    @Json(name = "customerName")
    var customerName: String? = null,
    @Json(name = "dealName")
    var dealName: Any? = null,
    @Json(name = "eWarrantyDate")
    var eWarrantyDate: Any? = null,
    @Json(name = "eWarrantyID")
    var eWarrantyID: Int? = null,
    @Json(name = "eWarrantyQty")
    var eWarrantyQty: Int? = null,
    @Json(name = "emailId")
    var emailId: Any? = null,
    @Json(name = "generatorEmailId")
    var generatorEmailId: Any? = null,
    @Json(name = "generatorMobile")
    var generatorMobile: Any? = null,
    @Json(name = "invoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "invoiceImage")
    var invoiceImage: Any? = null,
    @Json(name = "invoiceNum")
    var invoiceNum: String? = null,
    @Json(name = "isWarranty")
    var isWarranty: Int? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "mobileNum")
    var mobileNum: String? = null,
    @Json(name = "monthOfScanning")
    var monthOfScanning: Any? = null,
    @Json(name = "plantName")
    var plantName: Any? = null,
    @Json(name = "prodWarrantyDesc")
    var prodWarrantyDesc: Any? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "scannedCode")
    var scannedCode: Any? = null,
    @Json(name = "sizeDesc")
    var sizeDesc: Any? = null,
    @Json(name = "subHelpTopicId")
    var subHelpTopicId: Int? = null,
    @Json(name = "successQRCount")
    var successQRCount: Int? = null,
    @Json(name = "thickDesc")
    var thickDesc: Any? = null,
    @Json(name = "total_Row")
    var totalRow: Int? = null,
    @Json(name = "warrantyFilePath")
    var warrantyFilePath: Any? = null,
    @Json(name = "zipCode")
    var zipCode: Any? = null
)

// Product Listing Request

@JsonClass(generateAdapter = true)
data class ProductListingRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null,
    @Json(name = "LoyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "NoOfRows")
    var noOfRows: Int? = null,
    @Json(name = "StartIndex")
    var startIndex: Int? = null
)


@JsonClass(generateAdapter = true)
data class ProductListingResponse(
    @Json(name = "encryptWarranty")
    var encryptWarranty: Any? = null,
    @Json(name = "lstAttributesDetails")
    var lstAttributesDetails: Any? = null,
    @Json(name = "lstEWarranty")
    var lstProduct: List<LstProduct>? = null,
    @Json(name = "lstScannedCode")
    var lstScannedCode: Any? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstProduct(
    @Json(name = "address")
    var address: Any? = null,
    @Json(name = "areaId")
    var areaId: Int? = null,
    @Json(name = "areaName")
    var areaName: Any? = null,
    @Json(name = "brandId")
    var brandId: Int? = null,
    @Json(name = "brandName")
    var brandName: String? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "contractorName")
    var contractorName: Any? = null,
    @Json(name = "createdBy")
    var createdBy: Any? = null,
    @Json(name = "customerID")
    var customerID: Int? = null,
    @Json(name = "customerName")
    var customerName: String? = null,
    @Json(name = "dealName")
    var dealName: Any? = null,
    @Json(name = "eWarrantyDate")
    var eWarrantyDate: Any? = null,
    @Json(name = "eWarrantyID")
    var eWarrantyID: Int? = null,
    @Json(name = "eWarrantyQty")
    var eWarrantyQty: Int? = null,
    @Json(name = "emailId")
    var emailId: Any? = null,
    @Json(name = "generatorEmailId")
    var generatorEmailId: Any? = null,
    @Json(name = "generatorMobile")
    var generatorMobile: Any? = null,
    @Json(name = "invoiceDate")
    var invoiceDate: String? = null,
    @Json(name = "invoiceImage")
    var invoiceImage: Any? = null,
    @Json(name = "invoiceNum")
    var invoiceNum: Any? = null,
    @Json(name = "isWarranty")
    var isWarranty: Int? = null,
    @Json(name = "loyaltyId")
    var loyaltyId: String? = null,
    @Json(name = "mobileNum")
    var mobileNum: String? = null,
    @Json(name = "monthOfScanning")
    var monthOfScanning: Any? = null,
    @Json(name = "plantName")
    var plantName: Any? = null,
    @Json(name = "prodWarrantyDesc")
    var prodWarrantyDesc: Any? = null,
    @Json(name = "productCode")
    var productCode: String? = null,
    @Json(name = "productDiscript")
    var productDiscript: String? = null,
    @Json(name = "productId")
    var productId: Int? = null,
    @Json(name = "productName")
    var productName: Any? = null,
    @Json(name = "qrCode")
    var qrCode: String? = null,
    @Json(name = "scannedCode")
    var scannedCode: Any? = null,
    @Json(name = "sizeDesc")
    var sizeDesc: Any? = null,
    @Json(name = "subHelpTopicId")
    var subHelpTopicId: Int? = null,
    @Json(name = "successQRCount")
    var successQRCount: Int? = null,
    @Json(name = "thickDesc")
    var thickDesc: Any? = null,
    @Json(name = "total_Row")
    var totalRow: Int? = null,
    @Json(name = "warrantyFilePath")
    var warrantyFilePath: Any? = null,
    @Json(name = "warrantyPoints")
    var warrantyPoints: Double? = null,
    @Json(name = "zipCode")
    var zipCode: Any? = null
)

@JsonClass(generateAdapter = true)
data class GetdealerNameRequest(
    @Json(name = "ActionType")
    var actionType: Int? = null,
    @Json(name = "ActorId")
    var actorId: Int? = null
)


@JsonClass(generateAdapter = true)
data class GetdealerNameResponse(
    @Json(name = "lstCust1ParentChildMapping")
    var lstCust1ParentChildMapping: List<Any?>? = null,
    @Json(name = "lstCustParentChildMapping")
    var lstCustParentChildMapping: List<LstCustParentChildMapping?>? = null,
    @Json(name = "returnMessage")
    var returnMessage: Any? = null,
    @Json(name = "returnValue")
    var returnValue: Int? = null,
    @Json(name = "totalRecords")
    var totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstCustParentChildMapping(
    @Json(name = "address1")
    var address1: Any? = null,
    @Json(name = "address2")
    var address2: Any? = null,
    @Json(name = "addressLatitude")
    var addressLatitude: Any? = null,
    @Json(name = "addressLongitude")
    var addressLongitude: Any? = null,
    @Json(name = "childCustomerUserId")
    var childCustomerUserId: Int? = null,
    @Json(name = "childFirstName")
    var childFirstName: Any? = null,
    @Json(name = "childLoyaltyId")
    var childLoyaltyId: Any? = null,
    @Json(name = "childMobileNumber")
    var childMobileNumber: Any? = null,
    @Json(name = "cityId")
    var cityId: Int? = null,
    @Json(name = "cityName")
    var cityName: Any? = null,
    @Json(name = "cust1FirstName")
    var cust1FirstName: Any? = null,
    @Json(name = "cust1UserId")
    var cust1UserId: Int? = null,
    @Json(name = "cust2FirstName")
    var cust2FirstName: Any? = null,
    @Json(name = "cust2UserId")
    var cust2UserId: Int? = null,
    @Json(name = "custTypeID")
    var custTypeID: Int? = null,
    @Json(name = "customerGrade")
    var customerGrade: Any? = null,
    @Json(name = "customerImage")
    var customerImage: Any? = null,
    @Json(name = "customerType")
    var customerType: Any? = null,
    @Json(name = "designationName")
    var designationName: Any? = null,
    @Json(name = "email")
    var email: Any? = null,
    @Json(name = "enrollmentDate")
    var enrollmentDate: String? = null,
    @Json(name = "firmName")
    var firmName: Any? = null,
    @Json(name = "firstName")
    var firstName: String? = null,
    @Json(name = "isActive")
    var isActive: Int? = null,
    @Json(name = "lastName")
    var lastName: Any? = null,
    @Json(name = "lastPurchaseDate")
    var lastPurchaseDate: Any? = null,
    @Json(name = "lastRedemptionDate")
    var lastRedemptionDate: Any? = null,
    @Json(name = "loyaltyID")
    var loyaltyID: String? = null,
    @Json(name = "masterCustomerUser")
    var masterCustomerUser: Any? = null,
    @Json(name = "masterCustomerUserId")
    var masterCustomerUserId: Int? = null,
    @Json(name = "mobile")
    var mobile: String? = null,
    @Json(name = "parentFirstName")
    var parentFirstName: Any? = null,
    @Json(name = "parentLoyaltyId")
    var parentLoyaltyId: Any? = null,
    @Json(name = "parentMobileNumber")
    var parentMobileNumber: Any? = null,
    @Json(name = "parentUserId")
    var parentUserId: Int? = null,
    @Json(name = "password")
    var password: Any? = null,
    @Json(name = "preferDealer")
    var preferDealer: Any? = null,
    @Json(name = "remarks")
    var remarks: Any? = null,
    @Json(name = "seFirstName")
    var seFirstName: Any? = null,
    @Json(name = "seLoyaltyId")
    var seLoyaltyId: Any? = null,
    @Json(name = "seName")
    var seName: Any? = null,
    @Json(name = "seUserId")
    var seUserId: Int? = null,
    @Json(name = "sfaCode")
    var sfaCode: Any? = null,
    @Json(name = "talukName")
    var talukName: String? = null,
    @Json(name = "territoryName")
    var territoryName: Any? = null,
    @Json(name = "totalEnrollCount")
    var totalEnrollCount: Int? = null,
    @Json(name = "totalPointsBalance")
    var totalPointsBalance: Int? = null,
    @Json(name = "totalPointsEarned")
    var totalPointsEarned: Any? = null,
    @Json(name = "totalPointsRedeemed")
    var totalPointsRedeemed: Any? = null,
    @Json(name = "totalRedeemedCount")
    var totalRedeemedCount: Int? = null,
    @Json(name = "totalTransactionCount")
    var totalTransactionCount: Int? = null,
    @Json(name = "userID")
    var userID: Int? = null,
    @Json(name = "verificationStatus")
    var verificationStatus: Int? = null
)