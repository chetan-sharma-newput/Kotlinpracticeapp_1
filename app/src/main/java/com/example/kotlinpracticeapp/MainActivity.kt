package com.example.kotlinpracticeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Surface
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    var fragment_manager: FragmentManager? = null
    var userDataBean: UserDataBean? = null
    var userArrayList: ArrayList<UserDataBean>? = null
    var recyclerView: RecyclerView?=null

    var recyclerAdapter:ReAdapter?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var et_name = findViewById<EditText>(R.id.name_et)
        var et_surname = findViewById<EditText>(R.id.sur_name_et)
        var button = findViewById<Button>(R.id.submit_button)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        userArrayList = ArrayList()

        button.setOnClickListener {

            var userName = et_name.text.toString()
            var surName = et_surname.text.toString()

            userDataBean = UserDataBean(userName,surName)
            userArrayList!!.add(userDataBean!!)

            setRecyclerViewAdapter()

//            Toast.makeText(this, userArrayList.toString(), Toast.LENGTH_SHORT).show()

        }
    }

    fun setRecyclerViewAdapter()
    {
        recyclerAdapter = ReAdapter(userArrayList,this)
        recyclerView!!.adapter= recyclerAdapter
    }
}
