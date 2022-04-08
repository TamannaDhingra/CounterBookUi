package com.example.counterbookui.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.fragment_verified_pass.*

class FragmentVerifiedPass : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verified_pass, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        save_and_conti.setOnClickListener {
            val intent = Intent (getActivity(), RegistrationActivity::class.java)
            getActivity()?.startActivity(intent)
        }

    }
}