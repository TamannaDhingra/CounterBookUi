package com.example.counterbookui.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_enter_details.*
import kotlinx.android.synthetic.main.fragment_upload_logo.*


class FragmentEnterDetails : Fragment(), TextWatcher {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setViewListeners()

        nxtstep_verifyemail.setOnClickListener {
            if (nxtstep_verifyemail.isEnabled==true){
           (activity as RegistrationActivity).replaceRegistrationFragment(FragmentVerifyEmail())
            }
        }

    }

    private fun setViewListeners() {
        name.addTextChangedListener(this)
        email.addTextChangedListener(this)
        phone.addTextChangedListener(this)
        pass.addTextChangedListener(this)
        cnfrmpass.addTextChangedListener(this)
    }

    /**This function is used to handle the colour change of the button after filling all edit texts*/
    private fun enterDetails(name: String, email: String,phone:String, password: String,cnfrmpassword:String) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(email) ||  TextUtils.isEmpty(phone)|| TextUtils.isEmpty(password) || TextUtils.isEmpty(cnfrmpassword)) {
          //  Toast.makeText(activity, "All fields required", Toast.LENGTH_LONG).show()
            nxtstep_verifyemail.isEnabled=false
            nxtstep_verifyemail.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_bg_grey))
        } else {
            nxtstep_verifyemail.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_background))
            nxtstep_verifyemail.isEnabled=true
        }
    }

    /** This function is called when we enter the text in all fields*/
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val name=name.text.toString()
        val email=email.text.toString()
        val phone=phone.text.toString()
        val password=pass.text.toString()
        val cnfrmpassword=cnfrmpass.text.toString()
        enterDetails(name, email, phone,password,cnfrmpassword)

    }

    override fun afterTextChanged(p0: Editable?) {

    }


}



