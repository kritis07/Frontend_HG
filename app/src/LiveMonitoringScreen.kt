package com.example.frontend_hg.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.ui.components.PeachBackground
import com.example.frontend_hg.ui.theme.HG
import com.example.frontend_hg.ui.theme.components.RingMetric
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LiveMonitoringScreen(onBack: () -> Unit) {
    PeachBackground {
        Column(Modifier.fillMaxSize()) {

            TopAppBar(
                title = { Text("Live Monitoring") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )

            Spacer(Modifier.height(6.dp))

            Surface(
                tonalElevation = 2.dp,
                shape = MaterialTheme.shapes.extraLarge,
                modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text("Heart Rate", fontSize = 22.sp)

                    // read theme color OUTSIDE Canvas
                    val graphColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f)

                    Box(
                        Modifier
                            .height(140.dp)
                            .fillMaxWidth()
                    ) {
                        Canvas(Modifier.matchParentSize()) {
                            val path = Path()
                            val step = size.width / 12f
                            var x = 0f
                            path.moveTo(0f, size.height * 0.7f)
                            repeat(12) { i ->
                                val y = size.height * (0.4f + Random(i).nextFloat() * 0.4f)
                                path.lineTo(x, y)
                                x += step
                            }
                            drawPath(path, color = graphColor)
                        }
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd) {
                            Text(
                                "152 bpm",
                                color = MaterialTheme.colorScheme.error,
                                modifier = Modifier.padding(8.dp)
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(12.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RingMetric("40°C", "Temperature", 0.4f, listOf(HG.Blue, HG.Blue))
                RingMetric("705 mV", "ECG", 0.7f, listOf(HG.Purple, HG.Purple))
                RingMetric("68 mV", "EMG", 0.6f, listOf(HG.Yellow, HG.Orange))
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                RingMetric("+02", "Motion", 0.3f, listOf(HG.Teal, HG.Teal))
                RingMetric("460 µS", "Stress", 0.7f, listOf(HG.Yellow, HG.Orange))
            }

            Spacer(Modifier.height(76.dp))
        }
    }
}
