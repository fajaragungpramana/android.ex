package com.github.fajaragungpramana.ex.ui.auth.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.R
import com.github.fajaragungpramana.ex.ui.theme.ExTheme
import com.github.fajaragungpramana.ex.widget.component.LargeTopAppBarComponent
import com.github.fajaragungpramana.ex.widget.component.OutlinedTextFieldComponent
import com.github.fajaragungpramana.ex.widget.style.Green100

object SignInView {

    @Composable
    fun ContentView(navController: NavController?) {
        Scaffold(
            topBar = {

                LargeTopAppBarComponent.WithSubtitle(
                    title = stringResource(id = R.string.sign_in),
                    subtitle = stringResource(id = R.string.sign_in_description)
                )

            }
        ) { paddingValues ->
            val emailField = remember { mutableStateOf(TextFieldValue()) }
            val passwordField = remember { mutableStateOf(TextFieldValue()) }

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {

                OutlinedTextFieldComponent.Basic(
                    modifier = Modifier
                        .fillMaxWidth(),
                    label = stringResource(id = R.string.email),
                    value = emailField,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )

                OutlinedTextFieldComponent.Basic(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    label = stringResource(id = R.string.password),
                    value = passwordField,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                TextButton(
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(top = 16.dp),
                    onClick = {


                    }) {

                    Text(
                        text = stringResource(id = R.string.forgot_password),
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 14.sp,
                        color = Green100
                    )

                }

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth(),
                    onClick = {

                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Green100
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {

                    Text(
                        text = stringResource(id = R.string.sign_in),
                        style = MaterialTheme.typography.titleMedium
                    )

                }

                TextButton(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterHorizontally),
                    onClick = {

                    }) {

                    Text(
                        text = stringResource(id = R.string.not_have_an_account),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp),
                        text = stringResource(id = R.string.sign_up),
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.SemiBold,
                        color = Green100
                    )

                }

            }

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