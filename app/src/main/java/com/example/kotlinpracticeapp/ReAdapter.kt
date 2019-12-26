package com.example.kotlinpracticeapp

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class ReAdapter() : RecyclerView.Adapter<ReAdapter.ViewHolder>() {

    var userArrayList: ArrayList<UserDataBean>? = null
    var context: Context? = null


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
    }

    override fun getItemCount(): Int {

        return userArrayList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name_tv:TextView?=null
        var surName_tv:TextView?=null


        fun bindItems(userbean: UserDataBean) {

            itemView.name_tv.text=userbean.UserName
            itemView.sur_name_tv.text=userbean.UserSurName
        }

    }


}