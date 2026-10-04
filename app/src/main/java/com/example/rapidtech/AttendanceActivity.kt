package com.example.rapidtech

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import android.content.Intent
class AttendanceActivity : AppCompatActivity() {

    lateinit var txtDate: TextView
    lateinit var txtAttendanceStatus: TextView
    lateinit var txtWorkingHours: TextView

    lateinit var btnCheckIn: Button
    lateinit var btnCheckOut: Button
    lateinit var btnAttendanceHistory: Button
    private var checkInTimeMillis: Long = 0

    private lateinit var currentDate: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_attendance)



        txtDate =
            findViewById(R.id.txtDate)

        txtAttendanceStatus =
            findViewById(R.id.txtAttendanceStatus)

        txtWorkingHours =
            findViewById(R.id.txtWorkingHours)

        btnCheckIn =
            findViewById(R.id.btnCheckIn)

        btnCheckOut =
            findViewById(R.id.btnCheckOut)



        currentDate = SimpleDateFormat(
            "dd MMM yyyy",
            Locale.getDefault()
        ).format(Date())

        txtDate.text = currentDate

        btnAttendanceHistory.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AttendanceHistoryActivity::class.java
                )
            )
        }

        // CHECK IN

        btnCheckIn.setOnClickListener {

            checkInTimeMillis =
                System.currentTimeMillis()

            val checkInTime =
                SimpleDateFormat(
                    "hh:mm a",
                    Locale.getDefault()
                ).format(Date())

            txtAttendanceStatus.text =
                "Checked In"



            val sessionManager =
                SessionManager(this)

            val attendance = Attendance(

                employeeCode =
                    sessionManager.getEmployeeCode(),

                employeeName =
                    sessionManager.getEmployeeName(),

                date = currentDate,

                checkIn = checkInTime,

                checkOut = "-"
            )



            val database =
                DatabaseProvider.getDatabase(this)



            lifecycleScope.launch {

                database.attendanceDao()
                    .insertAttendance(attendance)
            }



            Toast.makeText(
                this,
                "Checked In Successfully",
                Toast.LENGTH_LONG
            ).show()
        }



        // CHECK OUT

        btnCheckOut.setOnClickListener {

            if (checkInTimeMillis == 0L) {

                Toast.makeText(
                    this,
                    "Please Check In First",
                    Toast.LENGTH_LONG
                ).show()

            } else {

                val checkOutTimeMillis =
                    System.currentTimeMillis()

                val totalMillis =
                    checkOutTimeMillis -
                            checkInTimeMillis

                val hours =
                    totalMillis / (1000 * 60 * 60)

                val minutes =
                    (totalMillis / (1000 * 60)) % 60

                txtWorkingHours.text =
                    "$hours Hours $minutes Minutes"

                txtAttendanceStatus.text =
                    "Checked Out"
                val checkOutTime =
                    SimpleDateFormat(
                        "hh:mm a",
                        Locale.getDefault()
                    ).format(Date())



                val sessionManager =
                    SessionManager(this)

                val database =
                    DatabaseProvider.getDatabase(this)



                lifecycleScope.launch {

                    database.attendanceDao()
                        .updateCheckOut(

                            employeeCode =
                                sessionManager.getEmployeeCode(),

                            date = currentDate,

                            checkOut = checkOutTime
                        )
                }
                Toast.makeText(
                    this,
                    "Checked Out Successfully",
                    Toast.LENGTH_LONG
                ).show()
            }
            btnAttendanceHistory =
                findViewById(
                    R.id.btnAttendanceHistory
                )
        }
    }
}