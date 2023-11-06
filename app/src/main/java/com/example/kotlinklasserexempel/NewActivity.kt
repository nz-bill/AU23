package com.example.kotlinklasserexempel

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.kotlinklasserexempel.databinding.ActivityNewBinding

class NewActivity : AppCompatActivity() {

    lateinit var binder: ActivityNewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityNewBinding.inflate(layoutInflater)
        setContentView(binder.root)

        val user = getSerializable(intent,"currentUser", DataKlass::class.java)

        binder.tvName.text = user?.name
        binder.tvAge.text = user?.age.toString()
        binder.tvEmail.text = user?.email
        binder.tvPhone.text = user?.phone
    }
}