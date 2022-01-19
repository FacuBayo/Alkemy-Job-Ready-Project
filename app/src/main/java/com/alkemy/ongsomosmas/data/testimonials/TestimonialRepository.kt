package com.alkemy.ongsomosmas.data.testimonials

import com.alkemy.ongsomosmas.data.Resource
import com.alkemy.ongsomosmas.data.model.TestimonialResponse

interface TestimonialRepository {
    suspend fun getTestimonials(): Resource<List<TestimonialResponse>>
}