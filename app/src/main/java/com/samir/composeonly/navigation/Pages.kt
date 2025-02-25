package com.samir.composeonly.navigation

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import com.samir.composeonly.composeExample.BadgeExample
import com.samir.composeonly.composeExample.BottomSheetExample
import com.samir.composeonly.composeExample.ButtonExample
import com.samir.composeonly.composeExample.CardExample
import com.samir.composeonly.composeExample.CheckboxParentExample
import com.samir.composeonly.composeExample.ChipFlatRowExample
import com.samir.composeonly.composeExample.ShowDatePicker
import com.samir.composeonly.navigation.Screen.Main

fun getPages(): List<String> {
    return listOf(
        "Badge Example",
        "Bottom Sheet Example",
        "Button Example",
        "Card Example",
        "CheckBox Example",
        "Chip Flat Row Example",
        "Show Date Picker",
        "Horizontal Pager Example",
    )
}

fun getTopAppBarTitle(routeName: String?, bundle: Bundle?): String {
    Log.d("Test", routeName.toString())
    if (routeName == Main.route) {
        return "Compose Example List"
    } else if (routeName == Screen.Details.route + "/{${Screen.Details.args}}") {
        bundle?.apply {
            if (containsKey(Screen.Details.args)) {
                return getPages()[bundle.getInt(Screen.Details.args)]
            }
        }
    }
    return ""
}

@Composable
fun DetailsScreen(index: Int?) {

    when (index) {
        0 -> {
            BadgeExample()
        }

        1 -> {
            BottomSheetExample()
        }

        2 -> {
            ButtonExample()
        }

        3 -> {
            CardExample()
        }

        4 -> {
            CheckboxParentExample()
        }

        5 -> {
            ChipFlatRowExample()
        }

        6 -> {
            ShowDatePicker()
        }
        /*
                3 -> {
                    FlowRowSimpleUsageExample()
                }

                4 -> {
                    ShowDatePicker()
                }

                5 -> {
                    HorizontalPagerExample()
                }*/
    }


}