package com.example.roomexempel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.roomexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vm: MyViewModel

    var selectedItemPosition = -1
    var currentItem: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MyViewModel::class.java]

        vm.getAllUser().observe(this){ users ->
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
            binding.lvUsers.adapter = adapter

        }

        binding.lvUsers.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if (selectedItemPosition != -1){
                val tempPosition = parent.getChildAt(selectedItemPosition)
                tempPosition.setBackgroundColor(Color.TRANSPARENT)
            }

            selectedItemPosition = position
            currentItem = parent.getItemAtPosition(position) as User
            view.setBackgroundColor(Color.GREEN)
        }

        binding.lvUsers.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            val selectedUser = parent.getItemAtPosition(position) as User
            deleteUser(selectedUser)
        }

        binding.btnUpdate.setOnClickListener {
            updateUser()
        }

        binding.btnAdd.setOnClickListener {
            addUser()
        }
    }

    fun addUser(){
        try {
            val name = binding.etName.text.toString()
            val score = binding.etScore.text.toString().toDouble()
            val isHuman = binding.swHuman.isChecked

            val user = User(name = name, score = score, isHuman = isHuman)

            vm.addUser(user)

            binding.etName.text.clear()
            binding.etScore.text.clear()

        }catch (e : Exception){
            print(e.stackTrace)
            Toast.makeText(this,"Error adding user to database", Toast.LENGTH_SHORT).show()
        }
    }

    fun updateUser(){
        try {
            val name = binding.etName.text.toString()
            val score = binding.etScore.text.toString().toDouble()
            val isHuman = binding.swHuman.isChecked

            val user = User(currentItem!!.id, name,score,isHuman)

            vm.updateUser(user)

            binding.etName.text.clear()
            binding.etScore.text.clear()

        }catch (e : Exception){
            print(e.stackTrace)
            Toast.makeText(this,"Error updating user in database", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteUser(user:User):Boolean{
        val result = vm.deleteUser(user)
        return result.isCompleted
    }
}