package com.samir.composeonly.composeExample

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samir.composeonly.extensionfunction.showToast

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnContactListExample() {
    val contacts = getContacts().sortedBy { it.firstName }
    val grouped = contacts.groupBy { it.firstName[0] }
    val context = LocalContext.current

    LazyColumn {
        grouped.forEach { (initial, contactList) ->

            stickyHeader {
                CharacterHeader(initial.toString())
            }

            items(items = contactList, key = { it.firstName }) {
                ListItem(
                    modifier = Modifier
                        .animateItem()
                        .fillParentMaxWidth()
                        .padding(0.dp, 2.dp)
                        .clickable {context.showToast("${it.firstName}  ${it.lastName}")},
                    headlineContent = { Text("${it.firstName}  ${it.lastName}") },
                    colors = ListItemDefaults.colors(containerColor = Color.White)
                )
            }

        }
    }

}

@Composable
fun CharacterHeader(name: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ) {
        Text(
            name,
            fontSize = 16.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(8.dp, 2.dp)
                .fillMaxWidth()
        )
    }
}

data class Contact(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phoneNumber: String
)

fun getContacts() = listOf<Contact>(
    Contact("A Jack", "Patel", "samir@gmail.com", "12345"),
    Contact("A Adam", "Patel", "samir@gmail.com", "12345"),
    Contact("A Samir2", "Patel", "samir@gmail.com", "12345"),
    Contact("BSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("B Samir2", "Patel", "samir@gmail.com", "12345"),
    Contact("CSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("DSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("DSamir3", "Patel", "samir@gmail.com", "12345"),
    Contact("ESamir", "Patel", "samir@gmail.com", "12345"),
    Contact("E Samir2", "Patel", "samir@gmail.com", "12345"),
    Contact("YSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("Y Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("JSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("J Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("KSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("K Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("GSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("G Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("TSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("T Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("NSamir", "Patel", "samir@gmail.com", "12345"),
    Contact("N Samir4", "Patel", "samir@gmail.com", "12345"),
    Contact("Samir", "Patel", "samir@gmail.com", "12345"),
    Contact("Samir5", "Patel", "samir@gmail.com", "12345")

)
