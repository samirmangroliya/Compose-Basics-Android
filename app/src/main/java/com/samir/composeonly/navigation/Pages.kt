package com.samir.composeonly.navigation

import android.os.Bundle
import android.util.Log
import androidx.compose.runtime.Composable
import com.samir.composeonly.composeExample.AlertDialogExample
import com.samir.composeonly.composeExample.BadgeExample
import com.samir.composeonly.composeExample.BottomSheetExample
import com.samir.composeonly.composeExample.ButtonExample
import com.samir.composeonly.composeExample.CardExample
import com.samir.composeonly.composeExample.CheckboxParentExample
import com.samir.composeonly.composeExample.ChipFlatRowExample
import com.samir.composeonly.composeExample.DividerExample
import com.samir.composeonly.composeExample.FloatingActionButtonExample
import com.samir.composeonly.composeExample.HorizontalPagerExample
import com.samir.composeonly.composeExample.LazyHorizontalGridExample
import com.samir.composeonly.composeExample.LazyListExample
import com.samir.composeonly.composeExample.LazyStaggeredHorizontalGridExample
import com.samir.composeonly.composeExample.LazyStaggeredVerticalGridExample
import com.samir.composeonly.composeExample.LazyVerticalGridExample
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
        "Dialog Example",
        "Divider Example",
        "Floating Action Button Example",
        "Horizontal Pager Example",
        "Lazy List Example",
        "Lazy Vertical Grid Example",
        "Lazy Horizontal Grid Example",
        "Lazy Vertical Staggered Grid Example",
        "Lazy Horizontal Staggered Grid Example",
    )
}

fun getPhotosList(): Array<String> {
    return (arrayOf(
        "https://picsum.photos/200/300",
        "https://picsum.photos/200",
        "https://picsum.photos/id/237/200/300",
        "https://picsum.photos/seed/picsum/200/300",
        "https://picsum.photos/id/0/5000/3333",
        "https://picsum.photos/id/1/5000/3333",
        "https://picsum.photos/id/2/5000/3333",
        "https://picsum.photos/id/3/5000/3333",
        "https://picsum.photos/id/4/5000/3333",
        "https://picsum.photos/id/5/5000/3333",
        "https://picsum.photos/id/7/4728/3168",
        "https://picsum.photos/id/8/5000/3333",
        "https://picsum.photos/id/11/2500/1667",
        "https://picsum.photos/id/12/2500/1667",
        "https://picsum.photos/id/13/2500/1667",
        "https://picsum.photos/id/14/2500/1667",
        "https://picsum.photos/id/15/2500/1667",
        "https://picsum.photos/id/16/2500/1667",
        "https://picsum.photos/id/17/2500/1667",
        "https://picsum.photos/id/18/2500/1667",
        "https://picsum.photos/id/19/2500/1667"
    ))
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

        7 -> {
            AlertDialogExample()
        }

        8 -> {
            DividerExample()
        }

        9 -> {
            FloatingActionButtonExample()
        }

        10 -> {
            HorizontalPagerExample()
        }

        11 -> {
            LazyListExample()
        }

        12 -> {
            LazyVerticalGridExample()
        }

        13 -> {
            LazyHorizontalGridExample()
        }

        14 -> {
            LazyStaggeredVerticalGridExample()
        }

        15 -> {
            LazyStaggeredHorizontalGridExample()
        }
    }
}