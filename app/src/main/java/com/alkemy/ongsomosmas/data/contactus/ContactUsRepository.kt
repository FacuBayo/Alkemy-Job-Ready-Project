package com.alkemy.ongsomosmas.data.contactus

import com.alkemy.ongsomosmas.data.model.Contact
import javax.inject.Inject

class ContactUsRepository @Inject constructor(private val contactUsDataSource: ContactUsDataSource) {
    suspend fun contact(
        id: Int,
        name: String,
        email: String,
        phone: String,
        message: String,
        deletedAt: String,
        createdAt: String,
        updatedAt: String
    ) = contactUsDataSource.contact(
        Contact(
            id,
            name,
            email,
            phone,
            message,
            deletedAt,
            createdAt,
            updatedAt)) }