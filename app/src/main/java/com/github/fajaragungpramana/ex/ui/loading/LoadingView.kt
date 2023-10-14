package com.github.fajaragungpramana.ex.ui.loading

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.BuildConfig
import com.github.fajaragungpramana.ex.R
import com.github.fajaragungpramana.ex.ui.theme.ExTheme
import com.github.fajaragungpramana.ex.widget.style.Black50
import com.github.fajaragungpramana.ex.widget.style.Gray50
import com.github.fajaragungpramana.ex.widget.style.Green100

object LoadingView {

    @Composable
    fun ContentView(navController: NavController?) {
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
                fontSize = 40.sp,
                color = Green100
            )

            Text(
                text = stringResource(id = R.string.manage_your_expense),
                fontSize = 14.sp,
                color = Black50
            )

            Spacer(
                modifier = Modifier
                    .weight(1F)
            )

            Text(
                text = stringResource(id = R.string.version_app, BuildConfig.VERSION_NAME),
                fontSize = 14.sp,
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

            LoadingView.ContentView(navController = null)

        }

    }
}
