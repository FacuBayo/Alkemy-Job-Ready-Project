package com.alkemy.ongsomosmas.data.testimonials

import javax.inject.Inject

class TestimonialRepositoryImp @Inject constructor(private val testimonialDataSource: TestimonialDataSource): TestimonialRepository {
    override suspend fun getTestimonials() =
        testimonialDataSource.getTestimonials()
}