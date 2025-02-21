package com.samir.composeonly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.samir.composeonly.composeExample.FlowRowSimpleUsageExample
import com.samir.composeonly.composeExample.HorizontalPagerExample
import com.samir.composeonly.ui.theme.ComposeAndroidOnlyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAndroidOnlyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Greeting() {

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top, modifier = Modifier.safeDrawingPadding().fillMaxSize()) {
        HorizontalPagerExample()
        FlowRowSimpleUsageExample()
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAndroidOnlyTheme {
        Greeting()
    }
}

