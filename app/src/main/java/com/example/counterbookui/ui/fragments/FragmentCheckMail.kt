package com.example.counterbookui.ui.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.AuthenticActivity
import kotlinx.android.synthetic.main.fragment_check_mail.*


class FragmentCheckMail : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_check_mail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        setSpanforResend()
        contbtn1.setOnClickListener {
            (activity as AuthenticActivity).replaceFragment(FragmentNewPassword())
        }


        //for Keyboard Down
        mConstraintLayout.setOnClickListener(View.OnClickListener { v ->
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm!!.hideSoftInputFromWindow(view.windowToken, 0)
        })
    }


    private fun setSpanforResend(){
        val spannable = SpannableString(getString(R.string.resend))
        val fcolor= ForegroundColorSpan(Color.BLACK)
        spannable.setSpan(fcolor,26,32, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        val underline= UnderlineSpan()
        spannable.setSpan(underline,26,32, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)

        tv_resendlink.text = spannable
    }



}
