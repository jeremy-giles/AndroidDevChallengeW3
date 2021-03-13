package com.example.androiddevchallenge.ui.component

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySootheTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: Icon? = null
) {
    TextField(
        label = {
            Text(label, style = MaterialTheme.typography.body1)
        },
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.surface,
            unfocusedIndicatorColor = MaterialTheme.colors.primary
        ),
        keyboardOptions = keyboardOptions,
        leadingIcon = { leadingIcon },
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    )
}