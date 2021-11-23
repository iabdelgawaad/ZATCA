# QR-Code-Zatca
QR-Code implementation for the e-invoicing (Fatoora)
https://zatca.gov.sa/ar/E-Invoicing/Introduction/Pages/What-is-e-invoicing.aspx

  - Enter seller information 
<img src="https://github.com/iabdelgawaad/QR-Cod-Zatca/blob/main/zatca_merchant_data.png" width="400" height="800">

  - Base64 and QR Generated 
<img src="https://github.com/iabdelgawaad/QR-Cod-Zatca/blob/main/zatca_qr_code_and_base64.png" width="400" height="800">

# Know How

In this repo, we will demonstrate how to simply implement a QR code for the ZATCA (Fatoora). For this, the following steps will be explored:

Using TLV to start generating the QR code.

By Creating a TLV Byte Array for each tag like this: 

```
 tlv1 = byteArrayOf(tag.toByte(), length.toByte()).plus(value.toByteArray())
```

Then do same for the 5 tags and Convert to base64 code:

```
 var tlvs = tlv1 + tlv2 + tlv3 + tlv4 + tlv5
 return Base64.encodeToString(tlvs, Base64.DEFAULT)
```

Finally, Genearte the QR-code.

# Usage

Step 1. Add ZatcaQRCodeGeneration class to your project 


Step 2. use class Builder to add your merchant data like below: 


```  
builder.sellerName(sellerNameEditText?.text?.toString())
                .taxNumber(taxNumberEditText?.text?.toString())
                .invoiceDate(dateTimeEditText?.text?.toString())
                .totalAmount(totalAmountWithVatEditText?.text?.toString())
                .taxAmount(vatAmountEditText?.text?.toString())
```

Finally, render QR code (you can pass Bitmap to your ImageView)

```  
showBottomSheet(builder.getBase64())
```

# Testing 

- Download this app to validate is your QR code is meet [Zatca](https://zatca.gov.sa/) requirements or not: 
[E-Invoice QR Reader KSA قارئ الفاتورة الالكترونية](https://play.google.com/store/apps/details?id=com.posbankbh.einvoiceqrreader)
