package com.github.fajaragungpramana.ex.widget.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

object LargeTopAppBarComponent {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun WithSubtitle(title: String, subtitle: String) {

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
            }
        )

    }

}