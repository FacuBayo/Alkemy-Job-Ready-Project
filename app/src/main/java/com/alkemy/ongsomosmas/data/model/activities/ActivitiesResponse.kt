package com.alkemy.ongsomosmas.data.model.activities


import com.google.gson.annotations.SerializedName

data class ActivitiesResponse(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("name")
    val name: String = "",

    @SerializedName("slug")
    val slug: String = "",

    @SerializedName("description")
    val description: String = "",

    @SerializedName("image")
    val image: String = "",

    @SerializedName("user_id")
    val userId: Int = 0,

    @SerializedName("category_id")
    val categoryId: Int = 0,

    @SerializedName("created_at")
    val createdAt: String = "",
    @SerializedName("updated_at")
    val updatedAt: String = "",

    @SerializedName("deleted_at")
    val deletedAt: String = "",

    @SerializedName("group_id")
    val groupId: Int = 0
)
