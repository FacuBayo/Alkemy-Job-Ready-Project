package com.alkemy.ongsomosmas.data.aboutus

import com.alkemy.ongsomosmas.data.BaseDataSource
import javax.inject.Inject

class AboutUsDataSource @Inject constructor(private val aboutUsService: AboutUsService) :
    BaseDataSource() {
    suspend fun getMembers() = getResult { aboutUsService.getMembers() }
}