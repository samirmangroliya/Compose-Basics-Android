package com.samir.composeonly.composeExample

import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun ShowDatePicker(modifier: Modifier = Modifier) {
    val selectedDate = remember { mutableStateOf("Select Date") }
    val showDatePicker = remember { mutableStateOf(false) }


    if (showDatePicker.value) {
        DatePickerModalExample({ date ->
            selectedDate.value = "Select Date:: ${convertMillisToDate(date)}"
        }, { showDatePicker.value = false })
    }
    Button(onClick = { showDatePicker.value = true }) {
        Text(selectedDate.value)
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModalExample(
    onDateSelected: (Long?) -> Unit, onDismiss: () -> Unit
) {

    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) { Text("Cancel") }
        },

        ) {

        DatePicker(state = datePickerState)
    }
}

fun convertMillisToDate(millis: Long? = 0L): String {
    val formatter = SimpleDateFormat("dd-mm-yyyy", Locale.getDefault())
    return formatter.format(millis)
}