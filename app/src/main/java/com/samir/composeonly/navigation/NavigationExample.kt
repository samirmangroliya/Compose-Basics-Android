package com.samir.composeonly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavigationExample(innerPadding: PaddingValues) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Main.route,
        modifier = Modifier.safeDrawingPadding()
    ) {
        composable(route = Screen.Main.route) {
            MainScreen(navController = navController) { index ->
                navController.navigate(Screen.Details.route + "/$index")
            }
        }

        composable(route = Screen.Details.route + "/{index}",
            arguments = listOf(navArgument("index") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->

            val index = navBackStackEntry.arguments?.getInt("index")
            print("test $index")
            DetailsScreen(navController = navController, index) {

            }
        }
    }

}
