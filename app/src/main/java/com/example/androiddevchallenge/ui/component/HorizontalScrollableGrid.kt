package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.util.*
import kotlin.math.min

@Composable
fun <T> HorizontalScrollableGrid(
    rowCount: Int = 1,
    items: List<T>,
    itemContent: @Composable (T) -> Unit,
) {
    val horizontalPadding = 16.dp
    val contentPadding = 8.dp
    val scrollState = rememberScrollState()

    Column {
        val itemsPerColumn = if (rowCount == 1) {
            items.size
        } else {
            items.size / rowCount
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(scrollState)
        ) {
            for (rowIndex in 0 until rowCount) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = contentPadding)
                ) {
                    val startIndex = rowIndex * itemsPerColumn
                    val endIndex = min(items.size, startIndex + itemsPerColumn) - 1

                    for (itemIndex in startIndex..endIndex) {
                        val item = items[itemIndex]

                        Spacer(
                            modifier = Modifier.width(
                                if (itemIndex == startIndex) {
                                    horizontalPadding
                                } else {
                                    contentPadding
                                }
                            )
                        )

                        itemContent(item)

                        if (itemIndex == endIndex) {
                            Spacer(modifier = Modifier.width(horizontalPadding))
                        }
                    }
                }
            }
        }
    }
}