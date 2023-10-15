package com.github.fajaragungpramana.ex.widget.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.fajaragungpramana.ex.widget.R
import com.github.fajaragungpramana.ex.widget.style.Gray50
import com.github.fajaragungpramana.ex.widget.style.Green100

object OutlinedTextFieldComponent {

    @Composable
    fun Basic(
        modifier: Modifier,
        label: String,
        value: MutableState<TextFieldValue>,
        singleLine: Boolean = false,
        keyboardOptions: KeyboardOptions = KeyboardOptions(),
        corner: Dp = 10.dp
    ) {

        val colorState = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Green100,
            unfocusedBorderColor = Gray50,
            focusedLabelColor = Green100,
            unfocusedLabelColor = Gray50
        )

        if (keyboardOptions.keyboardType == KeyboardType.Password) {

            var valueVisible by remember { mutableStateOf(false) }

            OutlinedTextField(
                modifier = modifier,
                value = value.value,
                onValueChange = {
                    value.value = it
                },
                label = {
                    Text(
                        text = label
                    )
                },
                shape = RoundedCornerShape(corner),
                colors = colorState,
                singleLine = singleLine,
                visualTransformation = if (valueVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                keyboardOptions = keyboardOptions,
                trailingIcon = {

                    IconButton(onClick = { valueVisible = !valueVisible }) {
                        Icon(
                            imageVector = if (valueVisible)
                                Icons.Filled.Visibility
                            else
                                Icons.Filled.VisibilityOff,
                            contentDescription = stringResource(
                                id = if (valueVisible)
                                    R.string.hide_password
                                else
                                    R.string.show_password
                            )
                        )
                    }

                }
            )

        } else {

            OutlinedTextField(
                modifier = modifier,
                value = value.value,
                onValueChange = {
                    value.value = it
                },
                label = {
                    Text(
                        text = label
                    )
                },
                shape = RoundedCornerShape(corner),
                colors = colorState,
                singleLine = singleLine,
                keyboardOptions = keyboardOptions
            )

        }

    }

}