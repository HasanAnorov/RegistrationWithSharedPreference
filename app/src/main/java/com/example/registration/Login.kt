package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.registration.databinding.ActivityLoginBinding
import com.example.registration.models.User
import com.example.registration.utils.MySharedPreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.register.setOnClickListener {
           val intent = Intent(this,Register::class.java)
            startActivity(intent)
            finish()
        }

        MySharedPreference.init(this)
        val userList = MySharedPreference.getUserDataToMainActivity()
        val gson = Gson()
        val type = object : TypeToken<ArrayList<User>>() {
        }.type

        val userData :ArrayList<User> = gson.fromJson(userList,type)

        binding.login.setOnClickListener {
        if (!binding.email.text.isNullOrEmpty()||!binding.password.text.isNullOrEmpty()){

            //check user to existence
            for (i in 0 until userData.size){
                if (binding.email.text.toString()==userData[i].email&&binding.password.text.toString()==userData[i].password){
                    val intent = Intent(this,MainActivity::class.java)
                    intent.putExtra("email",binding.email.text.toString())
                    intent.putExtra("password",binding.password.text.toString())
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(intent)
                    finish()
                    break
                    }
                else{
                    Toast.makeText(this,"Login or password incorrect !",Toast.LENGTH_SHORT).show()
                    break
                    }
                }
            }

            else{
            Toast.makeText(this,"Please fill all fields",Toast.LENGTH_SHORT).show()
            }
        }
    }
}