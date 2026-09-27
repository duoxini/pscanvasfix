package com.color.pscanvasfix.ui

import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = Color(0xFF145AC7),
    onPrimary = Color.White,
    primaryContainer = Color(0xFFD9E2FF),
    onPrimaryContainer = Color(0xFF001A42),
    secondary = Color(0xFF007C91),
    onSecondary = Color.White,
    secondaryContainer = Color(0xFFB8EAFA),
    onSecondaryContainer = Color(0xFF001F26),
    tertiary = Color(0xFF6850C7),
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFE7DEFF),
    onTertiaryContainer = Color(0xFF21005D),
    background = Color(0xFFF9F9FF),
    surface = Color(0xFFF9F9FF),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFFB1C5FF),
    onPrimary = Color(0xFF002D6B),
    primaryContainer = Color(0xFF00429A),
    onPrimaryContainer = Color(0xFFD9E2FF),
    secondary = Color(0xFF87D1E6),
    onSecondary = Color(0xFF003640),
    secondaryContainer = Color(0xFF004E5D),
    onSecondaryContainer = Color(0xFFB8EAFA),
    tertiary = Color(0xFFCBBEFF),
    onTertiary = Color(0xFF39227E),
    tertiaryContainer = Color(0xFF503895),
    onTertiaryContainer = Color(0xFFE7DEFF),
    background = Color(0xFF11131A),
    surface = Color(0xFF11131A),
)

@Composable
fun PsCanvasClassicTheme(
    darkTheme: Boolean = false,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val colors = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColors
        else -> LightColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
    )
}
