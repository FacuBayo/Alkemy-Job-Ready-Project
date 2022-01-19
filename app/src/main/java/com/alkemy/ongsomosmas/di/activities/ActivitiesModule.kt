package com.alkemy.ongsomosmas.di.activities

import com.alkemy.ongsomosmas.data.activities.ActivitiesRepository
import com.alkemy.ongsomosmas.data.activities.ActivitiesRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class ActivitiesModule {

    @Binds
    abstract fun bindActivitiesRepositoryImp(activitiesRepositoryImp: ActivitiesRepositoryImp): ActivitiesRepository
}