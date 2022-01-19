package com.alkemy.ongsomosmas.data.login

import com.alkemy.ongsomosmas.data.BaseDataSource
import com.alkemy.ongsomosmas.data.model.Login
import javax.inject.Inject

class LoginDataSource @Inject constructor(private val loginService: LoginService) :
    BaseDataSource() {
    suspend fun login(login: Login) = getResult { loginService.login(login) }
}