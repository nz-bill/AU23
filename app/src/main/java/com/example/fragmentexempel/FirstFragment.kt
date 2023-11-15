package com.example.fragmentexempel

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentexempel.databinding.ActivityMainBinding
import com.example.fragmentexempel.databinding.FragmentFirstBinding
import java.lang.Exception

class FirstFragment: Fragment() {

    var listener: FragmentCommunicationListener? = null

    lateinit var binding: FragmentFirstBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            listener = context as FragmentCommunicationListener
            println("successfully implemented listener interface")
        } catch (e: Exception){
            println("not implemented listener interface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val msg = arguments?.getString("msg")

        binding.btnSubmit.setOnClickListener {
            listener?.onNameChanged(binding.etUsername.text.toString())
            listener?.onPasswordChange(binding.etPassword.text.toString())
        }
        if(msg != null)
            binding.textView.text = msg
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }




    interface FragmentCommunicationListener{
        fun onNameChanged(name:String)
        fun onPasswordChange(passsword:String)
    }

}