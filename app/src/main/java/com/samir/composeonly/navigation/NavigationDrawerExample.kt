package com.samir.composeonly.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun NavigationDrawerExample(
    innerPadding: PaddingValues,
    drawerState: DrawerState
) {

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {  },
        modifier = TODO(),
        gesturesEnabled = true,
        scrimColor = Color.Blue,
    ) { }

}
