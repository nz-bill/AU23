package com.example.recyclerviewexempel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexempel.databinding.ListItemBinding

class UserAdapter2(val userList: List<User>, val clickListener: (User)-> Unit) : RecyclerView.Adapter<UserAdapter2.ViewHolder>(){

    class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        val tvName: TextView = binding.tvName
        val tvDescription: TextView = binding.tvDecription
        val imgView: ImageView = binding.imgProfile
        val cardView: CardView = binding.root
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
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
           clickListener(currentUserItem)
        }
    }
}