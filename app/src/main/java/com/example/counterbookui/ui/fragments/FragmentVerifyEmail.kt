package com.example.counterbookui.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.ui.RegistrationActivity
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_check_mail.*
import kotlinx.android.synthetic.main.fragment_enter_details.*
import kotlinx.android.synthetic.main.fragment_verify_email.*


class FragmentVerifyEmail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setSpanforResendverifyemail()

        nxt_step_verified.setOnClickListener {
            (activity as RegistrationActivity).replaceRegistrationFragment(FragmentVerifiedEmail())

        }

    }


    private fun setSpanforResendverifyemail(){
        val spannable = SpannableString(getString(R.string.resend))
        val fcolor= ForegroundColorSpan(Color.BLUE)
        spannable.setSpan(fcolor,26,32, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val underline= UnderlineSpan()
        spannable.setSpan(underline,26,32, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        tv_resendlinkemail.text = spannable
    }

    }
