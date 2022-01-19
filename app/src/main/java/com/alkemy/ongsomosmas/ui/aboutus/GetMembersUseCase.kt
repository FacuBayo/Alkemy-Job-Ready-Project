package com.alkemy.ongsomosmas.ui.aboutus

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.MembersResponse

interface GetMembersUseCase {

    suspend operator fun invoke(
    ): Resource<List<MembersResponse>>
}