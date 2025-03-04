package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.List
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MultiChoiceSegmentedButtonRow
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SegmentedButtonExample() {
    val options = listOf("Day", "Month", "Week")
    var selectedIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->

                SegmentedButton(
                    selected = index == selectedIndex,
                    onClick = { selectedIndex = index },
                    shape = SegmentedButtonDefaults.itemShape(index = index, count = options.size),
                    label = { Text(options[index]) }
                )
            }
        }


        HorizontalDivider(Modifier.height(40.dp).padding(top = 20.dp))

        val selectedOptions = remember { mutableStateListOf(false, false, false) }
        val options = listOf("Walk", "Ride", "Drive")

        MultiChoiceSegmentedButtonRow {

            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    checked = selectedOptions[index],
                    onCheckedChange = {
                        selectedOptions[index] = !selectedOptions[index]
                    },
                    icon = { SegmentedButtonDefaults.Icon(selectedOptions[index]) },
                    label = {
                        when (label) {
                            "Walk" -> Icon(
                                imageVector =
                                Icons.AutoMirrored.Rounded.List,
                                contentDescription = "Directions Walk"
                            )

                            "Ride" -> Icon(
                                imageVector =
                                Icons.Default.Build,
                                contentDescription = "Directions Bus"
                            )

                            "Drive" -> Icon(
                                imageVector =
                                Icons.Default.Person,
                                contentDescription = "Directions Car"
                            )
                        }
                    })
            }
        }
    }

}
