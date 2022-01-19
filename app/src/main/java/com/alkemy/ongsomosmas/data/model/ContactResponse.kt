package com.alkemy.ongsomosmas.data.model

import com.google.gson.annotations.SerializedName

data class ContactResponse(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("id") val id: Int
)