package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Item
import com.example.androiddevchallenge.ui.component.HorizontalScrollableGrid
import dev.chrisbanes.accompanist.coil.CoilImage
import java.util.*

@Composable
fun CircleItems(title: String, items: List<Item>) {
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
            rowCount = 1,
            itemContent = { item -> CircleItem(item) }
        )
    }
}

@Composable
fun CircleItem(item: Item) {
    Column(
        modifier = Modifier.width(88.dp)
    ) {
        CoilImage(
            data = item.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = "item image",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(CircleShape)
                .clickable { /* */ }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.title,
            style = MaterialTheme.typography.h3,
            textAlign = TextAlign.Center,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .paddingFromBaseline(top = 24.dp)
        )
    }
}