package com.samir.composeonly.composeExample

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSample() {

    var searchQuery by remember { mutableStateOf("") }

    val items =
        listOf(
            "Gujarat",
            "Maharashtra",
            "Delhi",
            "Punjab",
            "Haryana",
            "Rajasthan",
            "Madhya Pradesh",
            "Uttar Pradesh",
            "Assam",
            "Bihar"
        )

    var active by remember { mutableStateOf(false) }

    val filteredItems = items.filter { it.contains(searchQuery, ignoreCase = true) }

    SearchBar(
        query = searchQuery,
        onQueryChange = { searchQuery = it },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Search") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        },
        trailingIcon = {
            if (active)
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = null,
                    modifier = Modifier.clickable(onClick = {
                        active = false
                        searchQuery = ""
                    })
                )
        },
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        )
    ) {
        filteredItems.forEach { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text(
                    text = item,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }

}
