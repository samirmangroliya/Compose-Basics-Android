package com.samir.composeonly.composeExample

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowSimpleUsageExample() {

    var selected = remember { mutableStateOf(false) }

    FlowRow(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {

        AssistChip(
            onClick = { Log.d("Assist chip", "hello world") },
            label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Localized description",
                    Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )

        FilterChip(false, onClick = {
            selected.value = !selected.value
        }, label = { Text("Selected Chip") }, trailingIcon = {
            if (selected.value) {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "done",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        })
    }
}