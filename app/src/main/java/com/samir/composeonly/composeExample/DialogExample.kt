package com.samir.composeonly.composeExample

import android.app.Activity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogExample() {
    val context = LocalContext.current
    var showAlertDialog by remember { mutableStateOf(false) }
    if (showAlertDialog) {
        ShowAlertDialog({ showAlertDialog = false }, {
            showAlertDialog = false
            if (context is Activity) {
                context.finishAffinity()
            }
        })
    }
    Button(
        onClick = { showAlertDialog = true },
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
    ) {
        Text("Show Exit App Dialog")
    }
}

@Composable
fun ShowAlertDialog(onDismissRequest: () -> Unit, onConfirmRequest: () -> Unit) {
    AlertDialog(icon = {
        Icon(
            imageVector = Icons.AutoMirrored.Default.ExitToApp,
            contentDescription = "Exit App"
        )
    }, title = {
        Text(text = "Kill App?")
    }, text = {
        Text(text = "Are you sure you want to Kill the App?")
    }, onDismissRequest = {
        onDismissRequest()
    }, confirmButton = {
        TextButton(onClick = {
            onDismissRequest()
        }) {
            Text("No")
        }
    }, dismissButton = {
        TextButton(onClick = {
            onConfirmRequest()
        }) {
            Text("Yes")
        }
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogExample(
    onDismissRequest: () -> Unit, msg: String
) {
    Dialog(onDismissRequest = { onDismissRequest() }, properties = DialogProperties(
        dismissOnBackPress = true, dismissOnClickOutside = true, usePlatformDefaultWidth = true
    ), content = {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(msg)
                Button(onClick = { onDismissRequest() }) { Text("OK") }
            }
        }

    })

}