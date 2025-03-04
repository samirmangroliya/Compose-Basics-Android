package com.samir.composeonly.navigation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.samir.composeonly.R
import kotlinx.coroutines.launch

@Composable
fun NavigationDrawerExample(
    innerPadding: PaddingValues,
    drawerState: DrawerState,
    canGoBack: MutableState<Boolean>,
    navController: NavHostController,
    title: MutableState<String>
) {
    val scope = rememberCoroutineScope()
    var lastSelected by remember { mutableIntStateOf(1) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawer(Modifier.padding(innerPadding), lastSelected) { index ->
                lastSelected = index
                scope.launch {
                    if (drawerState.isClosed) {
                        drawerState.open()
                    } else {
                        drawerState.close()
                    }
                }
                navDrawerNavigation(navController, index)
            }
        },
        modifier = Modifier,
        gesturesEnabled = true,
        scrimColor = Color.Blue,
        content = {
            NavigationController(innerPadding, canGoBack, navController, title)
        }
    )
}

@Composable
fun ModalDrawer(modifier: Modifier, lastSelected: Int, onClickCloseMenu: (Int) -> Unit) {
    ModalDrawerSheet {
        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.LightGray)
                    .fillMaxWidth()
                    .clickable(onClick = { onClickCloseMenu(5) })
                    .padding(12.dp)
            ) {
                Image(
                    modifier = Modifier.size(100.dp),
                    painter = painterResource(R.drawable.user_avatar),
                    contentDescription = "User image"
                )

                Text(
                    text = "User Name",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
            }

            HorizontalDivider(Modifier.padding(vertical = 12.dp))

            Text(
                "Section 1",
                modifier = Modifier.padding(horizontal = 16.dp),
                style = MaterialTheme.typography.titleMedium
            )

            NavigationDrawerItem(
                label = { Text("Home") },
                icon = { Icon(Icons.Default.Settings, contentDescription = "") },
                selected = lastSelected == 1,
                onClick = { onClickCloseMenu(1) })
            NavigationDrawerItem(
                label = { Text("About") },
                icon = { Icon(Icons.Default.Person, contentDescription = "") },
                selected = lastSelected == 2,
                onClick = { onClickCloseMenu(2) })

            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

            Text(
                "Section 2",
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleMedium
            )
            NavigationDrawerItem(
                label = { Text("Settings") },
                icon = { Icon(Icons.Default.Settings, contentDescription = "") },
                selected = lastSelected == 3,
                badge = { Text("16") },
                onClick = { onClickCloseMenu(3) })
            NavigationDrawerItem(
                label = { Text("Contact Us") },
                icon = { Icon(Icons.Default.MailOutline, contentDescription = "") },
                selected = lastSelected == 4,
                onClick = { onClickCloseMenu(4) })

            VerticalDivider()
        }
    }
}