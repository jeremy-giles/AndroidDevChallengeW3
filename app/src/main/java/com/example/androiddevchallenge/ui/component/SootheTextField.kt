/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun MySootheTextField(
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    TextField(
        placeholder = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(placeholder, style = MaterialTheme.typography.body1)
            }
        },
        value = value,
        onValueChange = onValueChange,
        textStyle = MaterialTheme.typography.body1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = MaterialTheme.colors.onSurface,
            backgroundColor = MaterialTheme.colors.surface,
            unfocusedIndicatorColor = MaterialTheme.colors.primary
        ),
        visualTransformation = visualTransformation,
        leadingIcon = leadingIcon,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    )
}

@Preview("MySootheTextField Light Theme")
@Composable
fun MySootheTextFieldLightPreview() {
    MyTheme {
        MySootheTextField(
            placeholder = stringResource(id = R.string.email_label),
            value = "",
            onValueChange = {},
        )
    }
}

@Preview("MySootheTextField Dark Theme")
@Composable
fun MySootheTextFieldBarDarkPreview() {
    MyTheme(darkTheme = true) {
        MySootheTextField(
            placeholder = stringResource(id = R.string.email_label),
            value = "",
            onValueChange = {},
        )
    }
}

@Preview("MySootheTextField Light Theme", group = "Leading Icon")
@Composable
fun MySootheTextFieldWithIconLightPreview() {
    MyTheme {
        MySootheTextField(
            placeholder = stringResource(id = R.string.search),
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon"
                )
            }
        )
    }
}

@Preview("MySootheTextField Dark Theme", group = "Leading Icon")
@Composable
fun MySootheTextFieldWithIconDarkPreview() {
    MyTheme(darkTheme = true) {
        MySootheTextField(
            placeholder = stringResource(id = R.string.search),
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon"
                )
            }
        )
    }
}
