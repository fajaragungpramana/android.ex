package com.github.fajaragungpramana.ex.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.fajaragungpramana.ex.ui.main.home.HomeView
import com.github.fajaragungpramana.ex.ui.main.profile.ProfileView
import com.github.fajaragungpramana.ex.ui.main.statistic.StatisticView
import com.github.fajaragungpramana.ex.ui.theme.ExTheme

object MainView {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun ContentView(navController: NavController?) {
        var navigationSelectedItem by remember { mutableIntStateOf(0) }
        val bottomNavController = rememberNavController()

        val listBottomNavigationItem = BottomNavigationItem.data()

        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = stringResource(id = listBottomNavigationItem[navigationSelectedItem].label),
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                )
            },
            bottomBar = {
                NavigationBar {

                    listBottomNavigationItem.forEachIndexed { index, bottomNavigationItem ->

                        NavigationBarItem(
                            selected = index == navigationSelectedItem,
                            label = { Text(stringResource(id = bottomNavigationItem.label)) },
                            icon = {
                                Icon(
                                    painterResource(id = bottomNavigationItem.icon),
                                    contentDescription = stringResource(id = bottomNavigationItem.label)
                                )
                            },
                            onClick = {
                                navigationSelectedItem = index
                                bottomNavController.navigate(bottomNavigationItem.route.route) {
                                    popUpTo(bottomNavController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )

                    }

                }
            }
        ) { paddingValues ->

            NavHost(
                modifier = Modifier
                    .padding(paddingValues),
                navController = bottomNavController,
                startDestination = BottomNavigationRoute.HomeView.route
            ) {
                composable(BottomNavigationRoute.HomeView.route) {
                    HomeView.ContentView(
                        navController = bottomNavController
                    )
                }

                composable(BottomNavigationRoute.StatisticView.route) {
                    StatisticView.ContentView(
                        navController = bottomNavController
                    )
                }

                composable(BottomNavigationRoute.ProfileView.route) {
                    ProfileView.ContentView(
                        navController = bottomNavController
                    )
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun Main_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            MainView.ContentView(
                navController = null
            )

        }

    }
}
