package com.example.rapidtech

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reports")

data class Report(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val employeeCode: String,

    val customerName: String,

    val reportDate: String,

    val problem: String,

    val status: String,

    val pdfPath: String
)