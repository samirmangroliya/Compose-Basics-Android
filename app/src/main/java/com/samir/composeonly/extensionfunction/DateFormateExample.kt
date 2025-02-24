package com.samir.composeonly.extensionfunction

import java.text.SimpleDateFormat
import java.util.Locale

fun Long.millisecondsToDate(dateFormat: String): String {
    return SimpleDateFormat(dateFormat, Locale.getDefault()).format(this).toString()
}

