package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.ui.components.BrandRow
import com.example.frontend_hg.ui.components.PeachBackground
import com.example.frontend_hg.ui.components.SectionCard
import com.example.frontend_hg.ui.components.HeartHealthCard
import com.example.frontend_hg.ui.theme.HG
import com.example.frontend_hg.ui.theme.components.RingMetric

@Composable
fun DashboardScreen(
    onOpenCalendar: () -> Unit,
    onOpenLive: () -> Unit,
    onOpenSmartTips: () -> Unit
) {
    PeachBackground {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 12.dp)
        ) {
            // Header: brand + calendar icon
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                BrandRow(modifier = Modifier.weight(1f))
                IconButton(
                    onClick = onOpenCalendar,
                    modifier = Modifier.padding(top = 6.dp, end = 8.dp)
                ) { Icon(Icons.Filled.CalendarMonth, contentDescription = null) }
            }

            // Metrics board (NO warning chip anymore)
            SectionCard(modifier = Modifier.padding(horizontal = 16.dp)) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RingMetric("120 bpm", "Heart Rate", 0.80f, listOf(HG.Orange, HG.Red))
                    RingMetric("40°C", "Temperature", 0.40f, listOf(HG.Blue, HG.Blue))
                    RingMetric("460 µS", "Stress", 0.70f, listOf(HG.Yellow, HG.Orange))
                }
                Spacer(Modifier.height(12.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    RingMetric("Normal", "ECG", 0.50f, listOf(HG.Purple, HG.Purple))
                    RingMetric("68 mV", "EMG", 0.60f, listOf(HG.Yellow, HG.Orange))
                    RingMetric("Stable", "Motion", 0.30f, listOf(HG.Teal, HG.Teal))
                }
                Spacer(Modifier.height(12.dp))

                OutlinedButton(
                    onClick = onOpenLive,
                    shape = RoundedCornerShape(12.dp)
                ) { Text("Go to Live Monitoring") }
            }

            Spacer(Modifier.height(16.dp))

            // Smart Tips title
            Text(
                "Smart Tips",
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            // Clickable smart tips row with chevron
            Surface(
                onClick = onOpenSmartTips,
                shape = RoundedCornerShape(16.dp),
                tonalElevation = 1.dp,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(Modifier.weight(1f)) {
                        Text("Avoid intensive exercise", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                        Text(
                            "Hydrate adequately",
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                    }
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            // === My Heart Health card (now visible) ===
            HeartHealthCard(
                score = 82,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(Modifier.height(76.dp)) // space above bottom bar
        }
    }
}
