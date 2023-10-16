package com.github.fajaragungpramana.ex

sealed class MainViewRoute(val route: String) {
    data object LoadingView : MainViewRoute(route = "loading")
    data object SignInView : MainViewRoute(route = "signIn")
    data object SignUpView : MainViewRoute(route = "signUp")
}