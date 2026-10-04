package com.example.rapidtech

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class EmployeeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_employee)



        // SESSION

        val sessionManager =
            SessionManager(this)

        val employeeName =
            sessionManager.getEmployeeName()

        val employeeCode =
            sessionManager.getEmployeeCode()



        // TEXTVIEWS

        val txtEmployeeName =
            findViewById<TextView>(
                R.id.txtEmployeeName
            )

        val txtEmployeeCode =
            findViewById<TextView>(
                R.id.txtEmployeeCode
            )



        txtEmployeeName.text =
            employeeName

        txtEmployeeCode.text =
            employeeCode



        // BUTTONS

        val btnServiceReport =
            findViewById<Button>(
                R.id.btnServiceReport
            )

        val btnHistory =
            findViewById<Button>(
                R.id.btnHistory
            )

        val bottomNavigation =
            findViewById<BottomNavigationView>(
                R.id.bottomNavigation
            )
        val btnLogout =
            findViewById<Button>(
                R.id.btnLogout
            )
        btnLogout.setOnClickListener {

            sessionManager.logout()

            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )

            finish()
        }



        btnServiceReport.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ServiceReportActivity::class.java
                )
            )
        }



        btnHistory.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    ReportsHistoryActivity::class.java
                )
            )
        }



        bottomNavigation.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.menu_attendance -> {

                    startActivity(
                        Intent(
                            this,
                            AttendanceActivity::class.java
                        )
                    )

                    true
                }

                else -> true
            }
        }
    }
}