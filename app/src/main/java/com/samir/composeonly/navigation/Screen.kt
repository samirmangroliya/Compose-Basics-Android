package com.samir.composeonly.navigation

sealed class Screen(val route:String) {
    object Main: Screen("main_screen")
    object Details: Screen("details_screen")
}