package com.alkemy.ongsomosmas.data.aboutus

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.MembersResponse

interface AboutUsRepository {
    suspend fun getMembers(): Resource<List<MembersResponse>>
}