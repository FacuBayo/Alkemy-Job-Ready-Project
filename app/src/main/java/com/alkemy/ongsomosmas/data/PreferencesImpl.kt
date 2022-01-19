package com.alkemy.ongsomosmas.data

import android.content.Context

class PreferencesImpl(val context: Context) : Preferences {

    private val storage = context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    override fun saveUserToken(token: String) {
        storage.edit().putString(KEY_USER_TOKEN, token).apply()
    }

    override fun getUserToken(): String {
        return storage.getString(KEY_USER_TOKEN, "") ?: ""
    }

    override fun clear() {
        storage.edit().clear().apply()
    }

    companion object {
        private const val KEY_USER_TOKEN = "user_token"
        private const val PREFERENCES = "com.alkemy.ongsomosmas_app"
    }
}