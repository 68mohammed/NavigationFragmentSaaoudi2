package com.ccc.navigationfragmentsaaoudi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation :BottomNavigationView
    lateinit var frameLayout:FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        connectView()
        bottomNavigationClicks()
        chooseFragment(HomeFragment(),"HOME")
    }
    ///////////////////// دالة ربط الفيو بمتغيرات
    private fun connectView() {
        bottomNavigation=findViewById(R.id.bottonNav)
        frameLayout=findViewById(R.id.fContainer)

    }

    ////////////// دالة تصنت اي زر تم ضغطه من بوتوم نافيغاتور

    private fun bottomNavigationClicks() {
        bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    chooseFragment(HomeFragment(),"HOME")
                    supportActionBar?.title="HHHHHHHHHHHHHHHH"

                }
                 R.id.settings ->{
                     chooseFragment(SettingsFragment(),"SETTINGS")
                     supportActionBar?.title="SSSSSSSSSSSSSSSSSS"

                 }
                 R.id.oerson ->{
                     chooseFragment(PersonFragment(),"PERSON")
                     supportActionBar?.title="PPPPPPPPPPPPPPPPPPP"
                 }

            }
            true
        }

    }
    //////// دالة اختيار  الفراغمونت

    private fun chooseFragment(fragment: Fragment,tag:String) {
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fContainer,fragment,tag)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction.addToBackStack(tag)
        fragmentTransaction.commit()

    }

}