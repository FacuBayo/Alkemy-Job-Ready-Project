package com.alkemy.ongsomosmas.di

import com.alkemy.ongsomosmas.data.signup.SignUpRepository
import com.alkemy.ongsomosmas.data.signup.SignUpRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


/**
 * This class provides an instance of SignUpRepository which is an interface to construct the SignUpViewModel,
 * We use "ActivityRetainedComponent::class" instead of "ApplicationComponent::class" which allow to persist the instance in the
 * lifecycle
 */

@Module
@InstallIn(ApplicationComponent::class)
abstract class SignUpModule {

    @Binds
    abstract fun bindSignUpRepositoryImp(signUpRepositoryImp: SignUpRepositoryImp): SignUpRepository
}