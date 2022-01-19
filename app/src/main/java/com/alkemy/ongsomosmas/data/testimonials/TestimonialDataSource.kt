package com.alkemy.ongsomosmas.data.testimonials

import com.alkemy.ongsomosmas.data.BaseDataSource
import javax.inject.Inject

class TestimonialDataSource @Inject constructor(private val testimonialService: TestimonialService) : BaseDataSource() {

    suspend fun getTestimonials() =
        getResult { testimonialService.getTestimonials() }
}