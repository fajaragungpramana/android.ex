package com.github.fajaragungpramana.ex.ui.auth.signin

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

object SignInView {

    @Composable
    fun ContentView(navController: NavController?) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

        }
    }

}

@Preview(showBackground = true)
@Composable
fun SignIn_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            SignInView.ContentView(
                navController = null
            )

        }

    }
}