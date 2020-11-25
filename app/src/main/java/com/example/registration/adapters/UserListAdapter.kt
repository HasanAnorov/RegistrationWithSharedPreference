package com.example.registration.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.registration.R
import com.example.registration.models.User
import java.util.*


class UserListAdapter (var context: Context, var list: ArrayList<User>) :BaseAdapter(){


    override fun getCount(): Int = list!!.size

    override fun getItem(position: Int): Any  = list!![position]

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v :View = LayoutInflater.from(parent?.context).inflate(R.layout.my_item, parent, false)
        var userName = v.findViewById<TextView>(R.id.userName)
        userName.text = list?.get(position)?.fullName ?: ""
        return v
    }

}