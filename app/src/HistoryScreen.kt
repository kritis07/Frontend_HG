package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MonitorHeart
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.ui.components.BrandRow
import com.example.frontend_hg.ui.components.PeachBackground
import com.example.frontend_hg.ui.components.SectionCard

@Composable
fun HistoryScreen(onBack: () -> Unit) {
    PeachBackground {
        Column(Modifier.fillMaxSize().padding(top = 8.dp)) {
            BrandRow()
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                IconButton(onClick = onBack) { Icon(Icons.Filled.ArrowBack, null) }
                Text("History", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(8.dp))
                Text("Aug 19, 2025", color = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f))
            }
            Spacer(Modifier.height(8.dp))

            MetricRowCard("Heart Rate", "High: 152 bpm\nLow: 60 bpm", Icons.Filled.MonitorHeart, tint = MaterialTheme.colorScheme.primary)
            MetricRowCard("Temperature", "High: 40 °C\nLow: 26 °C", Icons.Filled.Thermostat)
            MetricRowCard("ECG", "Normal", Icons.Filled.Waves)
            MetricRowCard("Stress", "High: 520µS\n7 abnormal readings", Icons.Filled.Waves)
            MetricRowCard("EMG Value", "High: 68 mV\nLow: 12 mV", Icons.Filled.Waves)
            MetricRowCard("Motion", "Stable", Icons.Filled.Waves)
            Spacer(Modifier.height(76.dp))
        }
    }
}

@Composable
private fun MetricRowCard(title: String, right: String, icon: androidx.compose.ui.graphics.vector.ImageVector, tint: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.secondary) {
    SectionCard(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Row {
                Icon(icon, contentDescription = null, tint = tint, modifier = Modifier.padding(end = 12.dp))
                Text(title, fontSize = 22.sp, fontWeight = FontWeight.SemiBold)
            }
            Text(right)
        }
    }
}
