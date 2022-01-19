package com.alkemy.ongsomosmas.di

import com.alkemy.ongsomosmas.data.aboutus.AboutUsRepository
import com.alkemy.ongsomosmas.data.aboutus.AboutUsRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
abstract class AboutUsModule {

    @Binds
    abstract fun bindAboutUsRepositoryImp(aboutUsRepositoryImp: AboutUsRepositoryImp): AboutUsRepository
}
