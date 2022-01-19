package com.alkemy.ongsomosmas.data.login

import javax.inject.Inject
import com.alkemy.ongsomosmas.data.model.Login

class LoginRepository @Inject constructor(private val loginDataSource: LoginDataSource) {
    suspend fun login(email: String, password: String) =
        loginDataSource.login(Login(email, password))
}