package com.example.counterbookui.ui.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.ui.AuthenticActivity
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_business_info.*
import kotlinx.android.synthetic.main.fragment_check_mail.*


class FragmentBusinessInfo : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_business_info, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        contbtn123.setOnClickListener {
            (activity as RegistrationActivity).replaceRegistrationFragment(FragmentUploadLogo())
            (activity as RegistrationActivity).view3.setBackgroundColor(Color.parseColor("#223890"))
        }


    }

    }
