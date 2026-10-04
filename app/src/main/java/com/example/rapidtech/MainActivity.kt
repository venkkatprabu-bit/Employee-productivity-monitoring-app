package com.example.rapidtech

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var roleGroup: RadioGroup

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)



        // SESSION CHECK

        val sessionManager =
            SessionManager(this)

        if (sessionManager.isLoggedIn()) {

            if (
                sessionManager.getRole()
                == "Admin"
            ) {

                startActivity(
                    Intent(
                        this,
                        AdminActivity::class.java
                    )
                )

            } else {

                startActivity(
                    Intent(
                        this,
                        EmployeeActivity::class.java
                    )
                )
            }

            finish()
        }



        etUsername =
            findViewById(R.id.etUsername)

        etPassword =
            findViewById(R.id.etPassword)

        btnLogin =
            findViewById(R.id.btnLogin)

        roleGroup =
            findViewById(R.id.roleGroup)



        btnLogin.setOnClickListener {

            val username =
                etUsername.text.toString()

            val password =
                etPassword.text.toString()

            val selectedRole =
                roleGroup.checkedRadioButtonId



            if (selectedRole == -1) {

                Toast.makeText(
                    this,
                    "Select role",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }



            val database =
                DatabaseProvider.getDatabase(this)



            lifecycleScope.launch {

                val employee =
                    database.employeeDao()
                        .loginEmployee(
                            username,
                            password
                        )



                runOnUiThread {

                    if (employee != null) {

                        val role =

                            if (
                                employee.designation
                                == "Admin"
                            ) {

                                "Admin"

                            } else {

                                "Employee"
                            }



                        sessionManager.saveLogin(

                            employeeCode =
                                employee.employeeCode,

                            employeeName =
                                employee.employeeName,

                            role = role
                        )



                        if (role == "Admin") {

                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    AdminActivity::class.java
                                )
                            )

                        } else {

                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    EmployeeActivity::class.java
                                )
                            )
                        }

                        finish()

                    } else {

                        Toast.makeText(
                            this@MainActivity,
                            "Invalid Login",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }
}