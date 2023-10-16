package com.github.fajaragungpramana.ex.ui.auth.signup

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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.github.fajaragungpramana.ex.R
import com.github.fajaragungpramana.ex.ui.theme.ExTheme
import com.github.fajaragungpramana.ex.widget.component.LargeTopAppBarComponent
import com.github.fajaragungpramana.ex.widget.component.OutlinedTextFieldComponent
import com.github.fajaragungpramana.ex.widget.style.Green100

object SignUpView {

    @Composable
    fun ContentView(navController: NavController?) {
        val viewModel: SignUpViewModel = hiltViewModel()

        Scaffold(
            topBar = {

                LargeTopAppBarComponent.WithSubtitle(
                    title = stringResource(id = R.string.sign_up),
                    subtitle = stringResource(id = R.string.sign_up_description),
                    onClickBackListener = { isEnable ->
                        if (isEnable) navController?.navigateUp()

                        true
                    }
                )

            }
        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp)
                    .fillMaxSize()
            ) {
                val nameField = remember { mutableStateOf(TextFieldValue()) }
                val emailField = remember { mutableStateOf(TextFieldValue()) }
                val passwordField = remember { mutableStateOf(TextFieldValue()) }
                val passwordConfirmationField = remember { mutableStateOf(TextFieldValue()) }

                OutlinedTextFieldComponent.Basic(
                    modifier = Modifier
                        .fillMaxWidth(),
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

                OutlinedTextFieldComponent.Basic(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    label = stringResource(id = R.string.password),
                    value = passwordField,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                OutlinedTextFieldComponent.Basic(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    label = stringResource(id = R.string.confirm_password),
                    value = passwordConfirmationField,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

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
                        text = stringResource(id = R.string.sign_up),
                        style = MaterialTheme.typography.titleMedium
                    )

                }

                TextButton(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(alignment = Alignment.CenterHorizontally),
                    onClick = {
                        navController?.navigateUp()
                    }) {

                    Text(
                        text = stringResource(id = R.string.already_have_an_account),
                        style = MaterialTheme.typography.bodySmall
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp),
                        text = stringResource(id = R.string.sign_in),
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
fun SignUp_Preview() {
    ExTheme {

        Surface(
            modifier = Modifier
                .systemBarsPadding()
                .fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            SignUpView.ContentView(
                navController = null
            )

        }

    }
}