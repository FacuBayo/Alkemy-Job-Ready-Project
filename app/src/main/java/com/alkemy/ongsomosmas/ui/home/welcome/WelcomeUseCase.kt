package com.alkemy.ongsomosmas.ui.home.welcome

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.WelcomeResponse

interface WelcomeUseCase {
    suspend operator fun invoke(
    ): Resource<List<WelcomeResponse>>

}