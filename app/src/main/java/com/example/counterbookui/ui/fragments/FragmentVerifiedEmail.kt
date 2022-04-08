package com.example.counterbookui.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_verified_email.*
import kotlinx.android.synthetic.main.fragment_verify_email.*


class FragmentVerifiedEmail : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verified_email, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        nxt_step_profile_picture.setOnClickListener {
            (activity as RegistrationActivity).replaceRegistrationFragment(FragmentProfilePicture())
            (activity as RegistrationActivity).view6.setBackgroundColor(Color.parseColor("#223890"))
        }
    }
}