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
package com.example.androiddevchallenge.ui.login

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheButton
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.home.HomeActivity
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun LoginScreen() {
    val context = LocalContext.current

    MyTheme {
        var emailValue by remember { mutableStateOf("") }
        var passwordValue by rememberSaveable { mutableStateOf("") }

        Surface(color = MaterialTheme.colors.background) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.dark_login
                    } else {
                        R.drawable.light_login
                    }
                ),
                contentScale = ContentScale.Crop,
                contentDescription = "welcome background",
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = stringResource(id = R.string.log_in).toUpperCase(),
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier.paddingFromBaseline(bottom = 32.dp)
                )
                MySootheTextField(
                    label = "Email address",
                    value = emailValue,
                    onValueChange = { emailValue = it }
                )
                Spacer(Modifier.height(8.dp))
                MySootheTextField(
                    label = "Password",
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    )
                )
                Spacer(Modifier.height(8.dp))
                MySootheButton(
                    label = stringResource(id = R.string.log_in),
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    }
                )
                Text(
                    buildAnnotatedString {
                        append("Don\'t have an account?")
                        withStyle(
                            style = SpanStyle(
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append(" ")
                            append("Sign up")
                        }
                    },
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.paddingFromBaseline(top = 32.dp)
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        LoginScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        LoginScreen()
    }
}
