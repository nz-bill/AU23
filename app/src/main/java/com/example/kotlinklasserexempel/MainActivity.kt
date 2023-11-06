package com.example.kotlinklasserexempel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinklasserexempel.databinding.ActivityMainBinding
import java.io.DataInput

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = DataKlass("Bill",42,"mail.com","0731234567")


        binding.button.setOnClickListener {
            val intent = Intent(this,NewActivity::class.java)
            intent.putExtra("currentUser", user)
            startActivity(intent)
        }

//        val user = User("Bosse", 42)

//        val dataUser =DataKlass("Bill", 42, "mail.com", "+4670012345")
//        val dataUser2 = dataUser.copy(name = "nån annan")

//        println("user = ${user}")
//        println("dataUser = ${dataUser}")
//        println("dataUser2 = ${dataUser2}")





    }
}