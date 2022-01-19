package com.alkemy.ongsomosmas.ui

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alkemy.ongsomosmas.R


open class BaseFragment(private val contentLayoutId: Int) : Fragment(contentLayoutId) {

    private lateinit var progressDialog: Dialog

    fun showProgressDialog() {
        progressDialog = Dialog(requireContext())

        /*Set the screen content from a layout resource.
        The resource will be inflated, adding all top-level views to the screen.*/
        progressDialog.setContentView(R.layout.layout_loading)

        progressDialog.setCancelable(false)
        progressDialog.setCanceledOnTouchOutside(false)

        //Start the dialog and display it on screen.
        progressDialog.show()
    }


    fun hideProgressDialog() {
        progressDialog.dismiss()
    }
}