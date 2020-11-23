package com.example.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.registration.databinding.ActivityRegisterBinding
import com.example.registration.models.User
import com.example.registration.utils.MySharedPreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList

class Register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var userList: ArrayList<User>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MySharedPreference.init(this)


        binding.Save.setOnClickListener {
            if (binding.fullname.text.toString().isNotEmpty()
                    && binding.email.text.toString().isNotEmpty()
                    && binding.password.text.toString().isNotEmpty()
                    && binding.passwordConfirm.text.toString().isNotEmpty()
                    && binding.password.text.toString() == binding.passwordConfirm.text.toString()
            ) {

                val fullName = binding.fullname.text.toString()
                val email = binding.email.text.toString()
                val password = binding.passwordConfirm.text.toString()

                val user = User(fullName, email, password)


                val data = MySharedPreference.userData
                val gson = Gson()

                if (data.equals("")) {
                    userList = ArrayList()
                    userList.add(user)
                } else {
                    val type = object : TypeToken<ArrayList<User>>() {}.type
                    userList = gson.fromJson(data, type)
                    userList.add(user)

                    val userData = gson.toJson(userList)

                    MySharedPreference.userData = userData
                }

                Toast.makeText(this, "User added ", Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.Login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)

            finish()
        }
    }
}