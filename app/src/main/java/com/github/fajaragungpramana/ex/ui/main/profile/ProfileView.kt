package com.github.fajaragungpramana.ex.ui.main.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.R
import com.github.fajaragungpramana.ex.ui.theme.ExTheme
import com.github.fajaragungpramana.ex.widget.component.OutlinedTextFieldComponent
import com.github.fajaragungpramana.ex.widget.style.Gray50
import com.github.fajaragungpramana.ex.widget.style.Red100
import com.github.fajaragungpramana.ex.widget.style.Red50

object ProfileView {

    @Composable
    fun ContentView(navController: NavController?) {
        val nameField = remember { mutableStateOf(TextFieldValue()) }
        val emailField = remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxSize()
        ) {

            Box(
                modifier = Modifier
                    .padding(top = 32.dp)
                    .size(80.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(
                        Gray50,
                        shape = CircleShape
                    )
            ) {

                Text(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center),
                    text = "FP",
                    style = MaterialTheme.typography.headlineLarge
                )

                IconButton(
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.BottomEnd),
                    onClick = {

                    }) {

                    Icon(
                        painter = painterResource(id = R.drawable.ic_camera_circle_green),
                        contentDescription = stringResource(id = R.string.camera),
                        tint = Color.Unspecified
                    )

                }

            }

            OutlinedTextFieldComponent.Basic(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                label = stringResource(id = R.string.full_name),
                value = nameField,
                singleLine = true
            )

            OutlinedTextFieldComponent.Basic(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                label = stringResource(id = R.string.email),
                value = emailField,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(
                modifier = Modifier
                    .weight(1F)
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                onClick = {

                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Red50
                ),
                shape = RoundedCornerShape(10.dp)
            ) {

                Text(
                    text = stringResource(id = R.string.sign_out),
                    style = MaterialTheme.typography.titleMedium,
                    color = Red100
                )

            }

        }

    }

}

@Preview(showBackground = true)
@Composable
fun Profile_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            ProfileView.ContentView(
                navController = null
            )

        }

    }
}