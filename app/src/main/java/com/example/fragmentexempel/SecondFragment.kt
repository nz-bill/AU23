package com.example.fragmentexempel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexempel.databinding.ActivityMainBinding
import com.example.fragmentexempel.databinding.FragmentFirstBinding
import com.example.fragmentexempel.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
       return binding.root
    }

    fun updateNameText(name:String){
        binding.etName.text = name
    }

    fun updatePasswordText(password:String){
        binding.etPassword.text = password
    }


}