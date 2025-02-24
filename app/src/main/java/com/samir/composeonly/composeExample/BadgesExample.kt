package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BadgeExample() {
    var itemCount by remember { mutableIntStateOf(0) }

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(24.dp).fillMaxWidth()
    ) {

        BadgedBox(badge = {
            if (itemCount > 0) {
                Badge(containerColor = Color.Red, contentColor = Color.White, modifier = Modifier.size(24.dp)) {
                    Text("$itemCount", fontSize = 14.sp)
                }
            }
        }) {
            Icon(
                imageVector = Icons.Default.ShoppingCart,
                contentDescription = "",
                Modifier.size(60.dp)
            )
        }

        Button(onClick = { itemCount++ }) { Text("Add Item") }
        Button(onClick = { itemCount-- }) { Text("Remove Item") }
    }

}