package com.example.implicitintentsexempel

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.implicitintentsexempel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCall.setOnClickListener {
            val webPage = Uri.parse("https://www.android.com")
            val intent = Intent(Intent.ACTION_VIEW, webPage)
            startActivity(intent)
        }

//        binding.btnCall.setOnClickListener {
//            val mapCords = Uri.parse("geo:59, 18")
//            val intent = Intent(Intent.ACTION_VIEW, mapCords)
//            startActivity(intent)
//        }
//        binding.btnCall.setOnClickListener {
//            val telUri = Uri.parse("tel:0731234567")
//            val intent = Intent(Intent.ACTION_DIAL,telUri)
//            startActivity(intent)
//        }
    }
}