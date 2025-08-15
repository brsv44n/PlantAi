package com.brsvar.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

object Colors

@Composable
@ReadOnlyComposable
fun Colors.lightPrimary() = LightPrimary

@Composable
@ReadOnlyComposable
fun Colors.lightOnPrimary() = LightOnPrimary

@Composable
@ReadOnlyComposable
fun Colors.lightBackground() = LightBackground

@Composable
@ReadOnlyComposable
fun Colors.lightSurface() = LightSurface

@Composable
@ReadOnlyComposable
fun Colors.lightOnBackground() = LightOnBackground

@Composable
@ReadOnlyComposable
fun Colors.lightOnSurface() = LightOnSurface

@Composable
@ReadOnlyComposable
fun Colors.lightSecondary() = LightSecondary

@Composable
@ReadOnlyComposable
fun Colors.lightDivider() = LightDivider

@Composable
@ReadOnlyComposable
fun Colors.darkPrimary() = DarkPrimary

@Composable
@ReadOnlyComposable
fun Colors.darkOnPrimary() = DarkOnPrimary

@Composable
@ReadOnlyComposable
fun Colors.darkBackground() = DarkBackground

@Composable
@ReadOnlyComposable
fun Colors.darkSurface() = DarkSurface

@Composable
@ReadOnlyComposable
fun Colors.darkOnBackground() = DarkOnBackground

@Composable
@ReadOnlyComposable
fun Colors.darkOnSurface() = DarkOnSurface

@Composable
@ReadOnlyComposable
fun Colors.darkSecondary() = DarkSecondary

@Composable
@ReadOnlyComposable
fun Colors.darkDivider() = DarkDivider

// LightTheme
val LightPrimary = Color(0xFF3B6D3F)
val LightOnPrimary = Color.White
val LightBackground = Color(0xFFF8F6F3)
val LightSurface = Color.White
val LightOnBackground = Color(0xFF333333)
val LightOnSurface = Color(0xFF333333)
val LightSecondary = Color(0xFFA3D39C)
val LightDivider = Color(0xFFE5E5E5)

// DarkTheme
val DarkPrimary = Color(0xFFA3D39C)
val DarkOnPrimary = Color.Black
val DarkBackground = Color(0xFF1C1C1C)
val DarkSurface = Color(0xFF2B2B2B)
val DarkOnBackground = Color(0xFFEAEAEA)
val DarkOnSurface = Color(0xFFEAEAEA)
val DarkSecondary = Color(0xFF4B7A4C)
val DarkDivider = Color(0xFF444444)
