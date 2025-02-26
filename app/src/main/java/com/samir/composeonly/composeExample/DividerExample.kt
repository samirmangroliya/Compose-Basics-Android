package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DividerExample() {
    Column {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text("First Item")
            HorizontalDivider(thickness = 2.dp, color = Color.LightGray)
            Text("Second Item")
        }

        HorizontalDivider(modifier = Modifier.height(24.dp), color = Color.Transparent)

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("First Item")
            VerticalDivider(
                thickness = 5.dp,
                color = Color.LightGray,
                modifier = Modifier.height(30.dp)
            )
            Text("Second Item")
        }
    }

}