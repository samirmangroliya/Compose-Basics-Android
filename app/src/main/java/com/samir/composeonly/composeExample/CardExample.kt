package com.samir.composeonly.composeExample

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.samir.composeonly.R
import com.samir.composeonly.extensionfunction.showToast

@Composable
fun CardExample() {
    val context = LocalContext.current
    var selected by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Green.copy(alpha = 0.5f)
            ), modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(150.dp)
        ) {
            ElevatedButton(
                onClick = { context.showToast("Elevated Button Clicked") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Elevated")
            }
        }

        ElevatedCard(
            colors = CardDefaults.cardColors(
                containerColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(150.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
        ) {
            ElevatedButton(
                onClick = { context.showToast("Elevated Button Clicked") },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Elevated")
            }
        }

        OutlinedCard(
            colors = CardDefaults.cardColors(
                containerColor = if (selected) Color.LightGray else Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(150.dp),
            border = BorderStroke(1.dp, if (selected) Color.Green else Color.Blue)
        ) {
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = if (selected) {
                        Icons.Default.Favorite
                    } else {
                        Icons.Default.FavoriteBorder
                    },
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .clickable(onClick = { selected = !selected },
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() })
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.user_avatar),
                        contentDescription = "Profile",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(100.dp)
                            .clip(CircleShape)
                    )
                    Column(
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Test", style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Hi! My name is Samir. I'm a developer of Android apps!"
                        )
                    }
                }
            }
        }

    }
}

