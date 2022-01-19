package com.alkemy.ongsomosmas.data.activities

import com.alkemy.ongsomosmas.data.BaseDataSource
import javax.inject.Inject

class ActivitiesDataSource @Inject constructor(private val activitiesService: ActivitiesService): BaseDataSource(){

    suspend fun getActivities() = getResult { activitiesService.getActivities() }
}