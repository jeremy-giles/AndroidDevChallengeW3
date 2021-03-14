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
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheButton
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.home.HomeActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

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
                    text = stringResource(id = R.string.log_in).toUpperCase(Locale.ROOT),
                    style = MaterialTheme.typography.h1.copy(
                        color = MaterialTheme.colors.onBackground
                    ),
                    modifier = Modifier.paddingFromBaseline(bottom = 32.dp)
                )
                MySootheTextField(
                    placeholder = stringResource(id = R.string.email_label),
                    value = emailValue,
                    onValueChange = { emailValue = it }
                )
                Spacer(Modifier.height(8.dp))
                MySootheTextField(
                    placeholder = stringResource(id = R.string.password_label),
                    value = passwordValue,
                    onValueChange = { passwordValue = it },
                    visualTransformation = PasswordVisualTransformation()
                )
                Spacer(Modifier.height(8.dp))
                MySootheButton(
                    label = stringResource(id = R.string.log_in),
                    backgroundColor = MaterialTheme.colors.primary,
                    onClick = {
                        context.startActivity(Intent(context, HomeActivity::class.java))
                    }
                )
                SignUp { value ->
                    Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

@Composable
fun SignUp(
    onClick: (value: String) -> Unit
) {
    val signUpTag = "SIGN_UP"

    val annotatedString = buildAnnotatedString {
        append(stringResource(id = R.string.account_question))
        append(" ")

        // Attach URL annotation to the following content
        // until 'pop()' is called
        pushStringAnnotation(tag = signUpTag, annotation = "Sign up action")
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(stringResource(id = R.string.sign_up).capitalize(Locale.ROOT))
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        style = MaterialTheme.typography.body1.copy(
            color = MaterialTheme.colors.onBackground
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 32.dp),
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = signUpTag,
                start = offset, end = offset
            )
                .firstOrNull()?.let { annotation ->
                    onClick(annotation.item)
                }
        }
    )
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
