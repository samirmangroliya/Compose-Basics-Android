package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.samir.composeonly.navigation.getPhotosList

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        content = {
            items(getPhotosList().filterIndexed { index, it -> index > 5 }) { photo ->
                LoadImage(photo, true)
            }
        }
    )
}

@Composable
fun LazyHorizontalGridExample() {
    LazyHorizontalGrid(rows = GridCells.Fixed(5),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        content = {
            items(getPhotosList().filterIndexed { index, it -> index > 5 }) { photo ->
                LoadImage(photo)
            }
        })
}