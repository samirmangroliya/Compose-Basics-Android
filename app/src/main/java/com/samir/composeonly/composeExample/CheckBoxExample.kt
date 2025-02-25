package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState

@Composable
fun CheckboxParentExample() {

    val list = remember { mutableStateListOf(false, false, false, false, false, false) }
    var showDialog by remember { mutableStateOf(false) }

    val parentState = when {
        list.all { it } -> ToggleableState.On
        list.none { it } -> ToggleableState.Off
        else -> ToggleableState.Indeterminate
    }

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (list.all { it }) {
            Text("All options selected")
        } else if (list.any { it }) {
            Button(onClick = { showDialog = true }) {
                Text("Get selected options")
            }
        }
        // Parent TriStateCheckbox
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text("Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    // Determine new state based on current state
                    val newState = parentState != ToggleableState.On
                    list.forEachIndexed { index, _ ->
                        list[index] = newState
                    }
                }
            )
        }

        // Child Checkboxes
        list.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = { isChecked ->
                        list[index] = isChecked
                    }
                )
            }
        }

        if (showDialog) {
            DialogExample(
                { showDialog = false },

                list.withIndex().filter { it.value }.map { "Option ${it.index + 1}" }
                    .joinToString(",\n")
            )
        }
    }
}

