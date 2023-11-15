package com.example.fragmentexempel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.commit
import com.example.fragmentexempel.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity(), FirstFragment.FragmentCommunicationListener {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val pagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = pagerAdapter

//       supportFragmentManager.commit {
//           add(R.id.frame_content, FirstFragment(),)
//       }
//
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val customTab = layoutInflater.inflate(R.layout.custom_tab,null)
            val icon = customTab.findViewById<ImageView>(R.id.tabIcon)
            val tabText = customTab.findViewById<TextView>(R.id.tabText)

            when (position) {
                0 -> {
                    tabText.text = "fragment 1"
                    icon.setImageResource(android.R.drawable.btn_star)
                }
                1 -> {
                    tabText.text = "fragment 2"
                    icon.setImageResource(android.R.drawable.dialog_frame)
                }

                2 -> {
                    tabText.text = "fragment 3"
                    icon.setImageResource(android.R.drawable.btn_plus)
                }
            }

            tab.customView = customTab
        }.attach()

        binding.btnFirst.setOnClickListener {
//            val bundle = Bundle()
//            bundle.putString("msg","Hello There")
//            val f1 = FirstFragment()
//            f1.arguments = bundle
//            supportFragmentManager.commit {
//
//                replace(R.id.frame_content, f1)
//            }

            binding.viewPager.currentItem--
        }

        binding.btnSecond.setOnClickListener {


            if (binding.viewPager.currentItem >= 2) {
                binding.viewPager.currentItem = 0
            } else binding.viewPager.currentItem++
//            supportFragmentManager.commit {
//                replace(binding.viewPager.id, SecondFragment())
//            }
        }
    }

    override fun onNameChanged(name: String) {
        val fragment = supportFragmentManager.findFragmentByTag("f1") as SecondFragment?
        fragment?.updateNameText(name)

        val fragment2 = supportFragmentManager.findFragmentByTag("f2") as BlankFragment?
        fragment2?.updateText(name)
    }

    override fun onPasswordChange(passsword: String) {
        val fragment = supportFragmentManager.findFragmentByTag("f1") as SecondFragment?
        fragment?.updatePasswordText(passsword )

    }
}