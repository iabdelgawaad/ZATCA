package com.example.zatca_qr_generation

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.zxing.BarcodeFormat
import com.journeyapps.barcodescanner.BarcodeEncoder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var sellerNameEditText = findViewById<TextView>(R.id.seller_name_edit)
        var taxNumberEditText = findViewById<TextView>(R.id.tax_number_edit)
        var dateTimeEditText = findViewById<TextView>(R.id.date_time_edit)
        var totalAmountWithVatEditText = findViewById<TextView>(R.id.total_edit)
        var vatAmountEditText = findViewById<TextView>(R.id.vat_amount_edit)
        var convertButton = findViewById<TextView>(R.id.convert_button)

        dateTimeEditText?.text = DateUtil.getCurrentDate()
        convertButton?.setOnClickListener {
            val builder = ZatcaQRCodeGeneration.Builder()
            builder.sellerName(sellerNameEditText?.text?.toString())
                .taxNumber(taxNumberEditText?.text?.toString())
                .invoiceDate(dateTimeEditText?.text?.toString())
                .totalAmount(totalAmountWithVatEditText?.text?.toString())
                .taxAmount(vatAmountEditText?.text?.toString())
            showBottomSheet(builder.getBase64())
        }
    }

    private fun showBottomSheet(base64: String) {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_dialog, null)
        val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)
        var base64TextView = view.findViewById<TextView>(R.id.base64text)
        var qrCodeImageView = view.findViewById<ImageView>(R.id.qrcode_img)
        var zatcaButton = view.findViewById<Button>(R.id.zatca_app_button)

        base64TextView.text = base64
        qrCodeImageView.setImageBitmap(generateQRCodeFromText(base64))

        btnClose.setOnClickListener {
            dialog.dismiss()
        }

        zatcaButton?.setOnClickListener {
            openEInvoiceAApp()
        }

        dialog.setCancelable(false)
        dialog.setContentView(view)
        dialog.show()
    }

    private fun generateQRCodeFromText(content: String? = ""): Bitmap? {
        try {
            val barcodeEncoder = BarcodeEncoder()
            return barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, 300, 300)
        } catch (e: Exception) {
        }
        return null
    }

    private fun openEInvoiceAApp() {
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=com.posbankbh.einvoiceqrreader")
                )
            )
        } catch (e: Exception) {
        }
    }

}