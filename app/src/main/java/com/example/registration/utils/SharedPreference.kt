package com.example.registration.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreference {
    private const val NAME = "name"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    fun getUserDataToMainActivity(): String? {
        return preferences.getString("userData", "")
    }


    var userData: String?
        get() = preferences.getString("userData", "")
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("userData", value)
            }
        }

}