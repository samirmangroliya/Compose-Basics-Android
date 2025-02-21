package com.samir.composeonly.composeExample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun HorizontalPagerExample() {
    val pagerState = rememberPagerState(pageCount = { 10 })
    // scroll to page
    val coroutineScope = rememberCoroutineScope()

    HorizontalPager(state = pagerState) { page ->
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            val color = getColor(page)
            Text(
                "Page:  $page",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .height(200.dp)
                    .clip(shape = RoundedCornerShape(24.dp))
                    .background(color)
                    .wrapContentHeight(align = Alignment.CenterVertically),
                textAlign = TextAlign.Center
            )
        }
    }

    Row(modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(2.dp), horizontalArrangement = Arrangement.Center) {
        repeat(pagerState.pageCount) { iteration ->

            val color = if(pagerState.currentPage == iteration) {
                Color.DarkGray
            } else {Color.LightGray}

            Box(modifier = Modifier.padding(2.dp).clip(CircleShape).background(color).size(10.dp)){

            }
        }
    }

    Row(modifier = Modifier.padding(0.dp, 10.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {

        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
                val currPage = pagerState.currentPage
                if(currPage == 0) return@launch
                pagerState.animateScrollToPage(currPage-1)
            }
        }) {
            Text("<")
        }

        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
                pagerState.animateScrollToPage(0)
            }
        }) {
            Text("|<")
        }
        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
                pagerState.animateScrollToPage(9)
            }
        }) {
            Text(">|")
        }

        Button(onClick = {
            coroutineScope.launch {
                // Call scroll to on pagerState
                val currPage = pagerState.currentPage
                pagerState.animateScrollToPage(currPage+1)
            }
        }) {
            Text(">")
        }
    }
}

fun getColor(page:Int): Color {
    return when(page) {
        1->Color.Green
        2->Color.Red
        3->Color.Blue
        4->Color.Magenta
        5->Color.LightGray
        6->Color.Black
        7->Color.Cyan
        8->Color.Gray
        else -> Color.DarkGray
    }
}