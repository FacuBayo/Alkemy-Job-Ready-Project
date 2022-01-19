package com.alkemy.ongsomosmas

import com.alkemy.ongsomosmas.ui.login.LoginFormState

val loginFormStateEmailError = LoginFormState(emailError = R.string.error_state_msg_invalid_email, isDataValid = false)

val loginFormStatePasswordError = LoginFormState(passwordError = R.string.error_state_msg_invalid_password_signUp, isDataValid = false)

val loginFormStateSuccess = LoginFormState(isDataValid = true)
