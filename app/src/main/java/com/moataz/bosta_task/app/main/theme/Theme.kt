package com.moataz.bosta_task.app.main.theme

import android.app.Activity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun BostaTaskTheme(
    content: @Composable () -> Unit
) {
    val colors = lightColors(
        primary = WhiteLight,
        onPrimary = Black,
        surface = WhiteLight,
        onSurface = Black,
        background = WhiteLight,
        onBackground = Black
    )

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colors.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
    MaterialTheme(
        content = content
    )
}