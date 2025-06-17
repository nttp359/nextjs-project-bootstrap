package com.example.vision4uapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF4169E1),        // Royal Blue
    onPrimary = Color.White,
    secondary = Color(0xFF6C757D),      // Gray
    tertiary = Color(0xFF0D6EFD),       // Bright Blue
    background = Color.White,
    surface = Color.White,
    error = Color(0xFFDC3545)           // Red
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4169E1),        // Royal Blue
    onPrimary = Color.White,
    secondary = Color(0xFF6C757D),      // Gray
    tertiary = Color(0xFF0D6EFD),       // Bright Blue
    background = Color(0xFF121212),
    surface = Color(0xFF121212),
    error = Color(0xFFDC3545)           // Red
)

@Composable
fun Vision4UTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
