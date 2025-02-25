package com.samir.composeonly.composeExample

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ChipFlatRowExample(
) {

    var selectedFilter by remember { mutableStateOf(false) }
    var selectedInput by remember { mutableStateOf(false) }

    FlowRow(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {

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

        FilterChip(selectedFilter, onClick = {
            selectedFilter = !selectedFilter
        }, label = { Text("Selected Chip") }, trailingIcon = {
            if (selectedFilter) {
                Icon(
                    Icons.Filled.Done,
                    contentDescription = "done",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        })

        InputChip(
            selectedInput,
            onClick = { selectedInput = !selectedInput },
            label = { Text("Input") },
            avatar = {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Person",
                    modifier = Modifier.size(
                        InputChipDefaults.AvatarSize
                    )
                )
            },  trailingIcon = {
                Icon(
                    Icons.Default.Close,
                    contentDescription = "Close",
                    Modifier.size(InputChipDefaults.AvatarSize)
                )
            })


        SuggestionChip(
            onClick = { Log.d("Chip", "Suggestion Chip Clicked") },
            label = { Text("Suggestion chip") }
        )
    }
}