package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.samir.composeonly.extensionfunction.showToast

@Composable
fun FloatingActionButtonExample() {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {

        SmallFloatingActionButton(
            onClick = { context.showToast("Small FAB Clicked") },
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, "Small Floating Button")
        }

        FloatingActionButton(
            onClick = { context.showToast("FAB Clicked") },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
        }

        LargeFloatingActionButton(
            onClick = { context.showToast("Large FAB Clicked") },
            shape = CircleShape, modifier = Modifier.padding(16.dp)
        ) {
            Icon(Icons.Filled.Add, "Large FAB")
        }

        ExtendedFloatingActionButton(
            onClick = { context.showToast("Extended FAB Clicked") },
            icon = { Icon(Icons.Filled.Edit, "Edit") },
            text = { Text(text = "Edit") }, modifier = Modifier.padding(16.dp)
        )
    }
}

