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

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.util.Locale

data class NavItem(val icon: ImageVector, val title: String)

@Composable
fun SootheBottomBar() {
    val items = listOf(
        NavItem(Icons.Default.Spa, stringResource(id = R.string.home)),
        NavItem(Icons.Default.AccountCircle, stringResource(id = R.string.profile))
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        elevation = dimensionResource(id = R.dimen.bottom_navigation_elevation)
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                selected = index % 2 == 0,
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.title,
                        modifier = Modifier.size(18.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title.toUpperCase(Locale.ROOT),
                        style = MaterialTheme.typography.caption,
                        color = MaterialTheme.colors.onBackground
                    )
                },
                onClick = { /* TODO */ },
            )
        }
    }
}

@Preview("SootheBottomBar Light Theme")
@Composable
fun SootheBottomBarLightPreview() {
    MyTheme {
        SootheBottomBar()
    }
}

@Preview("SootheBottomBar Dark Theme")
@Composable
fun SootheBottomBarDarkPreview() {
    MyTheme(darkTheme = true) {
        SootheBottomBar()
    }
}
