package com.alkemy.ongsomosmas.data.aboutus

import com.alkemy.ongsomosmas.data.model.ApiResponse
import com.alkemy.ongsomosmas.data.model.MembersResponse
import retrofit2.Response
import retrofit2.http.GET

interface AboutUsService {
    @GET("/api/members")
    suspend fun getMembers(): Response<ApiResponse<List<MembersResponse>>>
}