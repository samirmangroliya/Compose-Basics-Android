package com.samir.composeonly.extensionfunction

import java.text.SimpleDateFormat
import java.util.Locale

fun Long.millisecondsToDate(dateFormat: String): String {
    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(this).toString()
}

fun String.convertDate(fromDateFormat: String, toDateFormat: String): String {
    val dateFormat = SimpleDateFormat(fromDateFormat, Locale.getDefault())
    val formattedDate = dateFormat.parse(this)
    formattedDate?.let {
        return SimpleDateFormat(toDateFormat, Locale.getDefault()).format(it)
    }
    return ""
}
