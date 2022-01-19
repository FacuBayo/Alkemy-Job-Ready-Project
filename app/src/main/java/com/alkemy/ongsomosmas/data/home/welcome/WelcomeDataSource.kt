package com.alkemy.ongsomosmas.data.home.welcome

import com.alkemy.ongsomosmas.data.BaseDataSource
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import javax.inject.Inject
import javax.sql.DataSource

class WelcomeDataSource @Inject constructor(private val welcomeService: WelcomeService) : BaseDataSource() {

    suspend fun getWelcome() = getResult{ welcomeService.getWelcome() }

}