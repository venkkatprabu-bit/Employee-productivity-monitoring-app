package com.example.rapidtech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AdminActivity : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_admin
        )



        // VIEWS

        val txtTotalReports =
            findViewById<TextView>(
                R.id.txtTotalReports
            )

        val txtTotalEmployees =
            findViewById<TextView>(
                R.id.txtTotalEmployees
            )

        val btnAllReports =
            findViewById<Button>(
                R.id.btnAllReports
            )

        val btnAttendanceMonitor =
            findViewById<Button>(
                R.id.btnAttendanceMonitor
            )

        val btnLogoutAdmin =
            findViewById<Button>(
                R.id.btnLogoutAdmin
            )
        val btnAddEmployee =
            findViewById<Button>(
                R.id.btnAddEmployee
            )
        val btnViewEmployees =
            findViewById<Button>(
                R.id.btnViewEmployees
            )
        val txtTotalAttendance =
            findViewById<TextView>(
                R.id.txtTotalAttendance
            )



        // DATABASE

        val database =
            DatabaseProvider.getDatabase(this)



        lifecycleScope.launch {

            val reportsCount =
                database.reportDao()
                    .getAllReports()
                    .size

            val employeeCount =
                database.employeeDao()
                    .getEmployeeCount()

            val attendanceCount =
                database.attendanceDao()
                    .getAttendanceCount()



            runOnUiThread {

                txtTotalReports.text =
                    reportsCount.toString()

                txtTotalEmployees.text =
                    employeeCount.toString()

                txtTotalAttendance.text =
                    attendanceCount.toString()
            }
        }



        // STATIC EMPLOYEE COUNT
        // Later from database

        txtTotalEmployees.text = "1"


        btnViewEmployees.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    EmployeeListActivity::class.java
                )
            )
        }
        // VIEW ALL REPORTS

        btnAllReports.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ReportsHistoryActivity::class.java
                )
            )
        }

        btnAddEmployee.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AddEmployeeActivity::class.java
                )
            )
        }

        // ATTENDANCE MONITOR

        btnAttendanceMonitor.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AttendanceHistoryActivity::class.java
                )
            )
        }



        // LOGOUT

        btnLogoutAdmin.setOnClickListener {

            val sessionManager =
                SessionManager(this)

            sessionManager.logout()

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )

            finish()
        }
    }
}