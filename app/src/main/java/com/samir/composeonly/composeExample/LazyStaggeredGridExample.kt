package com.samir.composeonly.composeExample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.SubcomposeAsyncImage
import com.samir.composeonly.navigation.getPhotosList

@Composable
fun LazyStaggeredVerticalGridExample() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(getPhotosList()) { photo ->
                LoadImage(photo)
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    )
}

@Composable
fun LoadImage(model: String, modifier: Modifier = Modifier) {
    SubcomposeAsyncImage(
        modifier = modifier.fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
        model = model,
        loading = {
            Box(modifier = Modifier.size(150.dp)) {
                CircularProgressIndicator(modifier = Modifier.requiredSize(40.dp).align(Alignment.Center))
            }
        },
        contentDescription = null,
    )
}

@Composable
fun LazyStaggeredHorizontalGridExample() {
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Adaptive(minSize = 140.dp),
        content = {
            items(getPhotosList()) { photo ->
                LoadImage(photo, modifier = Modifier.padding(4.dp))
            }
        },
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp)
    )
}