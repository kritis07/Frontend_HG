package com.example.frontend_hg.ui.theme.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.min

@Composable
fun RingMetric(
    valueText: String,
    label: String,
    progress: Float,           // 0f..1f
    colors: List<Color>,
    modifier: Modifier = Modifier,
) {
    // ✅ Read theme outside Canvas (Canvas lambda is not @Composable)
    val bgRingColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.3f)

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Box(contentAlignment = Alignment.Center) {
            val stroke = 10f
            Canvas(modifier = Modifier.size(90.dp)) {
                val diameter = min(size.width, size.height)
                val topLeft = Offset(
                    (size.width - diameter) / 2f,
                    (size.height - diameter) / 2f
                )

                // Background ring
                drawArc(
                    color = bgRingColor,
                    startAngle = -90f,
                    sweepAngle = 360f,
                    useCenter = false,
                    topLeft = topLeft,
                    size = Size(diameter, diameter),
                    style = Stroke(width = stroke, cap = StrokeCap.Round)
                )

                // Foreground ring
                drawArc(
                    brush = Brush.sweepGradient(colors),
                    startAngle = -90f,
                    sweepAngle = progress.coerceIn(0f, 1f) * 360f,
                    useCenter = false,
                    topLeft = topLeft,
                    size = Size(diameter, diameter),
                    style = Stroke(width = stroke, cap = StrokeCap.Round)
                )
            }
            Text(valueText, fontSize = 16.sp, fontWeight = FontWeight.Medium)
        }
        Spacer(Modifier.height(6.dp))
        Text(label, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
private fun RingMetricPreview() {
    RingMetric(
        valueText = "120 bpm",
        label = "Heart Rate",
        progress = 0.75f,
        colors = listOf(Color(0xFFFF5A5A), Color(0xFFFFA680))
    )
}
