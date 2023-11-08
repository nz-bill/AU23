package com.example.recyclerviewexempel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(val userList: List<User>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    class ViewHolder(userView: View) : RecyclerView.ViewHolder(userView){
        val tvName: TextView = userView.findViewById(R.id.tv_name)
        val tvDescription: TextView = userView.findViewById(R.id.tv_decription)
        val imgView: ImageView = userView.findViewById(R.id.img_profile)
        val cardView: CardView = userView.findViewById(R.id.cv_root)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
       return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentUserItem = userList[position]
        holder.tvName.text = currentUserItem.name
        holder.tvDescription.text = currentUserItem.description
        holder.imgView.setImageResource(currentUserItem.imgSrc)
        holder.cardView.setOnClickListener{
            Toast.makeText(holder.cardView.context,
                "Clicked on item: ${currentUserItem.name}",
                Toast.LENGTH_SHORT).show()
        }
    }
}