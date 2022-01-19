package com.alkemy.ongsomosmas.ui.activities

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse

interface GetActivitiesUseCase {

    suspend operator fun invoke(): Resource<List<ActivitiesResponse>>

}



