package com.alkemy.ongsomosmas.data.contactus

import com.alkemy.ongsomosmas.data.BaseDataSource
import com.alkemy.ongsomosmas.data.model.Contact
import javax.inject.Inject

class ContactUsDataSource @Inject constructor(private val contactUsService: ContactUsService) :
    BaseDataSource() {
    suspend fun contact(contact: Contact) = getResult { contactUsService.contact(contact) }
}