package com.example.counterbookui.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.fragments.FragmentBusinessInfo
import com.example.counterbookui.ui.fragments.FragmentWelcome
import kotlinx.android.synthetic.main.fragment_new_password.*
import kotlinx.android.synthetic.main.toolbar.*

class RegistrationActivity : AppCompatActivity() {

    var currentFragment:Fragment?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        replaceRegistrationFragmentWithoutStack(FragmentBusinessInfo())

        bckbtn.setOnClickListener {
          
        }
    }


    override fun onBackPressed() {
        if (currentFragment is FragmentBusinessInfo){
            finish()
        }else{
            super.onBackPressed()
        }
    }
    fun textChangeListener(editText: EditText, editText1: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }

    /**This function is used to handle the colour change of the button after filling all edit texts*/
    fun enterDetails(pass: String, cnfrmpass: String) {
        if ( TextUtils.isEmpty(pass) ||  TextUtils.isEmpty(cnfrmpass) ) {
            //  Toast.makeText(activity, "All fields required", Toast.LENGTH_LONG).show()
            changepass.isEnabled=false
            changepass.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_bg_grey))
        } else {
            changepass.setBackground(ContextCompat.getDrawable(this,R.drawable.btn_background))
            changepass.isEnabled=true
        }
    }

    fun replaceRegistrationFragment(fragment: Fragment?) {
        if (fragment != null) {
            currentFragment=fragment
            val transcation = supportFragmentManager.beginTransaction()
            transcation.addToBackStack(null)
            transcation.replace(R.id.registration_container, fragment)
            transcation.commit()

        }
    }

    fun replaceRegistrationFragmentWithoutStack(fragment: Fragment?) {
        if (fragment != null) {
            currentFragment=fragment
            val transcation = supportFragmentManager.beginTransaction()
            transcation.replace(R.id.registration_container, fragment)
            transcation.commit()

        }
    }
}

