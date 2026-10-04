package com.example.rapidtech

import android.content.Intent
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class ServiceReportActivity : AppCompatActivity() {

    lateinit var etDate: EditText
    lateinit var etReportNo: EditText
    lateinit var etRegion: EditText
    lateinit var etArea: EditText
    lateinit var etLocation: EditText
    lateinit var etEngineer: EditText
    lateinit var etContact: EditText
    lateinit var etCustomer: EditText
    lateinit var etMachineModel: EditText
    lateinit var etSerialNo: EditText
    lateinit var etInstallDate: EditText
    lateinit var etProblem: EditText
    lateinit var etAction: EditText
    lateinit var etSpare: EditText
    lateinit var etVoltage: EditText
    lateinit var etCurrent: EditText
    lateinit var etEngineerRemarks: EditText
    lateinit var etCustomerRemarks: EditText
    lateinit var etSignature: EditText
    lateinit var etCustomerSignature: EditText

    lateinit var btnSubmit: Button
    lateinit var btnShare: Button

    lateinit var generatedPdfFile: File

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_service_report)

        etDate = findViewById(R.id.etDate)
        etReportNo = findViewById(R.id.etReportNo)
        etRegion = findViewById(R.id.etRegion)
        etArea = findViewById(R.id.etArea)
        etLocation = findViewById(R.id.etLocation)
        etEngineer = findViewById(R.id.etEngineer)
        etContact = findViewById(R.id.etContact)
        etCustomer = findViewById(R.id.etCustomer)
        etMachineModel = findViewById(R.id.etMachineModel)
        etSerialNo = findViewById(R.id.etSerialNo)
        etInstallDate = findViewById(R.id.etInstallDate)
        etProblem = findViewById(R.id.etProblem)
        etAction = findViewById(R.id.etAction)
        etSpare = findViewById(R.id.etSpare)
        etVoltage = findViewById(R.id.etVoltage)
        etCurrent = findViewById(R.id.etCurrent)
        etEngineerRemarks = findViewById(R.id.etEngineerRemarks)
        etCustomerRemarks = findViewById(R.id.etCustomerRemarks)
        etSignature = findViewById(R.id.etSignature)
        etCustomerSignature =
            findViewById(R.id.etCustomerSignature)

        btnSubmit = findViewById(R.id.btnSubmit)
        btnShare = findViewById(R.id.btnShare)

        btnSubmit.setOnClickListener {

            generatePDF()
        }

        btnShare.setOnClickListener {

            sharePDF()
        }
    }



    private fun generatePDF() {

        val pdfDocument = PdfDocument()

        val paint = Paint().apply {

            style = Paint.Style.STROKE
            strokeWidth = 2f
            textSize = 22f
        }

        val titlePaint = Paint().apply {

            textSize = 36f
            isFakeBoldText = true
            style = Paint.Style.FILL
        }



        val pageInfo = PdfDocument.PageInfo
            .Builder(1200, 2000, 1)
            .create()

        val page = pdfDocument.startPage(pageInfo)

        val canvas = page.canvas



        // OUTER BORDER

        canvas.drawRect(
            20f,
            20f,
            1180f,
            1900f,
            paint
        )



        // TITLE

        canvas.drawText(
            "SERVICE REPORT",
            420f,
            70f,
            titlePaint
        )



        // COMPANY

        canvas.drawText(
            "RAPIDTECH IT SERVICES PVT LTD",
            40f,
            120f,
            paint
        )



        // REGION / AREA / LOCATION

        canvas.drawRect(40f, 150f, 300f, 220f, paint)

        canvas.drawText(
            "Region: ${etRegion.text}",
            50f,
            195f,
            paint
        )

        canvas.drawRect(300f, 150f, 550f, 220f, paint)

        canvas.drawText(
            "Area: ${etArea.text}",
            320f,
            195f,
            paint
        )

        canvas.drawRect(550f, 150f, 1140f, 220f, paint)

        canvas.drawText(
            "Location: ${etLocation.text}",
            570f,
            195f,
            paint
        )



        // ENGINEER

        canvas.drawRect(40f, 220f, 650f, 290f, paint)

        canvas.drawText(
            "Engineer: ${etEngineer.text}",
            50f,
            265f,
            paint
        )

        canvas.drawRect(650f, 220f, 1140f, 290f, paint)

        canvas.drawText(
            "Contact: ${etContact.text}",
            670f,
            265f,
            paint
        )



        // CUSTOMER

        canvas.drawRect(40f, 290f, 1140f, 450f, paint)

        canvas.drawText(
            "Customer: ${etCustomer.text}",
            50f,
            340f,
            paint
        )



        // PROBLEM

        canvas.drawRect(40f, 450f, 1140f, 650f, paint)

        canvas.drawText(
            "Problem Reported:",
            50f,
            500f,
            paint
        )

        canvas.drawText(
            etProblem.text.toString(),
            70f,
            560f,
            paint
        )



        // ACTION

        canvas.drawRect(40f, 650f, 1140f, 900f, paint)

        canvas.drawText(
            "Action Taken / Observations:",
            50f,
            700f,
            paint
        )

        canvas.drawText(
            etAction.text.toString(),
            70f,
            760f,
            paint
        )



        // MACHINE DETAILS

        canvas.drawRect(40f, 900f, 1140f, 1050f, paint)

        canvas.drawLine(250f, 900f, 250f, 1050f, paint)
        canvas.drawLine(500f, 900f, 500f, 1050f, paint)
        canvas.drawLine(750f, 900f, 750f, 1050f, paint)

        canvas.drawText(
            "Machine Model",
            60f,
            960f,
            paint
        )

        canvas.drawText(
            etMachineModel.text.toString(),
            60f,
            1010f,
            paint
        )

        canvas.drawText(
            "Serial No",
            300f,
            960f,
            paint
        )

        canvas.drawText(
            etSerialNo.text.toString(),
            300f,
            1010f,
            paint
        )

        canvas.drawText(
            "Voltage",
            550f,
            960f,
            paint
        )

        canvas.drawText(
            etVoltage.text.toString(),
            550f,
            1010f,
            paint
        )

        canvas.drawText(
            "Current",
            800f,
            960f,
            paint
        )

        canvas.drawText(
            etCurrent.text.toString(),
            800f,
            1010f,
            paint
        )



        // REMARKS

        canvas.drawRect(40f, 1050f, 1140f, 1300f, paint)

        canvas.drawText(
            "Engineer Remarks:",
            50f,
            1110f,
            paint
        )

        canvas.drawText(
            etEngineerRemarks.text.toString(),
            60f,
            1170f,
            paint
        )



        // SIGNATURES

        canvas.drawRect(40f, 1400f, 500f, 1600f, paint)

        canvas.drawRect(650f, 1400f, 1140f, 1600f, paint)

        canvas.drawText(
            "Engineer Signature",
            120f,
            1450f,
            paint
        )

        canvas.drawText(
            etSignature.text.toString(),
            120f,
            1520f,
            paint
        )

        canvas.drawText(
            "Customer Signature",
            760f,
            1450f,
            paint
        )

        canvas.drawText(
            etCustomerSignature.text.toString(),
            760f,
            1520f,
            paint
        )



        pdfDocument.finishPage(page)



        val file = File(

            getExternalFilesDir(null),

            "ServiceReport_${System.currentTimeMillis()}.pdf"
        )



        generatedPdfFile = file



        try {

            pdfDocument.writeTo(
                FileOutputStream(file)
            )



            val sessionManager =
                SessionManager(this)



            val report = Report(

                employeeCode =
                    sessionManager.getEmployeeCode(),

                customerName =
                    etCustomer.text.toString(),

                reportDate =
                    etDate.text.toString(),

                problem =
                    etProblem.text.toString(),

                status = "Completed",

                pdfPath =
                    file.absolutePath
            )



            val database =
                DatabaseProvider.getDatabase(this)



            lifecycleScope.launch {

                database.reportDao()
                    .insertReport(report)



                FirebaseManager
                    .uploadReport(report)



                runOnUiThread {

                    Toast.makeText(
                        this@ServiceReportActivity,
                        "Report Saved Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

        } catch (e: Exception) {

            Toast.makeText(
                this,
                e.message,
                Toast.LENGTH_LONG
            ).show()
        }



        pdfDocument.close()
    }



    private fun sharePDF() {

        if (!::generatedPdfFile.isInitialized) {

            Toast.makeText(
                this,
                "Generate PDF first",
                Toast.LENGTH_LONG
            ).show()

            return
        }



        val uri = FileProvider.getUriForFile(

            this,

            "$packageName.provider",

            generatedPdfFile
        )



        val intent = Intent(Intent.ACTION_SEND)

        intent.type = "application/pdf"

        intent.putExtra(
            Intent.EXTRA_STREAM,
            uri
        )

        intent.addFlags(
            Intent.FLAG_GRANT_READ_URI_PERMISSION
        )



        startActivity(

            Intent.createChooser(
                intent,
                "Share PDF"
            )
        )
    }
}