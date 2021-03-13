package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Item
import com.example.androiddevchallenge.ui.component.HorizontalScrollableGrid
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

@Composable
fun CardItems(title: String, items: List<Item>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp),
            text = title.toUpperCase(Locale.ROOT),
            style = MaterialTheme.typography.h2,
        )
        Spacer(modifier = Modifier.height(8.dp))
        HorizontalScrollableGrid(
            items = items,
            rowCount = 2,
            itemContent = { item -> CardItem(item) }
        )
    }
}

@Composable
fun CardItem(item: Item) {
    Surface(
        modifier = Modifier
            .size(192.dp, 56.dp)
            .clip(MaterialTheme.shapes.small)
            .clickable { /* TODO */ }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            CoilImage(
                data = item.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = "item image",
                modifier = Modifier
                    .width(56.dp)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = item.title,
                style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp)
            )
        }
    }
}