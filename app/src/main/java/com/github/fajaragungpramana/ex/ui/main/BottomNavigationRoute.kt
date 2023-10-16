package com.github.fajaragungpramana.ex.ui.main

sealed class BottomNavigationRoute(val route: String) {
    data object HomeView : BottomNavigationRoute(route = "homeView")
    data object StatisticView : BottomNavigationRoute(route = "statisticView")
    data object ProfileView : BottomNavigationRoute(route = "profileView")
}