package com.example.rapidtech

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class AddEmployeeActivity
    : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_add_employee
        )



        val etEmployeeCode =
            findViewById<EditText>(
                R.id.etEmployeeCode
            )

        val etEmployeeName =
            findViewById<EditText>(
                R.id.etEmployeeName
            )

        val etEmployeePassword =
            findViewById<EditText>(
                R.id.etEmployeePassword
            )

        val etDesignation =
            findViewById<EditText>(
                R.id.etDesignation
            )

        val btnSaveEmployee =
            findViewById<Button>(
                R.id.btnSaveEmployee
            )



        btnSaveEmployee.setOnClickListener {

            val employee = Employee(

                employeeCode =
                    etEmployeeCode.text.toString(),

                employeeName =
                    etEmployeeName.text.toString(),

                password =
                    etEmployeePassword.text.toString(),

                designation =
                    etDesignation.text.toString()
            )



            val database =
                DatabaseProvider.getDatabase(this)



            lifecycleScope.launch {

                database.employeeDao()
                    .insertEmployee(employee)
            }



            Toast.makeText(
                this,
                "Employee Added",
                Toast.LENGTH_LONG
            ).show()

            finish()
        }
    }
}