package com.alkemy.ongsomosmas.ui

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import com.alkemy.ongsomosmas.R

open class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: Dialog

    fun showProgressDialog() {
        progressDialog = Dialog(this)

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