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
package com.example.androiddevchallenge.ui.component.item

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Item
import com.example.androiddevchallenge.ui.component.HorizontalScrollableGrid
import java.util.Locale

enum class ItemType {
    Card, Circle
}

@Composable
fun HorizontalScrollItems(type: ItemType, title: String, items: List<Item>, rowCount: Int = 1) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            // Bug if padding before paddingFromBaseline?
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(start = 16.dp),
            text = title.toUpperCase(Locale.ROOT),
            style = MaterialTheme.typography.h2,
        )
        HorizontalScrollableGrid(
            items = items,
            rowCount = rowCount,
            itemContent = { item ->
                when (type) {
                    ItemType.Card -> CardItem(item = item)
                    ItemType.Circle -> CircleItem(item = item)
                }
            }
        )
    }
}
