package com.example.rapidtech

import android.content.Context

class SessionManager(
    context: Context
) {

    private val sharedPreferences =
        context.getSharedPreferences(
            "RapidTechSession",
            Context.MODE_PRIVATE
        )



    // SAVE LOGIN SESSION

    fun saveLogin(

        employeeCode: String,

        employeeName: String,

        role: String
    ) {

        val editor =
            sharedPreferences.edit()

        editor.putBoolean(
            "isLoggedIn",
            true
        )

        editor.putString(
            "employeeCode",
            employeeCode
        )

        editor.putString(
            "employeeName",
            employeeName
        )

        editor.putString(
            "role",
            role
        )

        editor.apply()
    }



    // CHECK LOGIN

    fun isLoggedIn(): Boolean {

        return sharedPreferences.getBoolean(
            "isLoggedIn",
            false
        )
    }



    // GET EMPLOYEE CODE

    fun getEmployeeCode(): String {

        return sharedPreferences.getString(
            "employeeCode",
            ""
        ) ?: ""
    }



    // GET EMPLOYEE NAME

    fun getEmployeeName(): String {

        return sharedPreferences.getString(
            "employeeName",
            ""
        ) ?: ""
    }



    // GET ROLE

    fun getRole(): String {

        return sharedPreferences.getString(
            "role",
            ""
        ) ?: ""
    }



    // LOGOUT

    fun logout() {

        sharedPreferences.edit().clear().apply()
    }
}