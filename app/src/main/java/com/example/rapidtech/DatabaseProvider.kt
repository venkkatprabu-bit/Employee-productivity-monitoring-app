package com.example.rapidtech

import android.content.Context
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object DatabaseProvider {

    private var database: AppDatabase? = null

    fun getDatabase(
        context: Context
    ): AppDatabase {

        if (database == null) {

            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "rapidtech_database"
            )
                .fallbackToDestructiveMigration()
                .build()



            // INSERT DEFAULT ADMIN

            CoroutineScope(
                Dispatchers.IO
            ).launch {

                val adminExists =
                    database!!
                        .employeeDao()
                        .loginEmployee(
                            "ADMIN001",
                            "admin123"
                        )

                if (adminExists == null) {

                    val admin = Employee(

                        employeeCode =
                            "ADMIN001",

                        employeeName =
                            "Administrator",

                        password =
                            "admin123",

                        designation =
                            "Admin"
                    )

                    database!!
                        .employeeDao()
                        .insertEmployee(admin)
                }
            }
        }

        return database!!
    }
}