package com.github.fajaragungpramana.ex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.fajaragungpramana.ex.ui.loading.LoadingView
import com.github.fajaragungpramana.ex.ui.theme.ExTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            ExTheme {

                Surface(
                    modifier = Modifier
                        .systemBarsPadding()
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = MainViewRoute.LoadingView.route
                    ) {

                        composable(MainViewRoute.LoadingView.route) {
                            LoadingView.ContentView(
                                navController = navController
                            )
                        }

                    }

                }

            }

        }
    }

}