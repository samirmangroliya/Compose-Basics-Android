package com.samir.composeonly.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.samir.composeonly.composeExample.FlowRowSimpleUsageExample
import com.samir.composeonly.composeExample.HorizontalPagerExample
import com.samir.composeonly.composeExample.ShowDatePicker

@Composable
fun DetailsScreen(navController: NavController, index: Int?, onClickItem: (Int) -> Unit) {

    when (index) {
        0 -> {
            HorizontalPagerExample()
        }

        1 -> {
            FlowRowSimpleUsageExample()
        }

        2 -> {
            ShowDatePicker()
        }

        3 -> {
            HorizontalPagerExample()
        }

        4 -> {
            HorizontalPagerExample()
        }
    }


}
