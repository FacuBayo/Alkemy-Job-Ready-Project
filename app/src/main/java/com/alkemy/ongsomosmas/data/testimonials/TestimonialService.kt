package com.alkemy.ongsomosmas.data.testimonials

import com.alkemy.ongsomosmas.data.model.ApiResponse
import com.alkemy.ongsomosmas.data.model.TestimonialResponse
import retrofit2.Response
import retrofit2.http.GET

interface TestimonialService {
    @GET("/api/testimonials")
    suspend fun getTestimonials(): Response<ApiResponse<List<TestimonialResponse>>>
}