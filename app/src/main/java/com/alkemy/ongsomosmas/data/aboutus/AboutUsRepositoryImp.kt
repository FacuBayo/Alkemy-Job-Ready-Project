package com.alkemy.ongsomosmas.data.aboutus

import javax.inject.Inject

class AboutUsRepositoryImp @Inject constructor(private val aboutUsDataSource: AboutUsDataSource) :
    AboutUsRepository {
    override suspend fun getMembers() =
        aboutUsDataSource.getMembers()

}