package com.alkemy.ongsomosmas.data.activities


import javax.inject.Inject

class ActivitiesRepositoryImp @Inject constructor(private val activitiesDataSource: ActivitiesDataSource): ActivitiesRepository {

    override suspend fun getActivities() = activitiesDataSource.getActivities()


}