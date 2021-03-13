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
package com.example.androiddevchallenge.ui.home

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.body
import com.example.androiddevchallenge.model.favorite_collections
import com.example.androiddevchallenge.model.mind
import com.example.androiddevchallenge.ui.component.BottomBar
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.theme.MyTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /*TODO*/ },
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            Icon(
                                imageVector = Icons.Default.PlayArrow,
                                contentDescription = "play icon"
                            )
                        }
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                    isFloatingActionButtonDocked = true,
                    bottomBar = {
                        BottomBar()
                    }
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    var searchValue by remember { mutableStateOf("") }

    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(top = 56.dp, bottom = 70.dp) /* TODO */
                .verticalScroll(scrollState)
        ) {
            MySootheTextField(
                label = stringResource(id = R.string.search),
                value = searchValue,
                onValueChange = { searchValue = it },
                /*leadingIcon = Icon(
                        painterResource(id = R.drawable.ic_search),
                    contentDescription = "search icon"
                )*/
            )
            CardItems(
                title = stringResource(id = R.string.favorite_collections),
                items = favorite_collections
            )
            CircleItems(
                title = stringResource(id = R.string.align_your_body),
                items = body
            )
            CircleItems(
                title = stringResource(id = R.string.align_your_mind),
                items = mind
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomeScreen()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScreen()
    }
}
