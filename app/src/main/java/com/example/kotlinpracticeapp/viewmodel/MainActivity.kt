package com.example.kotlinpracticeapp.viewmodel

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpracticeapp.R
import com.example.kotlinpracticeapp.datamodels.UserDataBean
import com.example.kotlinpracticeapp.viewmodel.ReAdapter.OnItemClickListener
import com.example.kotlinpracticeapp.viewmodel.fragment.UserMoreDetailsFragment

class MainActivity : AppCompatActivity(), OnItemClickListener{



    var fragment_manager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction?=null
    var userDataBean: UserDataBean? = null
    var userArrayList: ArrayList<UserDataBean>? = null
    var recyclerView: RecyclerView?=null

    var recyclerAdapter: ReAdapter?=null
    var frameLayout:FrameLayout?=null
    var linearLayout: LinearLayout?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var et_name = findViewById<EditText>(R.id.name_et)
        var et_surname = findViewById<EditText>(R.id.sur_name_et)
        var button = findViewById<Button>(R.id.submit_button)
        var clear_button= findViewById<Button>(R.id.clear_button)
        var et_percentage = findViewById<EditText>(R.id.percentage_et)
        var et_marks = findViewById<EditText>(R.id.marks_et)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager= LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        frameLayout=findViewById(R.id.frame_layout)
        linearLayout=findViewById(R.id.linear_layout)

        fragment_manager= supportFragmentManager
        userArrayList = ArrayList()

        button.setOnClickListener {

            var userName = et_name.text.toString().trim()
            var surName = et_surname.text.toString().trim()
            var marks =     et_marks.text.toString().trim()
            var percentage = et_percentage.text.toString().trim()

            if(userName=="" || surName==""|| marks=="" ||percentage=="")
                Toast.makeText(this,"Please check before submit",Toast.LENGTH_SHORT).show()
            else {
                userDataBean = UserDataBean(userName, surName, marks, percentage)
                userArrayList!!.add(userDataBean!!)

                setRecyclerViewAdapter()

                et_name.setText("")
                et_surname.setText("")
                et_marks.setText("")
                et_percentage.setText("")

            }
            }

        clear_button.setOnClickListener{

                clearArrayList()
        }


    }
    fun setRecyclerViewAdapter()
    {
        recyclerAdapter = ReAdapter(userArrayList, this)
        recyclerAdapter!!.setListener(this)
        recyclerView!!.adapter= recyclerAdapter
    }

    fun clearArrayList()
    {

        userArrayList?.clear();
        recyclerAdapter?.notifyDataSetChanged()
    }


    override fun onItemClicked(position: Int) {

Log.d("mainA","came"+userArrayList?.get(position)?.UserName)
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val bundle=Bundle()

        bundle.putString("name",userArrayList?.get(position)?.UserName)
        bundle.putString("sur_name",userArrayList?.get(position)?.UserSurName)
        bundle.putString("marks",userArrayList?.get(position)?.Marks)
        bundle.putString("percentage",userArrayList?.get(position)?.Percentage)


        val userMoreDetailsFragment = UserMoreDetailsFragment()

        setVisibility(true,false)

        userMoreDetailsFragment.arguments=bundle
        fragmentTransaction=fragment_manager?.beginTransaction();
        fragmentTransaction?.replace(R.id.frame_layout,userMoreDetailsFragment)
        fragmentTransaction?.commit()

//        frameLayout?.visibility=View.VISIBLE
//        linearLayout?.visibility=View.GONE

    }

    public fun setVisibility(frame:Boolean,linear:Boolean){

        if(frame.equals(true))
        {
            frameLayout?.visibility=View.VISIBLE
            linearLayout?.visibility=View.GONE

        }
        else {
            frameLayout?.visibility = View.GONE
            linearLayout?.visibility = View.VISIBLE

        }
    }

    override fun onBackPressed() {
//        super.onBackPressed()

        setVisibility(false,true)

    }
}
