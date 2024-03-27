package com.example.realmexempel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.realmexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var vm: MyViewModel

    var selectedItemPosition = -1
    var currentUserItem: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[MyViewModel::class.java]

        vm.getAllUsers().observe(this){users ->
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, users)
            binding.lvUsers.adapter = adapter

        }

        binding.lvUsers.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            if(selectedItemPosition != -1){
                val previous = parent.getChildAt(selectedItemPosition)
                previous.setBackgroundColor(Color.TRANSPARENT)
            }
            selectedItemPosition = position
            currentUserItem = parent.getItemAtPosition(position) as User
            view.setBackgroundColor(Color.GREEN)
        }

        binding.lvUsers.onItemLongClickListener = AdapterView.OnItemLongClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as User
            deleteUser(selectedItem)
        }
        binding.btnAdd.setOnClickListener {
            addUser(null)
        }
        binding.btnUpdate.setOnClickListener {
            if (currentUserItem != null){
                addUser(currentUserItem)
            }
        }
    }

    private fun deleteUser(selectedItem: User): Boolean {
        vm.deleteUser(selectedItem)
        return true
    }

    private fun addUser(u: User?) {
       try {
           val user = User()

           if(u != null){
               user._id = u._id
           }

           user.name = binding.etName.text.toString()
           user.score = binding.etScore.text.toString().toDouble()
           user.isHuman = binding.swHuman.isChecked

           vm.addUser(user)

           binding.etName.text.clear()
           binding.etScore.text.clear()

       }catch (e: Exception){
           print(e.stackTrace)
           Toast.makeText(this, "failed to add User", Toast.LENGTH_SHORT).show()
       }
    }
}