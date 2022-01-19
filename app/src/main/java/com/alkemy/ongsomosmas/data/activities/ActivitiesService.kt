package com.alkemy.ongsomosmas.data.activities

import com.alkemy.ongsomosmas.data.model.ApiResponse
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ActivitiesService {

    @GET("api/activities")
    suspend fun getActivities(): Response<ApiResponse<List<ActivitiesResponse>>>
}