package com.example.rapidtech

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class ReportsHistoryActivity
    : AppCompatActivity() {

    lateinit var recyclerReports:
            RecyclerView

    lateinit var etSearch:
            EditText

    lateinit var database:
            AppDatabase

    lateinit var sessionManager:
            SessionManager

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_reports_history
        )



        recyclerReports =
            findViewById(
                R.id.recyclerReports
            )

        etSearch =
            findViewById(
                R.id.etSearch
            )



        recyclerReports.layoutManager =
            LinearLayoutManager(this)



        database =
            DatabaseProvider.getDatabase(this)

        sessionManager =
            SessionManager(this)



        loadReports("")



        etSearch.addTextChangedListener(

            object : TextWatcher {

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int
                ) {

                    loadReports(
                        s.toString()
                    )
                }

                override fun afterTextChanged(
                    s: Editable?
                ) {
                }
            }
        )
    }



    private fun loadReports(
        search: String
    ) {

        lifecycleScope.launch {

            val reports =

                if (search.isNotEmpty()) {

                    database.reportDao()
                        .searchReports(search)

                } else {

                    if (
                        sessionManager.getRole()
                        == "Admin"
                    ) {

                        database.reportDao()
                            .getAllReports()

                    } else {

                        database.reportDao()
                            .getReportsByEmployee(

                                sessionManager
                                    .getEmployeeCode()
                            )
                    }
                }

            recyclerReports.adapter =
                ReportAdapter(reports)
        }
    }
}