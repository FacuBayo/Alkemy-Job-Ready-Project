package com.alkemy.ongsomosmas.ui.signup

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse

interface RegisterUserUseCase {

    suspend operator fun invoke(
        name: String,
        email: String,
        passsword: String
    ): Resource<SignUpResponse>
}