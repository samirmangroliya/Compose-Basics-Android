package com.samir.composeonly.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController

@Composable
fun ToolBarActions(
    canGoBack: MutableState<Boolean>,
    navController: NavHostController,
    menuExpanded: MutableState<Boolean>
) {
    if (!canGoBack.value) {
        IconButton(onClick = { menuExpanded.value = true }) {
            Icon(
                imageVector = Icons.Filled.MoreVert, contentDescription = "More Menu"
            )
        }

        DropdownMenu(expanded = menuExpanded.value,
            onDismissRequest = { menuExpanded.value = false }) {
            DropdownMenuItem(text = { Text("About") }, trailingIcon = {
                Icon(
                    Icons.Default.Info, contentDescription = null
                )
            }, onClick = {
                menuExpanded.value = false
                navController.navigate(Screen.AboutUs.route)
            })
            DropdownMenuItem(text = { Text("Help") }, trailingIcon = {
                Icon(
                    Icons.Default.Build, contentDescription = null
                )
            }, onClick = {
                menuExpanded.value = false
                navController.navigate(Screen.ContactUs.route)
            })
        }
    }
}