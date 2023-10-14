package com.github.fajaragungpramana.ex.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.github.fajaragungpramana.ex.widget.style.Black100
import com.github.fajaragungpramana.ex.widget.style.Gray10
import com.github.fajaragungpramana.ex.widget.style.Green100
import com.github.fajaragungpramana.ex.widget.style.Green50
import com.github.fajaragungpramana.ex.widget.style.Typography
import com.github.fajaragungpramana.ex.widget.style.White100

private val DarkColorScheme = darkColorScheme(
    primary = Green100,
    secondary = Green50,
    tertiary = Green100,
    background = Black100,
    surface = Black100,
    onPrimary = Black100,
    onSecondary = Black100,
    onTertiary = Black100,
    onBackground = Black100,
    onSurface = Black100
)

private val LightColorScheme = lightColorScheme(
    primary = Green100,
    secondary = Green50,
    tertiary = Green100,
    background = Gray10,
    surface = Gray10,
    onPrimary = White100,
    onSecondary = White100,
    onTertiary = White100,
    onBackground = Gray10,
    onSurface = Gray10
)

@Composable
fun ExTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}