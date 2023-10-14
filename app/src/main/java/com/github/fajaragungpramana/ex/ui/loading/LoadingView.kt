package com.github.fajaragungpramana.ex.ui.loading

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.BuildConfig
import com.github.fajaragungpramana.ex.MainViewRoute
import com.github.fajaragungpramana.ex.R
import com.github.fajaragungpramana.ex.ui.theme.ExTheme
import com.github.fajaragungpramana.ex.widget.style.Gray50
import com.github.fajaragungpramana.ex.widget.style.Green100

object LoadingView {

    private const val LOADING_TIME = 2000L
    
    @Composable
    fun ContentView(navController: NavController?) {
        LaunchedEffect(Unit) {
            Handler(Looper.getMainLooper()).postDelayed({
                navController?.navigate(MainViewRoute.SignInView.route)
            }, LOADING_TIME)
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(
                modifier = Modifier
                    .weight(1F)
            )

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineLarge,
                color = Green100
            )

            Text(
                text = stringResource(id = R.string.manage_your_expense),
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(
                modifier = Modifier
                    .weight(1F)
            )

            Text(
                text = stringResource(id = R.string.version_app, BuildConfig.VERSION_NAME),
                style = MaterialTheme.typography.bodyMedium,
                color = Gray50
            )

        }
    }

}

@Preview(showBackground = true)
@Composable
fun Loading_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            LoadingView.ContentView(
                navController = null
            )

        }

    }
}
