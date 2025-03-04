package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.samir.composeonly.extensionfunction.showToast
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackBarExample() {
    val scope = rememberCoroutineScope()
    val snackBarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text(text = "Show SnackBar") },
                icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = "") },
                onClick = {
                    scope.launch {
                        val result = snackBarHostState.showSnackbar(
                            message = "SnackBar",
                            actionLabel = "Action",
                            withDismissAction = true,
                            duration = SnackbarDuration.Indefinite
                        )
                        when (result) {
                            SnackbarResult.Dismissed -> {
                                context.showToast("Dismissed")
                            }

                            SnackbarResult.ActionPerformed -> {
                                context.showToast("ActionPerformed")
                            }
                        }
                    }
                }

            )
        }
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) { }
    }
}
