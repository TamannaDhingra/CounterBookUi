package com.example.counterbookui.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.AuthenticActivity
import kotlinx.android.synthetic.main.fragment_welcome_screen.*


class FragmentWelcome : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          setSpan()

        tvacc_signin.setOnClickListener {
            (activity as AuthenticActivity).replaceFragment(FragmentSignIn())
        }
    }

    override fun onDetach() {
        super.onDetach()
         activity?.finish()

    }
    private fun setSpan(){
        val spannable = SpannableString(getString(R.string.sign_in))
        val fcolor=ForegroundColorSpan(Color.BLACK)
        spannable.setSpan(fcolor,25,32,Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val underline=UnderlineSpan()
        spannable.setSpan(underline,25,32,Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        tvacc_signin.text = spannable
    }


}