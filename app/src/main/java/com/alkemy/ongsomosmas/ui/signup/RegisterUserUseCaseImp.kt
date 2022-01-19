package com.alkemy.ongsomosmas.ui.signup

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse
import com.alkemy.ongsomosmas.data.signup.SignUpRepository

class RegisterUserUseCaseImp(
    private val repository: SignUpRepository
) : RegisterUserUseCase {

    override suspend fun invoke(
        name: String,
        email: String,
        passsword: String
    ): Resource<SignUpResponse> {
        return repository.registerUser(name, email, passsword)
    }
}