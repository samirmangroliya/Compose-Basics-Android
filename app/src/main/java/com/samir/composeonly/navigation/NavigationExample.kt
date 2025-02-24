package com.samir.composeonly.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavigationController(
    innerPadding: PaddingValues,
    canGoBack: MutableState<Boolean>,
    navController: NavHostController,
    title: MutableState<String>
) {

    DisposableEffect(navController) {
        val listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            canGoBack.value = controller.previousBackStackEntry != null
            title.value = getTopAppBarTitle(destination.route, arguments)
        }
        navController.addOnDestinationChangedListener(listener)
        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }

    NavHost(navController = navController, startDestination = Screen.Main.route, enterTransition = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
        )
    }, exitTransition = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
        )
    }, popEnterTransition = {
        slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.End, tween(500)
        )
    }, popExitTransition = {
        slideOutOfContainer(
            AnimatedContentTransitionScope.SlideDirection.End, tween(500)
        )
    }, modifier = Modifier.padding(innerPadding)
    ) {
        composable(route = Screen.Main.route) {
            MainScreen { index ->
                navController.navigate(Screen.Details.withArgs(index))
            }
        }

        composable(
            route = Screen.Details.route + "/{${Screen.Details.args}}",
            arguments = listOf(navArgument(Screen.Details.args) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val index = navBackStackEntry.arguments?.getInt(Screen.Details.args)
            DetailsScreen(index)
        }
    }
}
