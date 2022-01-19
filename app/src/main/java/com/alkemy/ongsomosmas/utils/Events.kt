package com.alkemy.ongsomosmas.utils

import android.os.Bundle
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

fun sendLog(eventName: String, message: String) {
    val bundle = Bundle()
    bundle.putString("message", message)
    Firebase.analytics.logEvent(eventName, bundle)
}