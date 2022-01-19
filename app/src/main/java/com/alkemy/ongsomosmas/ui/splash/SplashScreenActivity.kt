package com.alkemy.ongsomosmas.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alkemy.ongsomosmas.ui.home.HomeActivity
import com.alkemy.ongsomosmas.ui.login.LoginActivity
import com.alkemy.ongsomosmas.ui.login.LoginViewModel
import com.alkemy.ongsomosmas.ui.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        check()
    }

    private fun check() {
        if (loginViewModel.isUserLogged()) {
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}