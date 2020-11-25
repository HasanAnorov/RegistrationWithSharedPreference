package com.example.registration.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.registration.adapters.UserListAdapter
import com.example.registration.databinding.ActivityMainBinding
import com.example.registration.models.User
import com.example.registration.utils.MySharedPreference
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.ArrayList


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var names = ArrayList<String>()
    private var list = ArrayList<User>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userList = MySharedPreference.getUserDataToMainActivity()

        val gson = Gson()

        val type = object : TypeToken<ArrayList<User>>() {}.type

        val userData:ArrayList<User> =gson.fromJson(userList,type)

//        setData()

//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,names)

//        binding.listView.adapter = adapter

//        binding.listView.setOnItemClickListener { parent, view, position, id ->

//        }
        //initUsers()
        list = userData

        binding.listView.adapter = UserListAdapter(this,list)

        binding.listView.setOnItemClickListener { parent, view, position, id ->

        }
    }

    private fun  initUsers(){
        list= ArrayList()

        for (i in 0 until 3) {
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
            list.add(User("Hasan", "anorovhasan@gmail.com", "password"))
        }
    }

    private fun setData(){
        names = ArrayList()

        for (i in 0 until 3){
            names.add("hasan")
            names.add("asus")
            names.add("lenova")
            names.add("php")
            names.add("acer")
            names.add("Tuf gaming")
        }

    }

}