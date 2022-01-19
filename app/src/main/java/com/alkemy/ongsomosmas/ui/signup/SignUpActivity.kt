package com.alkemy.ongsomosmas.ui.signup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.alkemy.ongsomosmas.R
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.databinding.ActivitySignUpBinding
import com.alkemy.ongsomosmas.ui.BaseActivity
import com.alkemy.ongsomosmas.ui.login.LoginActivity
import com.alkemy.ongsomosmas.utils.afterTextChanged
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : BaseActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setup()

        binding.tvLogin.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }

    private fun setup() {
        //Button enabled
        binding.btnRegister.isEnabled = false

        //Listeners
        with(binding) {
            btnRegister.setOnClickListener {
                showProgressDialog()
                signUpViewModel.signUp(
                    binding.etFirstName.text.toString(),
                    binding.etEmail.text.toString(),
                    binding.etPassword.text.toString()
                )
            }
        }

        // Validate data
        checkValue()

        //Observer
        signUpViewModel.signUpFormState.observe(this, Observer {
            val signUpFormState = it ?: return@Observer

            with(binding) {
                // Button enabled
                cbTermsAndCondition.setOnClickListener {
                    btnRegister.isEnabled =
                        signUpFormState.isDataValid && cbTermsAndCondition.isChecked
                }
                btnRegister.isEnabled = signUpFormState.isDataValid && cbTermsAndCondition.isChecked
                etFirstName.error = signUpFormState.nameError?.let(::getString)
                etEmail.error = signUpFormState.emailError?.let(::getString)
                etPassword.error = signUpFormState.passwordError?.let(::getString)
                etConfirmPassword.error = signUpFormState.samePasswordError?.let(::getString)
            }
        })

        signUpViewModel.signUpResponse.observe(this, {
            when (it.status) {

                Resource.Status.SUCCESS -> {
                    hideProgressDialog()
                    MaterialAlertDialogBuilder(this).setTitle("Sign up")
                        .setMessage(R.string.User_was_succesfully_register)
                        .setPositiveButton("OK") { _, _ ->
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        }.show()
                }

                Resource.Status.ERROR -> {
                    hideProgressDialog()
                    MaterialAlertDialogBuilder(this).setTitle(R.string.sign_up_lower_case)
                        .setMessage(R.string.User_was_not_succesfully_register)
                        .setPositiveButton(R.string.Ok_option) { _, _ ->
                            with(binding) {
                                etFirstName.error = getString(R.string.name_text)
                                etEmail.error = getString(R.string.email_text)
                                etPassword.error = getString(R.string.password_text)
                                etConfirmPassword.error = getString(R.string.same_password_text)
                            }
                        }.show()
                }
            }
        })

        signUpViewModel.signUpState.observe(this) {
            when (it) {
                is SignUpViewModel.SignUpState.Error -> {}
                is SignUpViewModel.SignUpState.Loading -> {
                    it.isLoading
                }
                is SignUpViewModel.SignUpState.Success -> {}
                is SignUpViewModel.SignUpState.PasswordError -> {
                    it.resourceId
                }
            }
        }
    }

    private fun checkValue() {
        with(binding) {
            etFirstName.afterTextChanged {
                signUpViewModel.onDataChanged(
                    etFirstName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString()
                )
            }

            etEmail.afterTextChanged {
                signUpViewModel.onDataChanged(
                    etFirstName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString()
                )
            }

            etPassword.afterTextChanged {
                signUpViewModel.onDataChanged(
                    etFirstName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString()
                )
            }

            etConfirmPassword.afterTextChanged {
                signUpViewModel.onDataChanged(
                    etFirstName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    etConfirmPassword.text.toString()
                )
            }


        }
    }

}