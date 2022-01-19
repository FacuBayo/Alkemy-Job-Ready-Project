package com.alkemy.ongsomosmas.data.home.welcome

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.WelcomeResponse

interface WelcomeRepository {

    suspend fun getWelcome() : Resource<List<WelcomeResponse>>

}