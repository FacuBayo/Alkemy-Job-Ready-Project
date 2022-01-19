package com.alkemy.ongsomosmas.data.login

import com.alkemy.ongsomosmas.data.model.ApiResponse
import com.alkemy.ongsomosmas.data.model.Login
import com.alkemy.ongsomosmas.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("api/login")
    suspend fun login(@Body login: Login): Response<ApiResponse<LoginResponse>>
}