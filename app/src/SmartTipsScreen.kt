package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.ui.components.PeachBackground

data class SmartTip(val title: String, val suggestions: List<String>)

@OptIn(ExperimentalMaterial3Api::class)   // ✅ Add this to fix warning
@Composable
fun SmartTipsScreen(onBack: () -> Unit) {
    val tips = listOf(
        SmartTip(
            "1. ECG (Heart Rhythm)",
            listOf(
                "Maintain a steady sleep schedule to support heart rhythm.",
                "Avoid excessive caffeine and alcohol.",
                "Practice deep breathing or meditation daily."
            )
        ),
        SmartTip(
            "2. PPG / SpO₂ (Blood Oxygen)",
            listOf(
                "Take short walks or stretch regularly to improve circulation.",
                "Avoid smoking or dusty environments.",
                "Practice slow, deep breathing to increase oxygen saturation."
            )
        ),
        SmartTip(
            "3. Body Temperature",
            listOf(
                "Stay hydrated to regulate body heat.",
                "Dress appropriately for weather conditions.",
                "Rest if you have a persistent fever."
            )
        ),
        SmartTip(
            "4. Motion / Activity",
            listOf(
                "Take breaks during long sitting periods.",
                "Add light exercise like stretching or yoga.",
                "Maintain proper posture while standing and walking."
            )
        ),
        SmartTip(
            "5. Stress (GSR – Skin Conductance)",
            listOf(
                "Try mindfulness or meditation for 10 minutes a day.",
                "Reduce screen time before bed.",
                "Practice progressive muscle relaxation."
            )
        ),
        SmartTip(
            "6. Muscle Activity (EMG)",
            listOf(
                "Warm up before workouts to prevent injury.",
                "Avoid overexertion of muscles during exercise.",
                "Use proper form when lifting weights or doing physical work."
            )
        )
    )

    PeachBackground {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Smart Tips", fontSize = 20.sp, fontWeight = FontWeight.SemiBold) },
                    navigationIcon = {
                        IconButton(onClick = onBack) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { inner ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(inner)
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(tips) { tip ->
                    Surface(
                        shape = MaterialTheme.shapes.medium,
                        tonalElevation = 1.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column(Modifier.padding(12.dp)) {
                            Text(
                                tip.title,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(Modifier.height(6.dp))
                            tip.suggestions.forEach {
                                Text("• $it", fontSize = 14.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}
