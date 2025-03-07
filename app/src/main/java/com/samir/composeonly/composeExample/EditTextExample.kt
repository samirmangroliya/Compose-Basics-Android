package com.samir.composeonly.composeExample

import android.app.Activity
import android.util.Patterns
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samir.composeonly.extensionfunction.showToast

@Composable
fun EditTextExample() {
    val activity = LocalActivity.current
    val focusManager = LocalFocusManager.current
    var emailValue = remember { mutableStateOf("") }
    val emailError = remember { mutableStateOf("") }

    var passwordValue = remember { mutableStateOf("") }
    val passwordError = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldValidation(
            value = emailValue.value,
            onChange = {
                emailValue.value = it
                validateEmail(emailValue, emailError)
            },
            placeholder = "Email",
            isError = emailError.value.isNotBlank(),
            icon = Icons.Rounded.Email,
            errorMessage = emailError.value,
            keyboardType = KeyboardType.Email,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldValidation(
            value = passwordValue.value,
            onChange = {
                passwordValue.value = it
                validatePassword(passwordValue, passwordError)
            },
            placeholder = "Password",
            isError = passwordError.value.isNotBlank(),
            icon = Icons.Filled.Password,
            isPassword = true,
            errorMessage = passwordError.value,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
                focusManager.clearFocus()
                validateForm(emailValue, emailError, passwordValue, passwordError, activity)
            },
            modifier = Modifier.padding(horizontal = 2.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
        ) {
            Text(
                text = "Validate",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White
            )
        }
    }
}

@Composable
fun TextFieldValidation(
    value: String,
    placeholder: String,
    onChange: (String) -> Unit,
    isError: Boolean,
    icon: ImageVector,
    errorMessage: String,
    isPassword: Boolean = false,
    imeAction: ImeAction = ImeAction.Next,
    keyboardType: KeyboardType = KeyboardType.Text,
    modifier: Modifier = Modifier
) {

    var showPassword by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.fillMaxWidth(),
    ) {
        OutlinedTextField(value = value, onValueChange = {
            if (!it.contains("\n")) onChange(it)
        }, placeholder = {
            Text(text = placeholder)
        }, singleLine = true, textStyle = MaterialTheme.typography.bodyMedium, leadingIcon = {
            Icon(
                icon,
                contentDescription = "Text FieldInput",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }, trailingIcon = {
            if (isPassword) {
                Icon(
                    imageVector = if (!showPassword) {
                        Icons.Filled.Visibility
                    } else Icons.Filled.VisibilityOff,
                    contentDescription = if (showPassword) "Show Password" else "Hide Password",
                    tint = Color.Gray,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { showPassword = !showPassword })
            } else {
                null
            }
        }, modifier = Modifier.fillMaxWidth(), keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType, imeAction = imeAction
        ), colors = OutlinedTextFieldDefaults.colors(
            unfocusedTextColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            focusedTextColor = Color.Blue,
            focusedBorderColor = Color.Blue,
            errorBorderColor = Color.Red,
        ), shape = RoundedCornerShape(10.dp), visualTransformation = if (isPassword) {
            if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }, isError = isError
        )
        if (isError) {
            Text(
                text = errorMessage,
                style = MaterialTheme.typography.labelSmall,
                color = Color.Red,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 2.dp, vertical = 4.dp),
                textAlign = TextAlign.Start
            )
        }
    }
}

fun validateForm(
    emailValue: MutableState<String>,
    emailError: MutableState<String>,
    passwordValue: MutableState<String>,
    passwordError: MutableState<String>,
    activity: Activity?
) {
    val isValidEmail = validateEmail(emailValue, emailError)
    val isValidPassword = validatePassword(passwordValue, passwordError)


    if (isValidEmail && isValidPassword) {
        activity?.apply { showToast("Email and Password Validation Done!!!") }
    }
}

fun validateEmail(
    emailValue: MutableState<String>,
    emailError: MutableState<String>
): Boolean {
    if (emailValue.value.isNotBlank() == true && Patterns.EMAIL_ADDRESS.matcher(emailValue.value)
            .matches()
    ) {
        emailError.value = ""
        return true
    } else if (emailValue.value.isBlank()) {
        emailError.value =
            "Please Enter Email"
    } else {
        emailError.value = "Please Enter Valid Email"
    }
    return false
}

fun validatePassword(
    passwordValue: MutableState<String>,
    passwordError: MutableState<String>
): Boolean {
    if (passwordValue.value.length > 6 && passwordValue.value.any { it.isDigit() } && passwordValue.value.any { it.isUpperCase() }) {
        passwordError.value = ""
        return true
    } else if (passwordValue.value.isBlank()) {
        passwordError.value =
            "Please Enter Password"
    } else {
        passwordError.value =
            "Please Enter Valid Password. ( 6 chars long, One Number and One Capital letter)"
    }
    return false
}