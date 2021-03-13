package com.example.androiddevchallenge.ui.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.component.MySootheButton
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(loginAction: () -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(
                id = if (isSystemInDarkTheme()) {
                    R.drawable.dark_welcome
                } else {
                    R.drawable.light_welcome
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
            Image(
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) {
                        R.drawable.dark_logo
                    } else {
                        R.drawable.light_logo
                    }
                ),
                contentDescription = "logo",
            )
            Spacer(modifier = Modifier.height(32.dp))
            MySootheButton(
                label = stringResource(id = R.string.sign_up),
                backgroundColor = MaterialTheme.colors.primary,
                onClick = { /* TODO */ }
            )
            Spacer(modifier = Modifier.height(8.dp))
            MySootheButton(
                label = stringResource(id = R.string.log_in),
                backgroundColor = MaterialTheme.colors.secondary,
                onClick = loginAction
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        WelcomeScreen {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        WelcomeScreen {}
    }
}