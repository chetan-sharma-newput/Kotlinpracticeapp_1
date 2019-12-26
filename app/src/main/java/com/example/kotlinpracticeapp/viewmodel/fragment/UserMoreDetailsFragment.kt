package com.example.kotlinpracticeapp.viewmodel.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.kotlinpracticeapp.R

/**
 * A simple [Fragment] subclass.
 */
class UserMoreDetailsFragment : Fragment() {

    var name_tv_f: TextView? = null
    var sur_name_tv_f: TextView? = null
    var marks_tv_f: TextView? = null
    var percentage_tv_f: TextView? = null
//    var ok_button: Button? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_user_more_details, container, false)
        inUI(view)
        getBundle()


        ok_button?.setOnClickListener {
            activity?.onBackPressed()
        }



        return view

    }

    private fun getBundle() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        var bundle: Bundle? = arguments

        var name = bundle?.getString("name")
        var sur_name = bundle?.getString("sur_name")
        var marks = bundle?.getString("marks")
        var percentage = bundle?.getString("percentage")


        name_tv_f?.setText("Name - "+name)
        sur_name_tv_f?.setText("Sur Name - "+sur_name)
        marks_tv_f?.setText("Marks - "+marks)
        percentage_tv_f?.setText("Percentage - "+percentage)
        Log.d("mainF"," "+name+" "+sur_name+" "+marks+" "+percentage )


    }


    fun inUI(view: View) {

        name_tv_f = view.findViewById(R.id.name_tv_f)
        sur_name_tv_f = view.findViewById(R.id.sur_name_tv_f)
        marks_tv_f = view.findViewById(R.id.marks_tv_f)
        percentage_tv_f = view.findViewById(R.id.percentage_tv_f)
        ok_button = view.findViewById(R.id.ok_button)
    }


}
