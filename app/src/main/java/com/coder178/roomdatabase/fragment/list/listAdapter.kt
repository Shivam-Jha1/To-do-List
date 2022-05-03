package com.coder178.roomdatabase.fragment.list

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import com.coder178.roomdatabase.R
import com.coder178.roomdatabase.data.User
import kotlinx.android.synthetic.main.custom_listview.view.*

class listAdapter: RecyclerView.Adapter<listAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }


    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.indexid.text = currentItem.id.toString()
        holder.itemView.fname.text = currentItem.firstName
        holder.itemView.lname.text = currentItem.lastName
        holder.itemView.cage.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_listview,parent,false))
    }
    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }
}