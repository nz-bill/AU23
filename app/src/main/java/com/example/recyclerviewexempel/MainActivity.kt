package com.example.recyclerviewexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.recyclerviewexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val userList = listOf(
        User("Bill", "en person", android.R.drawable.ic_media_next),
        User("Bosse", "en annan person", android.R.drawable.arrow_down_float),
        User("Banarne", "en tedje person", android.R.drawable.ic_delete),
        User("Bksahjhfg", "en fjärde person", android.R.drawable.btn_star),
        User("Bdwujfghl", "en femte person", android.R.drawable.ic_dialog_map),
        User("Bill", "en person", android.R.drawable.ic_media_next),
        User("Bosse", "en annan person", android.R.drawable.arrow_down_float),
        User("Banarne", "en tedje person", android.R.drawable.ic_delete),
        User("Bksahjhfg", "en fjärde person", android.R.drawable.btn_star),
        User("Bdwujfghl", "en femte person", android.R.drawable.ic_dialog_map),
        User("Bill", "en person", android.R.drawable.ic_media_next),
        User("Bosse", "en annan person", android.R.drawable.arrow_down_float),
        User("Banarne", "en tedje person", android.R.drawable.ic_delete),
        User("Bksahjhfg", "en fjärde person", android.R.drawable.btn_star),
        User("Bdwujfghl", "en femte person", android.R.drawable.ic_dialog_map),
        User("Bill", "en person", android.R.drawable.ic_media_next),
        User("Bosse", "en annan person", android.R.drawable.arrow_down_float),
        User("Banarne", "en tedje person", android.R.drawable.ic_delete),
        User("Bksahjhfg", "en fjärde person", android.R.drawable.btn_star),
        User("Bdwujfghl", "en femte person", android.R.drawable.ic_dialog_map),

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView: RecyclerView = binding.rvUserlist
        val layoutManager: LayoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        val adapter = UserAdapter2(userList) { user ->
            Toast.makeText(
                this,
                "Clicked on item: ${user.name}",
                Toast.LENGTH_SHORT
            ).show()
        }
        recyclerView.adapter = adapter

    }
}