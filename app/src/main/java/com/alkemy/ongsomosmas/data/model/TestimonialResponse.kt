package com.alkemy.ongsomosmas.data.model


import com.google.gson.annotations.SerializedName

data class TestimonialResponse(
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("deleted_at")
    val deletedAt: String?,
    val description: String?,
    @SerializedName("group_id")
    val groupId: Int?,
    val id: Int,
    val image: String,
    val name: String,
    @SerializedName("updated_at")
    val updatedAt: String
)