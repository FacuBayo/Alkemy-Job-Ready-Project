package com.alkemy.ongsomosmas.data.model

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("content") val content: String?,
    @SerializedName("image") val image: String?,
    @SerializedName("created_at") val createdAt: String?
)

