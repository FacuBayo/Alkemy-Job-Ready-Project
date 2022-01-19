package com.alkemy.ongsomosmas.ui.activities

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.activities.ActivitiesRepository
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse

class GetActivitiesUseCaseImp(private val repository: ActivitiesRepository): GetActivitiesUseCase {

    override suspend fun invoke(): Resource<List<ActivitiesResponse>> {
        return repository.getActivities()
    }
}
