package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorPalette = darkColorScheme(
  primary = ColorPrimary,
  primaryContainer = ColorPrimaryDark,
  secondary = ColorAccent
)

private val LightColorPalette = lightColorScheme(
  primary = ColorPrimary,
  primaryContainer = ColorPrimaryDark,
  secondary = ColorAccent

  /* Other default colors to override
  background = Color.White,
  surface = Color.White,
  onPrimary = Color.White,
  onSecondary = Color.Black,
  onBackground = Color.Black,
  onSurface = Color.Black,
  */
)

@Composable
fun ComposeMaterialYou(
  darkTheme: Boolean = isSystemInDarkTheme(),
  content: @Composable () -> Unit
) {

  val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
  val colorScheme = when {
    dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
    dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
    darkTheme -> DarkColorPalette
    else -> LightColorPalette
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}