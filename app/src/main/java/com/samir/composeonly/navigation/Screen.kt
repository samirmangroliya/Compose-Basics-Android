package com.samir.composeonly.navigation

sealed class Screen(val route:String, val args: String= "") {
    object Main: Screen("main_screen")
    object Details: Screen("details_screen", "index")
    object Profile: Screen("profile")
    object AboutUs: Screen("about_us")
    object Setting: Screen("setting")
    object ContactUs: Screen("contact_us")

    fun <T> withArgs(vararg args: T): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}