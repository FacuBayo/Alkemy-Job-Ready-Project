package com.alkemy.ongsomosmas.data.home.welcome

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import javax.inject.Inject

class WelcomeRepositoryImp @Inject constructor(val welcomeDataSource: WelcomeDataSource) : WelcomeRepository {

    override suspend fun getWelcome(): Resource<List<WelcomeResponse>> =
        welcomeDataSource.getWelcome()

}