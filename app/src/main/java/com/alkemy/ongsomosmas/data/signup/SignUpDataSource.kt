package com.alkemy.ongsomosmas.data.signup

import com.alkemy.ongsomosmas.data.BaseDataSource
import com.alkemy.ongsomosmas.data.model.User
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class SignUpDataSource @Inject constructor(private val signUpService: SignUpService): BaseDataSource() {


    suspend fun registerUser(user: User) = getResult { signUpService.registerUser(user) }



}

