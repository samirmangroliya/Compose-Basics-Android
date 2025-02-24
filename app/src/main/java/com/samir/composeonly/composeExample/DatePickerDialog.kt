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
import androidx.compose.ui.platform.LocalContext
import com.samir.composeonly.extensionfunction.millisecondsToDate
import com.samir.composeonly.extensionfunction.showToast

@Composable
fun ShowDatePicker() {
    val selectedDate = remember { mutableStateOf("Select Date") }
    val showDatePicker = remember { mutableStateOf(false) }


    if (showDatePicker.value) {
        DatePickerModalExample({ date ->
            selectedDate.value = "Select Date:: ${date?.millisecondsToDate("dd-MM-yyyy")}"
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

    val context = LocalContext.current
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                if (datePickerState.selectedDateMillis == null) {
                    context.showToast("Please Select Date")
                } else {
                    onDateSelected(datePickerState.selectedDateMillis)
                    onDismiss()
                }
            }) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(onClick = {
                onDismiss()
            }) { Text("Cancel") }
        }) {

        DatePicker(state = datePickerState)
    }
}

