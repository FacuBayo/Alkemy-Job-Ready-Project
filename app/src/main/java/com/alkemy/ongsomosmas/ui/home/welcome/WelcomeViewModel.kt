package com.alkemy.ongsomosmas.ui.home.welcome

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.home.welcome.WelcomeRepository
import com.alkemy.ongsomosmas.data.model.WelcomeResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WelcomeViewModel @ViewModelInject constructor(
    private val welcomeRepository: WelcomeUseCase
    ):
    ViewModel() {

    private val _welcomeResponse = MutableLiveData<Resource<List<WelcomeResponse>>>()
    val welcomeResponse: LiveData<Resource<List<WelcomeResponse>>> = _welcomeResponse

    fun welcomeSlide() = viewModelScope.launch(Dispatchers.Main) {
        val result = withContext(Dispatchers.IO) {
            welcomeRepository()
        }
        _welcomeResponse.value = result
    }

}