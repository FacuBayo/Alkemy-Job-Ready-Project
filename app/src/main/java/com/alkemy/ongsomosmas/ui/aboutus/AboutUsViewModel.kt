package com.alkemy.ongsomosmas.ui.aboutus

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.MembersResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AboutUsViewModel @ViewModelInject constructor(
    private val getMembersUC: GetMembersUseCase
) :
    ViewModel() {
    private val _membersViewState = MutableLiveData<AboutUsState>()
    val membersViewState: LiveData<AboutUsState> = _membersViewState

    fun getMembers() {
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO) {
                getMembersUC()
            }.run {
                when (status) {
                    Resource.Status.SUCCESS -> {
                        _membersViewState.value = AboutUsState.Loading(false)
                        _membersViewState.value = data?.let { AboutUsState.Success(it) }
                    }
                    Resource.Status.ERROR -> {
                        _membersViewState.value = AboutUsState.Loading(false)
                        _membersViewState.value = AboutUsState.Error
                    }
                    Resource.Status.LOADING -> {
                        _membersViewState.value = AboutUsState.Loading(true)
                    }
                }
            }
        }
    }
}

sealed class AboutUsState {
    data class Success(val membersList: List<MembersResponse>) : AboutUsState()
    object Error : AboutUsState()
    data class Loading(val isLoading: Boolean) : AboutUsState()
}