package com.example.counterbookui.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.fragments.FragmentWelcome

class AuthenticActivity : AppCompatActivity() {
    private val welcomeScreenFragment=FragmentWelcome()

    var currentFragment:Fragment?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentic)
        replaceFragment(welcomeScreenFragment)
    }
    override fun onBackPressed() {
        if (currentFragment is FragmentWelcome){
            finish()
        }else{
            super.onBackPressed()
        }
    }

    fun replaceFragment(fragment: Fragment?) {
        if (fragment != null) {
            currentFragment=fragment
            val transcation = supportFragmentManager.beginTransaction()
           transcation.addToBackStack(null)
            transcation.replace(R.id.fragment_container, fragment)
            transcation.commit()

        }

    }
}