package com.example.counterbookui.ui.fragments

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.counterbookui.R
import com.example.counterbookui.databinding.FragmentChooseImgBottomSheetBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.fragment_choose_img_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_profile_picture.*


class ChooseImgBottomSheet(context:Activity) : BottomSheetDialog(context) {

    lateinit var binding:FragmentChooseImgBottomSheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= FragmentChooseImgBottomSheetBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*choose_camera.setOnClickListener {
            com.github.dhaval2404.imagepicker.ImagePicker.with(this).cameraOnly().crop().start()

        }*/



    }




    }


