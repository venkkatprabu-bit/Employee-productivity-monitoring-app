package com.example.rapidtech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class AttendanceHistoryActivity
    : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_attendance_history
        )



        val recyclerAttendance =
            findViewById<RecyclerView>(
                R.id.recyclerAttendance
            )

        recyclerAttendance.layoutManager =
            LinearLayoutManager(this)



        val sessionManager =
            SessionManager(this)

        val employeeCode =
            sessionManager.getEmployeeCode()



        val database =
            DatabaseProvider.getDatabase(this)



        lifecycleScope.launch {

            val attendanceList =

                if (
                    sessionManager.getRole()
                    == "Admin"
                ) {

                    database.attendanceDao()
                        .getAllAttendance()

                } else {

                    database.attendanceDao()
                        .getAttendanceByEmployee(
                            employeeCode
                        )
                }

            recyclerAttendance.adapter =
                AttendanceAdapter(attendanceList)
        }
    }
}