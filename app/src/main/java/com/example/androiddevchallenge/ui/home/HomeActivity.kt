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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.body
import com.example.androiddevchallenge.model.favorite_collections
import com.example.androiddevchallenge.model.mind
import com.example.androiddevchallenge.ui.component.MySootheTextField
import com.example.androiddevchallenge.ui.component.SootheBottomBar
import com.example.androiddevchallenge.ui.component.item.HorizontalScrollItems
import com.example.androiddevchallenge.ui.component.item.ItemType
import com.example.androiddevchallenge.ui.theme.MyTheme

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                Scaffold(
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = { /* TODO */ },
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
                        SootheBottomBar()
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
                .padding(top = 56.dp /* FIXME */, bottom = 70.dp)
                .verticalScroll(scrollState)
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                MySootheTextField(
                    placeholder = stringResource(id = R.string.search),
                    value = searchValue,
                    onValueChange = { searchValue = it },
                    leadingIcon = {
                        Icon(
                            painterResource(id = R.drawable.ic_search),
                            contentDescription = "search icon"
                        )
                    }
                )
            }
            HorizontalScrollItems(
                type = ItemType.Card,
                title = stringResource(id = R.string.favorite_collections),
                items = favorite_collections,
                rowCount = 2
            )
            HorizontalScrollItems(
                type = ItemType.Circle,
                title = stringResource(id = R.string.align_your_body),
                items = body,
                rowCount = 1
            )
            HorizontalScrollItems(
                type = ItemType.Circle,
                title = stringResource(id = R.string.align_your_mind),
                items = mind,
                rowCount = 1
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
