package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.samir.composeonly.extensionfunction.showToast

@Composable
fun ButtonExample() {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Button(onClick = {}) {
            Text("Filled Button")
        }

        FilledTonalButton(onClick = { }) {
            Text("Tonal")
        }

        OutlinedButton(onClick = { context.showToast("Outlined Button Clicked") }) {
            Text("Outlined")
        }

        ElevatedButton(onClick = { context.showToast("Elevated Button Clicked") }) {
            Text("Elevated")
        }

        TextButton(onClick = { context.showToast("Text Button Clicked") }) {
            Text("Text Button")
        }
    }

}