package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SliderExample() {
    var sliderPosition by remember { mutableFloatStateOf(1f) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            valueRange = 1f..100f,
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            )
        )
        HorizontalDivider(Modifier.padding(top = 20.dp))
        Text(text = "$sliderPosition", Modifier.padding(top = 20.dp))

        HorizontalDivider(
            Modifier
                .padding(top = 20.dp)
                .height(60.dp)
        )

        var sliderPosition by remember { mutableStateOf(1f..100f) }
        RangeSlider(value = sliderPosition,
            steps = 10,
            valueRange = 1f..100f,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {
            },
            startThumb = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "") },
            endThumb = { Icon(imageVector = Icons.Default.Favorite, contentDescription = "") })
        HorizontalDivider(Modifier.padding(top = 20.dp))
        Text(text = "$sliderPosition", Modifier.padding(top = 20.dp))

    }
}
