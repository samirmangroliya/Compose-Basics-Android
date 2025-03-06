package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

enum class Page(val title:String, val content: String){
    HOME("home","Show Home Content Here"),
    SEARCH("Search","Show search content here"),
    SETTINGS("Settings","Show Settings content here")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationRailExample() {

        var selectedItem by remember { mutableIntStateOf(0) }
        val pages = Page.entries
        val icons = listOf(Icons.Filled.Home, Icons.Filled.Search, Icons.Filled.Settings)

    Row {
        NavigationRail {
            pages.forEachIndexed { index, item ->
                when(item){
                    Page.HOME -> {
                        NavigationRailItem(
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                    Page.SEARCH -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index }
                        )
                    }
                    Page.SETTINGS -> {
                        NavigationRailItem(
                            label = { Text(item.title) },
                            icon = { Icon(icons[index], contentDescription = "") },
                            selected = selectedItem == index,
                            onClick = { selectedItem = index },
                            alwaysShowLabel = false
                        )
                    }
                }
            }
        }

        Text(pages[selectedItem].content, Modifier.padding(start = 8.dp))
    }
}
