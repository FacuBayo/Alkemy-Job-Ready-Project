package com.alkemy.ongsomosmas.data.signup

import com.alkemy.ongsomosmas.data.model.ApiResponse
import com.alkemy.ongsomosmas.data.model.User
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {

    @POST("api/register")
    suspend fun registerUser(@Body user: User) : Response<ApiResponse<SignUpResponse>>
}