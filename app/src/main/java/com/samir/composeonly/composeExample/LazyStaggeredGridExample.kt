package com.samir.composeonly.composeExample

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.samir.composeonly.R
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
fun LoadImage(model: String, isShimmer: Boolean = false) {
    SubcomposeAsyncImage(
        modifier = Modifier
            .fillMaxWidth(),
        contentScale = ContentScale.FillWidth,
        model = model,
        loading = {
            Box(modifier = Modifier.size(150.dp)) {
                if (isShimmer) {
                    ShimmerEffect(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(150.dp)
                            .background(Color.LightGray)
                    )
                } else {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .requiredSize(40.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        },
        error = {
            Box(modifier = Modifier.size(150.dp)) {
                Image(
                    painter = painterResource(R.drawable.image_loading_failed),
                    modifier = Modifier.size(150.dp),
                    contentDescription = ""
                )
            }
        },
        contentDescription = "Async Imagḛ",
    )

}

@Composable
fun LazyStaggeredHorizontalGridExample() {
    LazyHorizontalStaggeredGrid(
        rows = StaggeredGridCells.Adaptive(minSize = 140.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalItemSpacing = 5.dp,
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
fun ShimmerEffect(
    modifier: Modifier,
    widthOfShadowBrush: Int = 500,
    angleOfAxisY: Float = 90f,
    durationMillis: Int = 1200,
) {

    val shimmerColors = listOf(
        Color.White.copy(alpha = 0.3f),
        Color.White.copy(alpha = 0.5f),
        Color.White.copy(alpha = 0.5f),
        Color.White.copy(alpha = 0.3f),
    )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
        end = Offset(x = translateAnimation.value, y = angleOfAxisY),
    )

    Box(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(brush)
        )
    }


}