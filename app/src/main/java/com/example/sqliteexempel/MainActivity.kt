package com.example.sqliteexempel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.sqliteexempel.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var databaseHandler: DatabaseHandler

    var selectedItemPosition = -1
    var currentUserItem: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHandler = DatabaseHandler(this )

        binding.btnAdd.setOnClickListener {
            addUser()
        }

        binding.btnUpdate.setOnClickListener {

           if (currentUserItem != null){
               updateUser()
           }
        }
        showUsers()

        binding.lvUsers.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as User
            deleteUser(selectedItem)
        }

        binding.lvUsers.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (selectedItemPosition != -1){
                val previousSelectedItem = parent.getChildAt(selectedItemPosition)
                previousSelectedItem.setBackgroundColor(Color.TRANSPARENT)

            }

            selectedItemPosition = position
            currentUserItem = parent.getItemAtPosition(position) as User
            view.setBackgroundColor(Color.GREEN)
        }
    }

    fun deleteUser(user: User): Boolean{
        val result =databaseHandler.deleteUSer(user)
        showUsers()
        return result
    }

    fun updateUser(){
        try{
            val name = binding.etName.text.toString()
            val score = binding.etScore.text.toString().toDouble()
            val isHuman = binding.swHuman.isChecked

            val newUser = User(currentUserItem!!.id,name, score, isHuman)

            databaseHandler.updateUser(newUser)

            binding.etName.text.clear()
            binding.etScore.text.clear()
            showUsers()
            currentUserItem = null

        }catch (e : Exception){
            println(e.stackTrace)
            Toast.makeText(this,"Error updating user", Toast.LENGTH_SHORT).show()
        }
    }

    fun addUser(){

        try{
            val name = binding.etName.text.toString()
            val score = binding.etScore.text.toString().toDouble()
            val isHuman = binding.swHuman.isChecked

            val newUser = User(-1,name, score, isHuman)

            databaseHandler.addUser(newUser)

            binding.etName.text.clear()
            binding.etScore.text.clear()
            showUsers()
        }catch (e : Exception){
            println(e.stackTrace)
            Toast.makeText(this,"Error adding user", Toast.LENGTH_SHORT).show()
        }
    }

    fun showUsers(){
        val userList = databaseHandler.getAllUsers()

        val arraryAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList)

        binding.lvUsers.adapter = arraryAdapter
    }


}