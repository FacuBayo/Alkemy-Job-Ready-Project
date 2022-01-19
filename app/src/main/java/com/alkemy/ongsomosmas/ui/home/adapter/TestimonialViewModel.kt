package com.alkemy.ongsomosmas.ui.home.adapter

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import com.alkemy.ongsomosmas.data.testimonials.TestimonialRepositoryImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestimonialViewModel @ViewModelInject constructor(private val testimonialRepositoryImp: TestimonialRepositoryImp) :
    ViewModel() {
    private val _testimonialsViewState = MutableLiveData<TestimonialState>()
    val testimonialsViewState: LiveData<TestimonialState> = _testimonialsViewState


    fun getTestimonials(){
        viewModelScope.launch(Dispatchers.Main) {
            val result = withContext(Dispatchers.IO) {
                testimonialRepositoryImp.getTestimonials()
            }
            when(result.status){
                Resource.Status.SUCCESS -> {
                    _testimonialsViewState.value = TestimonialState.Loading(false)
                    _testimonialsViewState.value = result.data?.let { TestimonialState.Success(it) }
                }
                Resource.Status.ERROR -> {
                    _testimonialsViewState.value = TestimonialState.Loading(false)
                    _testimonialsViewState.value = TestimonialState.Error
                }
                Resource.Status.LOADING -> {
                    _testimonialsViewState.value = TestimonialState.Loading(true)
                }
            }
        }
    }

}

sealed class TestimonialState{
    data class Success(val listTestimonial: List<TestimonialResponse>) : TestimonialState()
    object Error : TestimonialState()
    data class Loading(val isLoading: Boolean) : TestimonialState()
}
