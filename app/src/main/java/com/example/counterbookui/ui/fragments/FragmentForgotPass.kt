package com.example.counterbookui.ui.fragments

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import com.example.counterbookui.R
import com.example.counterbookui.ui.AuthenticActivity
import kotlinx.android.synthetic.main.fragment_check_mail.*
import kotlinx.android.synthetic.main.fragment_forgot_pass_screen.*
import kotlinx.android.synthetic.main.fragment_sign_in_screen.*


class FragmentForgotPass : Fragment(), TextWatcher {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_pass_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        sendemail1.setOnClickListener {
            if(sendemail1.isEnabled==true)
            (activity as AuthenticActivity).replaceFragment(FragmentCheckMail())
        }

        setViewListeners()

        //for Keyboard Down
        mConstraintLayout1.setOnClickListener(View.OnClickListener { v ->
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm!!.hideSoftInputFromWindow(view.windowToken, 0)
        })
    }

    private fun setViewListeners() {
        tvemail.addTextChangedListener(this)
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val email=tvemail.text.toString()
        enterDetails(email)
    }

    override fun afterTextChanged(p0: Editable?) {

    }

    /**This function is used to handle the colour change of the button after filling all edit texts*/
    private fun enterDetails(email: String) {
        if ( TextUtils.isEmpty(email) ) {
            //  Toast.makeText(activity, "All fields required", Toast.LENGTH_LONG).show()
            sendemail1.isEnabled=false
            sendemail1.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_bg_grey))
        } else {
            sendemail1.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_background))
            sendemail1.isEnabled=true
        }
    }


}
