package com.alkemy.ongsomosmas.data.model.signup

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("role_id") val roleId: Int,
    @SerializedName("updated_at") val updatedAt: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("id") val id: Int,
)


