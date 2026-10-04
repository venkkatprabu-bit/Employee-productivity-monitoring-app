package com.example.rapidtech

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AttendanceDao {

    @Insert
    suspend fun insertAttendance(
        attendance: Attendance
    )



    // UPDATE CHECK OUT

    @Query(
        """
        UPDATE attendance
        SET checkOut = :checkOut
        WHERE employeeCode = :employeeCode
        AND date = :date
        """
    )

    suspend fun updateCheckOut(

        employeeCode: String,

        date: String,

        checkOut: String
    )



    // ADMIN

    @Query(
        "SELECT * FROM attendance ORDER BY id DESC"
    )

    suspend fun getAllAttendance()
            : List<Attendance>
    @Query(
        "SELECT COUNT(*) FROM attendance"
    )

    suspend fun getAttendanceCount(): Int



    // EMPLOYEE

    @Query(
        """
        SELECT * FROM attendance
        WHERE employeeCode = :employeeCode
        ORDER BY id DESC
        """
    )

    suspend fun getAttendanceByEmployee(
        employeeCode: String
    ): List<Attendance>
}