package com.example.rapidtech
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button

    var role: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        role = intent.getStringExtra("role")

        btnLogin.setOnClickListener {

            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (role == "admin" && username == "admin" && password == "1234") {
                startActivity(Intent(this, AdminActivity::class.java))
            }
            else if (role == "employee" && username == "emp" && password == "1234") {
                startActivity(Intent(this, EmployeeActivity::class.java))
            }
            else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show()
            }
        }
    }
}