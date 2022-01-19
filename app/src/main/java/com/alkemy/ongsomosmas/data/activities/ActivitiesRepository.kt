package com.alkemy.ongsomosmas.data.activities

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import retrofit2.Response

interface ActivitiesRepository {

    suspend fun getActivities() : Resource<List<ActivitiesResponse>>
}