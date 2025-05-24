package com.manishjajoriya.kabar.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme =
  darkColorScheme(background = Black, primary = Blue, error = DarkRed, surface = LightBlack)

private val LightColorScheme =
  lightColorScheme(
    background = Color.White,
    primary = Blue,
    error = LightRed,
    surface = Color.White,
  )

@Composable
fun KabarTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
  val colorScheme =
    when {
      darkTheme -> DarkColorScheme
      else -> LightColorScheme
    }

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
