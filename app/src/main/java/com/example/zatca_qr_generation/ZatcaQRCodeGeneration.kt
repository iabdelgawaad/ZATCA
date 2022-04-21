package com.example.zatca_qr_generation

import android.util.Base64

class ZatcaQRCodeGeneration {
    class Builder {
        val SELLER_NAME_TAG = "1"
        val TAX_NUMBER_TAG = "2"
        val INVOICE_DATE_TAG = "3"
        val TOTAL_AMOUNT_TAG = "4"
        val TAX_AMOUNT_TAG = "5"

        var sellerName: String = ""
        var taxNumber: String = ""
        var invoiceDate: String = ""
        var totalAmount: String = ""
        var taxAmount: String = ""

        fun sellerName(value: String?) = apply {
            if (value != null) {
                this.sellerName = value
            }
        }

        fun taxNumber(value: String?) = apply {
            if (value != null) {
                this.taxNumber = value
            }
        }

        fun invoiceDate(value: String?) = apply {
            if (value != null) {
                this.invoiceDate = value
            }
        }

        fun totalAmount(value: String?) = apply {
            if (value != null) {
                this.totalAmount = value
            }
        }

        fun taxAmount(value: String?) = apply {
            if (value != null) {
                this.taxAmount = value
            }
        }

        private fun convertTagsAndLengthToHexValues(
            tag: String,
            length: String,
            value: String
        ): ByteArray {
            return byteArrayOf(tag.toByte(), length.toByte()).plus(value.toByteArray())
        }

        fun getBase64(): String {

            val tlv1 = convertTagsAndLengthToHexValues(
                SELLER_NAME_TAG,
                sellerName?.toByteArray()?.size.toString(),
                sellerName
            )

            val tlv2 = convertTagsAndLengthToHexValues(
                TAX_NUMBER_TAG,
                taxNumber?.toByteArray()?.size.toString(),
                taxNumber
            )

            val tlv3 = convertTagsAndLengthToHexValues(
                INVOICE_DATE_TAG,
                invoiceDate?.toByteArray()?.size.toString(),
                invoiceDate
            )

            val tlv4 = convertTagsAndLengthToHexValues(
                TOTAL_AMOUNT_TAG,
                totalAmount?.toByteArray()?.size.toString(),
                totalAmount
            )

            val tlv5 = convertTagsAndLengthToHexValues(
                TAX_AMOUNT_TAG,
                taxAmount?.toByteArray()?.size.toString(),
                taxAmount
            )

            var tlvs = tlv1 + tlv2 + tlv3 + tlv4 + tlv5
            var text = Base64.encodeToString(tlvs, Base64.DEFAULT)
            return text.replace("\n", "")
        }
    }
}