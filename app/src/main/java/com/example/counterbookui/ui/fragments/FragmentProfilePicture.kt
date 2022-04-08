package com.example.counterbookui.ui.fragments


import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.counterbookui.R
import com.example.counterbookui.ui.RegistrationActivity
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_choose_img_bottom_sheet.*
import kotlinx.android.synthetic.main.fragment_profile_picture.*
import kotlinx.android.synthetic.main.fragment_verified_email.*


class FragmentProfilePicture : Fragment() {
   lateinit var bottomSheetDialog: BottomSheetDialog
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_picture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        nxt_step_add_users.setOnClickListener {
            (activity as RegistrationActivity).replaceRegistrationFragment(FragmentAddUsers())
            (activity as RegistrationActivity).view7.setBackgroundColor(Color.parseColor("#223890"))
        }

        camerabtn.setOnClickListener {
            /** Used for Open Bottom Sheet Dialog */

             bottomSheetDialog = BottomSheetDialog(requireActivity());
            bottomSheetDialog.setContentView(R.layout.fragment_choose_img_bottom_sheet)
            bottomSheetDialog.show()

            /** Used for select img from gallery and camera */

            bottomSheetDialog.choose_camera.setOnClickListener {
                com.github.dhaval2404.imagepicker.ImagePicker.with(this).cameraOnly().crop().start()
            }

            bottomSheetDialog.choose_gallery.setOnClickListener {
                ImagePicker.with(this).galleryOnly().galleryMimeTypes(arrayOf("image/*")).crop()
                 .start()
            }
            bottomSheetDialog.remove_img.setOnClickListener {
                profile_img.setImageResource(R.mipmap.ic_circle_bg)
               bottomSheetDialog.dismiss()
            }


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode== Activity.RESULT_OK && requestCode== com.github.dhaval2404.imagepicker.ImagePicker.REQUEST_CODE) {



            if (data!=null){
                profile_img?.setImageURI(data?.data)
                bottomSheetDialog.dismiss()
            }



        }

    }


}


