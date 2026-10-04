package com.example.rapidtech

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(

    entities = [
        Report::class,
        Attendance::class,
        Employee::class
    ],

    version = 5,

    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun reportDao(): ReportDao

    abstract fun attendanceDao(): AttendanceDao

    abstract fun employeeDao(): EmployeeDao
}