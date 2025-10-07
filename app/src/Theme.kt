package com.example.frontend_hg.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object HG {
    val PeachTop = Color(0xFFFFF1EA)
    val PeachMid = Color(0xFFFFE0D3)
    val PeachBottom = Color(0xFFFBD3C3)

    val Orange = Color(0xFFFF6A2E)
    val OrangeDark = Color(0xFFE3501E)

    val Red = Color(0xFFEF3A2E)
    val Blue = Color(0xFF2CB4F6)
    val Purple = Color(0xFF7B57D1)
    val Teal = Color(0xFF1F9C8A)
    val Yellow = Color(0xFFF7B42C)

    fun bgGradient() = Brush.verticalGradient(listOf(PeachTop, PeachMid, PeachBottom))
}

@Composable
fun HeartGuardTheme(content: @Composable () -> Unit) {
    val colors = lightColorScheme(
        primary = HG.Orange,
        secondary = HG.Yellow,
        background = Color.Transparent,
        surface = Color.White,
        onPrimary = Color.White,
        onSurface = Color(0xFF161616)
    )
    MaterialTheme(colorScheme = colors, content = content)
}
