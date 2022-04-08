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
import kotlinx.android.synthetic.main.fragment_enter_details.*
import kotlinx.android.synthetic.main.fragment_new_password.*
import kotlinx.android.synthetic.main.fragment_sign_in_screen.*


class FragmentSignIn : Fragment(), TextWatcher {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        forgotpass.setOnClickListener {
            (activity as AuthenticActivity).replaceFragment(FragmentForgotPass())
        }

        setViewListeners()

        //for Keyboard Down
        mConstraintLayout3.setOnClickListener(View.OnClickListener { v ->
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm!!.hideSoftInputFromWindow(view.windowToken, 0)
        })
    }

    private fun setViewListeners() {
        signInEmail.addTextChangedListener(this)
        signInPass.addTextChangedListener(this)

    }

    /**This function is used to handle the colour change of the button after filling all edit texts*/
    private fun enterDetails(email: String, pass: String) {
        if ( TextUtils.isEmpty(email) ||  TextUtils.isEmpty(pass) ) {
            //  Toast.makeText(activity, "All fields required", Toast.LENGTH_LONG).show()
            signInbtn.isEnabled=false
            signInbtn.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_bg_grey))
        } else {
            signInbtn.setBackground(ContextCompat.getDrawable(requireActivity(),R.drawable.btn_background))
            signInbtn.isEnabled=true
        }
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        val email=signInEmail.text.toString()
        val pass=signInPass.text.toString()
        enterDetails(email,pass)
    }

    override fun afterTextChanged(p0: Editable?) {

    }


}
