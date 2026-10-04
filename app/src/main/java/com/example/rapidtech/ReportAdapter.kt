package com.example.rapidtech

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ReportAdapter(
    private val reports: List<Report>
) : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    class ReportViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val txtReportTitle =
            itemView.findViewById<TextView>(R.id.txtReportTitle)

        val txtReportDate =
            itemView.findViewById<TextView>(R.id.txtReportDate)

        val txtCustomer =
            itemView.findViewById<TextView>(R.id.txtCustomer)

        val txtStatus =
            itemView.findViewById<TextView>(R.id.txtStatus)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReportViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(
                R.layout.item_report,
                parent,
                false
            )

        return ReportViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ReportViewHolder,
        position: Int
    ) {

        val report = reports[position]

        holder.txtReportTitle.text =
            report.problem

        holder.txtReportDate.text =
            report.reportDate

        holder.txtCustomer.text =
            "Customer : ${report.customerName}"

        holder.txtStatus.text =
            report.status



        // OPEN PDF ON CLICK

        holder.itemView.setOnClickListener {

            try {

                val file =
                    File(report.pdfPath)

                val uri = FileProvider.getUriForFile(
                    holder.itemView.context,
                    "${holder.itemView.context.packageName}.provider",
                    file
                )

                val intent =
                    Intent(Intent.ACTION_VIEW)

                intent.setDataAndType(
                    uri,
                    "application/pdf"
                )

                intent.flags =
                    Intent.FLAG_GRANT_READ_URI_PERMISSION

                holder.itemView.context.startActivity(intent)

            } catch (e: Exception) {

                Toast.makeText(
                    holder.itemView.context,
                    "PDF not found",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    override fun getItemCount(): Int {

        return reports.size
    }
}