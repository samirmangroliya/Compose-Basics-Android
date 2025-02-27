package com.samir.composeonly.composeExample

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyListAnimationExample() {
    var data = remember { mutableStateListOf<String>() }
    val canAddItem = data.size < 10
    val canRemoveItem = data.isNotEmpty()

    Column(modifier = Modifier.fillMaxSize()) {
        AddRemoveButton(canAddItem, canRemoveItem, {
            data.add(
                if (data.size % 2 == 0) {
                    "Even Number ${data.size}"
                } else {
                    "Odd Number ${data.size}"
                }
            )
        }, {
            data.removeAt(data.size - 1)
        })

        OrderButtons(
            {
                data.sortBy { it.filter { it.isDigit() }.toInt() }
            },
            { data.sortBy { it } },
            { data.sortBy { it.length } })

        ListAnimatedItem(data)
    }


}

@Composable
fun AddRemoveButton(
    canAddItem: Boolean,
    canRemoveItem: Boolean,
    addItem: () -> Unit,
    removeItem: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        Button(onClick = { addItem() }, enabled = canAddItem) { Text("Add Item") }
        Button(onClick = { removeItem() }, enabled = canRemoveItem) { Text("Remove Item") }
    }
}

@Composable
private fun OrderButtons(
    resetOrder: () -> Unit,
    orderAlphabetically: () -> Unit,
    orderByLength: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        var selectedIndex by remember { mutableIntStateOf(0) }
        val options = listOf("Reset", "Alphabetical", "Length")

        SingleChoiceSegmentedButtonRow {
            options.forEachIndexed { index, label ->
                SegmentedButton(
                    shape = SegmentedButtonDefaults.itemShape(
                        index = index,
                        count = options.size
                    ),
                    onClick = {
                        if (selectedIndex == index) return@SegmentedButton
                        Log.d("AnimatedOrderedList", "selectedIndex: $selectedIndex")
                        selectedIndex = index
                        when (options[selectedIndex]) {
                            "Reset" -> resetOrder()
                            "Alphabetical" -> orderAlphabetically()
                            "Length" -> orderByLength()
                        }
                    },
                    selected = index == selectedIndex
                ) {
                    Text(label)
                }
            }
        }
    }
}

@Composable
fun ListAnimatedItem(items: List<String>) {
    LazyColumn {
        items(items = items, key = { it }) {
            ListItem(
                modifier = Modifier
                    .animateItem()
                    .fillParentMaxWidth()
                    .padding(8.dp, 8.dp)
                    .clip(RoundedCornerShape(12.dp)),
                headlineContent = { Text(it) },
                colors = ListItemDefaults.colors(containerColor = Color.LightGray),
                shadowElevation = ListItemDefaults.Elevation.plus(4.dp)
            )
        }
    }
}