package com.example.frontend_hg.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

/**
 * “My Heart Health” card like the reference:
 * blue header chip, big score, gradient bar with labels.
 */
@Composable
fun HeartHealthCard(
    score: Int,
    modifier: Modifier = Modifier
) {
    val clamped = score.coerceIn(0, 100)
    val headerColor = Color(0xFFD6E8FF)

    Column(modifier) {
        // Header pill
        Surface(
            color = headerColor,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
            tonalElevation = 0.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                "My Heart Health",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }

        // Body
        Surface(
            shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp),
            tonalElevation = 1.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = clamped.toString(),
                    fontSize = 44.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(Modifier.height(10.dp))

                HeartHealthGradientBar(
                    score = clamped,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(18.dp)
                )

                Spacer(Modifier.height(8.dp))
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Needs Rest", fontSize = 12.sp)
                    Text("Good", fontSize = 12.sp)
                    Text("Excellent", fontSize = 12.sp)
                }
            }
        }
    }
}

/** Full-width gradient with a small white marker at the score position. */
@Composable
private fun HeartHealthGradientBar(
    score: Int,
    modifier: Modifier = Modifier
) {
    val gradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFF5A5A), // red
            Color(0xFFFFB04A), // orange/yellow
            Color(0xFF10C060)  // green
        )
    )
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(gradient)
    ) {
        val fraction = score / 100f
        Row(Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(fraction))
            Box(
                Modifier
                    .width(2.dp)
                    .fillMaxHeight()
                    .background(Color.White)
            )
            Spacer(Modifier.weight(1f - fraction))
        }
    }
}
