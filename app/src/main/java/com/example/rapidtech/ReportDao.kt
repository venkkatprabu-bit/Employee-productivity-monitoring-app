package com.example.rapidtech

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ReportDao {

    @Insert
    suspend fun insertReport(
        report: Report
    )



    // ALL REPORTS

    @Query(
        "SELECT * FROM reports"
    )

    suspend fun getAllReports()
            : List<Report>



    // EMPLOYEE REPORTS

    @Query(
        """
        SELECT * FROM reports
        WHERE employeeCode = :employeeCode
        """
    )

    suspend fun getReportsByEmployee(
        employeeCode: String
    ): List<Report>



    // SEARCH REPORTS

    @Query(
        """
        SELECT * FROM reports
        WHERE customerName LIKE '%' || :search || '%'
        OR problem LIKE '%' || :search || '%'
        """
    )

    suspend fun searchReports(
        search: String
    ): List<Report>
}