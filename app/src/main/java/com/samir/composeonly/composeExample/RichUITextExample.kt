package com.samir.composeonly.composeExample


import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withLink
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RichUITextExample() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .selectableGroup()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        val intent = remember { Intent() }
        val uriHandler = LocalUriHandler.current


        val annotatedString = buildAnnotatedString {
            append("By  Continuing you are agree with ")

            withLink(
                link = LinkAnnotation.Clickable(
                    "terms", styles = TextLinkStyles(
                        style = SpanStyle(
                            Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ),
                    linkInteractionListener = {
                        uriHandler.openUri("https://developer.android.com/safety".toUri().toString())
                    })
            ) { append("Terms & Conditions") }

            append(" and ")

            withLink(
                link = LinkAnnotation.Clickable(
                    "privacy", styles = TextLinkStyles(
                        style = SpanStyle(
                            Color.Blue,
                            textDecoration = TextDecoration.Underline
                        )
                    ),
                    linkInteractionListener = {
                        intent.action = Intent.ACTION_VIEW
                        intent.data = "https://developer.android.com/privacy".toUri()
                        context.startActivity(intent)
                    })
            ) { append("Privacy Policy") }

        }
        Text(text = annotatedString)

        HorizontalDivider(Modifier.height(100.dp), thickness = 0.dp)
        val annotatedWebString = buildAnnotatedString {
            withLink(
                link = LinkAnnotation.Url(
                    url = "https://www.google.com",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            color = Color.Red,
                            textDecoration = TextDecoration.Underline
                        )
                    )
                )
            ) {
                append("Open Google")
            }
        }



        Text(text = annotatedWebString)

    }
}