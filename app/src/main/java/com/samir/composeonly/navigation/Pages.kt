package com.samir.composeonly.navigation

import android.os.Bundle
import android.util.Log
import com.samir.composeonly.navigation.Screen.Main

fun getPages(): List<String> {
    return listOf(
        "Badge Example",
        "Horizontal Pager Example",
        "FlowRow Example",
        "Show Date Picker"
    )
}

fun getTopAppBarTitle(routeName: String?, bundle: Bundle?): String {
    Log.d("Test", routeName.toString())
    if (routeName == Main.route) {
        return "Compose Example List"
    } else if (routeName == Screen.Details.route + "/{${Screen.Details.args}}") {
        bundle?.apply {
            if (containsKey(Screen.Details.args)) {
                return getPages()[bundle.getInt(Screen.Details.args)]
            }
        }
    }
    return ""
}