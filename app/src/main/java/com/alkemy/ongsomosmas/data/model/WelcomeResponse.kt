package com.alkemy.ongsomosmas.data.model

import com.google.gson.annotations.SerializedName

data class WelcomeResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("description") val content: String?,
    @SerializedName("image") val image: String?
)