# QR-Cod-Zatca
QR-Code implementation for the e-invoicing (Fatoora)

On August 24, the Zakat, Tax and Customs Authority (ZATCA) announced the e-invoicing project (Fatoora), which will be mandatory starting December 4, 2021. Everyone liable to VAT and any other parties submitting tax bills on behalf of VAT-exempt providers is governed by ZATCA (Fatoora).

E-invoicing (Fatoora) will be implemented in two-phase:

Phase One, also known as the “Generation Phase,” will take effect on December 4, 2021.
Phase Two, called “Integration Phase,” will take effect on January 1, 2023, and will be executed in waves by designated taxpayer groups.
One of the main requirements of the ZATCA is the implementation of QR codes on tax invoices. QR code is an optical label that provides information about the tax invoice to which it is attached and can only be read by machines. As per the ZATCA instructions, the minimum requirements that must be shown after scanning a QR code are the following fields, which should be represented in form of based64 encoding:

Seller’s name.
Seller’ tax number, which is the VAT registration number.
Invoice date, which is the timestamp of the electronic invoice.
Invoice total amount, which is the electronic invoice total with VAT.
Tax amount, which is the VAT total.
