package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import com.example.frontend_hg.ui.components.PeachBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarScreen(onBack: () -> Unit, onOk: () -> Unit) {
    val state = rememberDatePickerState()
    PeachBackground {
        Column(Modifier.fillMaxSize().padding(12.dp)) {
            IconButton(onClick = onBack) { Icon(Icons.Default.ArrowBack, null) }
            Spacer(Modifier.height(8.dp))
            Surface(tonalElevation = 2.dp, shape = MaterialTheme.shapes.extraLarge) {
                DatePicker(state = state, showModeToggle = false)
            }
            Spacer(Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                Button(onClick = onOk) { Text("OK") }
            }
            Spacer(Modifier.height(24.dp))
            Text("Showing health records\nfrom the past 7 days",
                color = MaterialTheme.colorScheme.error, fontWeight = FontWeight.SemiBold
            )
        }
    }
}
