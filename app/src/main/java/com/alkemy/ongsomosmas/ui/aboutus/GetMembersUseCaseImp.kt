package com.alkemy.ongsomosmas.ui.aboutus

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.aboutus.AboutUsRepository
import com.alkemy.ongsomosmas.data.model.MembersResponse
import com.alkemy.ongsomosmas.data.model.signup.SignUpResponse
import com.alkemy.ongsomosmas.data.signup.SignUpRepository

class GetMembersUseCaseImp(
    private val repository: AboutUsRepository
) : GetMembersUseCase {


    override suspend fun invoke(): Resource<List<MembersResponse>> {
        return repository.getMembers()
    }
}