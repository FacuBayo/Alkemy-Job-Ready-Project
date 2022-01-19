package com.alkemy.ongsomosmas.data

interface Preferences {

    fun saveUserToken(token: String)

    fun getUserToken(): String

    fun clear()
}