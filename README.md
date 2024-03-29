  <div id="top"></div>
<div align="center"> 
  <h1 align="center">(Kotlin & Java)- ZATCA (Fatoora) QR-Code Implementation</h1>
  QR-Code implementation for the e-invoicing (Fatoora)
  </p>
</div>

[Zatca-Fatoora](https://zatca.gov.sa/ar/E-Invoicing/Introduction/Pages/What-is-e-invoicing.aspx)

  - Enter seller information 
<img src="https://github.com/iabdelgawaad/ZATCA/blob/main/Screenshot_20220421_133111.png" width="400" height="800">

  - Base64 and QR Generated 
<img src="https://github.com/iabdelgawaad/ZATCA/blob/main/Screenshot_20220421_132708.png" width="400" height="800">

# How QR Generated

In this repo, we will demonstrate how to simply implement a QR code for the ZATCA (Fatoora). For this, the following steps will be explored:

Using TLV to start generating the QR code:

<img src="https://github.com/iabdelgawaad/ZATCA/blob/main/tags.png" width="1000" height="400">

Example: seller name is "Shawrma House"

- tag_seller_name = "1"
- length_seller_name = "Shawrma House"?.toByteArray()?.size?.toString()
- value_seller_name = "Shawrma House"

By Creating a TLV Byte Array for field like this: 

```java
 tlv1 = byteArrayOf(tag_seller_name.toByte(), length_seller_name.toByte()).plus(value_seller_name.toByteArray())
```

Then do same for the 5 tags and Convert to base64 code:

```java
 var tlvs = tlv1 + tlv2 + tlv3 + tlv4 + tlv5
   var text = Base64.encodeToString(tlvs, Base64.DEFAULT)
            return text.replace("\n", "")
```

Finally, Genearte the QR-cod from String using [Zxing](https://github.com/journeyapps/zxing-android-embedded) 

# Usage

Step 1. Add ZatcaQRCodeGeneration class to your project 


Step 2. use class Builder to add your merchant data like below: 


```java
builder.sellerName(sellerNameEditText?.text?.toString()) // Shawrma House
                .taxNumber(taxNumberEditText?.text?.toString()) // 1234567890
                .invoiceDate(dateTimeEditText?.text?.toString()) //..> date format recommended to be with this format "yyyy-MM-dd HH:mm:ss"
                .totalAmount(totalAmountWithVatEditText?.text?.toString()) // 100
                .taxAmount(vatAmountEditText?.text?.toString()) // 15
```
Output Base64 = 

```java 
AQ1TaGF3cm1hIEhvdXNlAgoxMjM0NTY3ODkwAxMyMi8xMS8yMDIxIDAzOjAwIGFtBAMxMDAFAjE1
```

Finally, you can convert Base64 string to Bitmap then render QR code image (you can pass Bitmap to your ImageView)

```java  
showBottomSheet(builder.getBase64())
```

# Testing 

- Download this app to validate is your QR code match [Zatca](https://zatca.gov.sa/) requirements or not: 
[الفاتورة الالكترونية](https://play.google.com/store/apps/details?id=com.elshazlygroup.invoice)

 - Sample of QR Reader 
<img src="https://github.com/iabdelgawaad/ZATCA/blob/main/vat_app_text.jpg" width="400" height="800">

## Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. 
Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. 
You can also simply open an issue with the tag "enhancement". Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>


## Credits
- [All Contributors](../../contributors)


## License
The MIT License (MIT). Please see [License File](LICENSE.md) for more information.

<p align="right">(<a href="#top">back to top</a>)</p>
