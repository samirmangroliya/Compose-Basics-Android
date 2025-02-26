package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samir.composeonly.navigation.getPhotosList

@Composable
fun LazyVerticalGridExample() {
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        content = {
            items(getPhotosList().filterIndexed { index, it -> index > 5 }) { photo ->
                LoadImage(photo, modifier = Modifier.padding(4.dp))
            }
        })
}

@Composable
fun LazyHorizontalGridExample() {
    LazyHorizontalGrid(rows = GridCells.Fixed(5),
        content = {
            items(getPhotosList().filterIndexed { index, it -> index > 5 }) { photo ->
                LoadImage(photo, modifier = Modifier.padding(4.dp))
            }
        })
}