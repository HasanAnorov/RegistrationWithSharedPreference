package com.example.registration

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.User
import com.example.registration.utils.MySharedPreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userList = MySharedPreference.getUserDataToMainActivity()

        val gson = Gson()

        val type = object : TypeToken<ArrayList<User>>() {}.type

        val userData:ArrayList<User> =gson.fromJson(userList,type)

        for (i in 0 until userData.size){
            binding.tvInfo.text = userData[i].fullName+"    "+userData[i].email+"   "+userData[i].password+"\n"
        }


    }

}