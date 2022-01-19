package com.alkemy.ongsomosmas.ui.activities

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.activities.ActivitiesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ActivitiesViewModel @ViewModelInject constructor(private val getActivitiesUC: GetActivitiesUseCase) : ViewModel(){

    private val _activitiesViewState = MutableLiveData<ActivitiesState>()
    val activitiesViewState: LiveData<ActivitiesState> = _activitiesViewState

    fun getActivities(){
        viewModelScope.launch(Dispatchers.Main){
            val result = withContext(Dispatchers.IO){
                getActivitiesUC()
            }

            when(result.status){
                Resource.Status.SUCCESS -> {
                    _activitiesViewState.value = ActivitiesState.ShowLoading(false)
                    _activitiesViewState.value = result.data?.let{ActivitiesState.ShowActivitiesList(it)}
                }
                Resource.Status.ERROR -> {
                    _activitiesViewState.value = ActivitiesState.ShowLoading(false)
                    _activitiesViewState.value = ActivitiesState.ShowError
                }
                Resource.Status.LOADING -> {
                    _activitiesViewState.value = ActivitiesState.ShowLoading(true)
                }
            }



        }
    }
}

sealed class ActivitiesState{
    data class ShowActivitiesList(val listActivities: List<ActivitiesResponse>) : ActivitiesState()
    object ShowError  : ActivitiesState()
    data class ShowLoading(val isLoading: Boolean) : ActivitiesState()
}


