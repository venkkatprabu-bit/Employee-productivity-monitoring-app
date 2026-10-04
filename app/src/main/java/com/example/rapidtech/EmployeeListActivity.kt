package com.example.rapidtech

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class EmployeeListActivity
    : AppCompatActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_employee_list
        )



        val recyclerEmployees =
            findViewById<RecyclerView>(
                R.id.recyclerEmployees
            )

        recyclerEmployees.layoutManager =
            LinearLayoutManager(this)



        val database =
            DatabaseProvider.getDatabase(this)



        lifecycleScope.launch {

            val employees =
                database.employeeDao()
                    .getAllEmployees()

            recyclerEmployees.adapter =
                EmployeeAdapter(employees)
        }
    }
}