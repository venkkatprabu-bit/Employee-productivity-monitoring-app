package com.example.rapidtech

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")

data class Attendance(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val employeeCode: String,

    val employeeName: String,

    val date: String,

    val checkIn: String,

    val checkOut: String
)