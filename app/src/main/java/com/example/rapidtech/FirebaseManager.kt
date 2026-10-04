package com.example.rapidtech

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

object FirebaseManager {

    private val firestore =
        FirebaseFirestore.getInstance()

    fun uploadReport(
        report: Report
    ) {

        val reportMap =
            hashMapOf(

                "employeeCode"
                        to report.employeeCode,

                "customerName"
                        to report.customerName,

                "reportDate"
                        to report.reportDate,

                "problem"
                        to report.problem,

                "status"
                        to report.status,

                "pdfPath"
                        to report.pdfPath
            )



        firestore.collection("reports")

            .add(reportMap)

            .addOnSuccessListener {

                Log.d(
                    "FIREBASE",
                    "UPLOAD SUCCESS"
                )
            }

            .addOnFailureListener {

                Log.d(
                    "FIREBASE",
                    "UPLOAD FAILED: ${it.message}"
                )
            }
    }
}