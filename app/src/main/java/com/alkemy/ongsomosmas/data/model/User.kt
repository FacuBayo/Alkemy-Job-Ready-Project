package com.alkemy.ongsomosmas.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class User(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)

data class Login(
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String
)

data class Contact(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("message") val message: String,
    @SerializedName("Deleted_at") val deletedAt: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("update_at") val updateAt: String
)

