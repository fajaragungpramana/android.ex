package com.github.fajaragungpramana.ex.ui.main.statistic

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.ui.theme.ExTheme

object StatisticView {

    @Composable
    fun ContentView(navController: NavController?) {

        Column {

        }

    }

}

@Preview(showBackground = true)
@Composable
fun Statistic_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            StatisticView.ContentView(
                navController = null
            )

        }

    }
}