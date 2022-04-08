package com.example.counterbookui.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.ui.ActivityRegistrationComplete
import com.example.counterbookui.ui.AddAUserDetails
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_add_users.*


class FragmentAddUsers : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        add_new_user.setOnClickListener {
            val intent = Intent (getActivity(), AddAUserDetails::class.java)
            getActivity()?.startActivity(intent)
        }

        nxt_step_regis_complete.setOnClickListener {
            val intent = Intent (getActivity(), ActivityRegistrationComplete::class.java)
            getActivity()?.startActivity(intent)

        }

    }


    }
