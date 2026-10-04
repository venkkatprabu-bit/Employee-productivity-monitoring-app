package com.example.rapidtech

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employees")

data class Employee(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val employeeCode: String,

    val employeeName: String,

    val password: String,

    val designation: String
)