package com.alkemy.ongsomosmas.ui.home.welcome

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.home.welcome.WelcomeDataSource
import com.alkemy.ongsomosmas.data.home.welcome.WelcomeRepository
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import javax.inject.Inject

class WelcomeUseCaseImp(
    private val repository: WelcomeRepository
) : WelcomeUseCase {
    override suspend fun invoke(): Resource<List<WelcomeResponse>> {
        return repository.getWelcome()
    }
}
