package com.example.rapidtech

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EmployeeDao {

    @Insert
    suspend fun insertEmployee(
        employee: Employee
    )



    @Query(
        """
        SELECT * FROM employees
        WHERE employeeCode = :employeeCode
        AND password = :password
        LIMIT 1
        """
    )

    suspend fun loginEmployee(
        employeeCode: String,
        password: String
    ): Employee?



    @Query(
        "SELECT * FROM employees"
    )

    suspend fun getAllEmployees()
            : List<Employee>
    @Query(
        "SELECT COUNT(*) FROM employees"
    )

    suspend fun getEmployeeCount(): Int
}