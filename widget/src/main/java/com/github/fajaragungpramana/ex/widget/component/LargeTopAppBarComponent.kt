package com.github.fajaragungpramana.ex.widget.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object LargeTopAppBarComponent {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    inline fun WithSubtitle(
        title: String,
        subtitle: String,
        crossinline onClickBackListener: (Boolean) -> Boolean = { true }
    ) {

        LargeTopAppBar(
            title = {
                Column {

                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.bodyMedium
                    )

                }
            },
            navigationIcon = {
                if (onClickBackListener(false)) {
                    IconButton(onClick = {
                        onClickBackListener(true)
                    }) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                }
            }
        )

    }

}