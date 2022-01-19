package com.alkemy.ongsomosmas.data

import java.text.SimpleDateFormat
import java.util.*

fun String.parseToDate(format: String? = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"): Date? {
    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
    simpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
    return simpleDateFormat.parse(this)
}

fun Date.getTimeFormatted(format: String): String {
    val simpleDateFormat = SimpleDateFormat(format, Locale.getDefault())
    return simpleDateFormat.format(this)
}