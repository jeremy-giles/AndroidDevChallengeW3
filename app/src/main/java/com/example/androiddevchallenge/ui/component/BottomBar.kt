package com.example.androiddevchallenge.ui.component

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.androiddevchallenge.R
import java.util.*

data class NavItem(val icon: ImageVector, val title: String)

@Composable
fun BottomBar() {
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
                    Icon(item.icon, contentDescription = item.title)
                },
                label = {
                    Text(text = item.title.toUpperCase(Locale.ROOT), style = MaterialTheme.typography.caption)
                },
                onClick = { /*TODO*/ },
            )
        }
    }
}