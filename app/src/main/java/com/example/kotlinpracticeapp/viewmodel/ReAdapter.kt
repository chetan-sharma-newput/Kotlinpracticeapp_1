package com.example.kotlinpracticeapp.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpracticeapp.R
import com.example.kotlinpracticeapp.datamodels.UserDataBean
import kotlinx.android.synthetic.main.item_list.view.*
import javax.xml.transform.ErrorListener

class ReAdapter() : RecyclerView.Adapter<ReAdapter.ViewHolder>() {

    var userArrayList: ArrayList<UserDataBean>? = null
    var context: Context? = null
    var onItemClickListener: OnItemClickListener? = null


    interface OnItemClickListener {

        fun onItemClicked(position: Int)

    }

    public fun setListener(listener: OnItemClickListener) {
        this.onItemClickListener = listener
    }

    constructor(userArrayList: ArrayList<UserDataBean>?, context: Context?) : this() {
        this.userArrayList = userArrayList
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view: View = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindItems(userArrayList!!.get(position))

        holder.linearLayout?.setOnClickListener {

            onItemClickListener?.onItemClicked(position)
            Log.d("adapter", "Clicked")

        }
    }

    override fun getItemCount(): Int {

        return userArrayList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name_tv: TextView? = null
        var surName_tv: TextView? = null
        var linearLayout: LinearLayout? = null

        fun bindItems(userbean: UserDataBean) {

            itemView.name_tv.text = userbean.UserName
            itemView.sur_name_tv.text = userbean.UserSurName
            linearLayout = itemView.findViewById(R.id.linear_layout)
        }

    }


}