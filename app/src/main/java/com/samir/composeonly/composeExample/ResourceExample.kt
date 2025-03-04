package com.samir.composeonly.composeExample

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.samir.composeonly.R

@Composable
fun ResourceExample() {
    val smallPadding = dimensionResource(R.dimen.padding_small)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(smallPadding)
            .selectableGroup(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(smallPadding)
        )

        HorizontalDivider(color = colorResource(R.color.teal_700))

        Icon(
            painter = painterResource(id = R.drawable.user_avatar),
            modifier = Modifier.size(100.dp).padding(top = 16.dp),
            contentDescription = ""
        )
    }
}