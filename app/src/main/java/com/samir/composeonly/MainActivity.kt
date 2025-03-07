package com.samir.composeonly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.compose.rememberNavController
import com.samir.composeonly.navigation.NavigationDrawerExample
import com.samir.composeonly.navigation.NavigationIcons
import com.samir.composeonly.navigation.ToolBarActions
import com.samir.composeonly.ui.theme.ComposeAndroidOnlyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAndroidOnlyTheme {
                NavigationExample()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationExample() {
    var title = remember { mutableStateOf("Compose Example List") }

    var canGoBack = remember { mutableStateOf(false) }
    val navController = rememberNavController()
    var menuExpanded = remember { mutableStateOf(false) }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)


    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        //modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = Color.White,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
                title = {
                    Text(title.value, maxLines = 1, overflow = TextOverflow.Ellipsis)
                },
                navigationIcon = {
                    NavigationIcons(canGoBack, navController, drawerState)
                },
                actions = {
                    ToolBarActions(canGoBack, navController, menuExpanded)
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        NavigationDrawerExample(innerPadding, drawerState, canGoBack, navController, title)
    }
}