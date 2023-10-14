package com.github.fajaragungpramana.ex

sealed class MainViewRoute(val route: String) {
    data object LoadingView : MainViewRoute(route = "loading")
}