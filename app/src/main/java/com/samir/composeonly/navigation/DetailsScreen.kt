package com.samir.composeonly.navigation

import androidx.compose.runtime.Composable
import com.samir.composeonly.composeExample.BadgeExample
import com.samir.composeonly.composeExample.FlowRowSimpleUsageExample
import com.samir.composeonly.composeExample.HorizontalPagerExample
import com.samir.composeonly.composeExample.ShowDatePicker

@Composable
fun DetailsScreen(index: Int?) {

    when (index) {
        0 -> {
            BadgeExample()
        }

        1 -> {
            HorizontalPagerExample()
        }

        2 -> {
            FlowRowSimpleUsageExample()
        }

        3 -> {
            ShowDatePicker()
        }

        4 -> {
            HorizontalPagerExample()
        }

        5 -> {
            HorizontalPagerExample()
        }
    }


}
