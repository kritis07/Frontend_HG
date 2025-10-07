package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

// ---- Achievements ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun AchievementsScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Achievements", onBack) {
        ElevatedCard(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("🏅 Streak: 7 days", fontWeight = FontWeight.SemiBold)
                Text("Completed 5/7 goals this week")
            }
        }
    }
}

// ---- Weekly Reports ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun WeeklyReportsScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Weekly Reports", onBack) {
        Text("Your last 7 days summary appears here.")
    }
}

// ---- Notifications & Alerts ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun NotificationsScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Notifications & Alerts", onBack) {
        Text("Configure thresholds and alert rules.")
    }
}

// ---- Emergency Contacts ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun EmergencyContactsScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Emergency Contacts", onBack) {
        Text("Add or edit emergency contacts.")
    }
}

// ---- Theme ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun ThemeScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Theme", onBack) {
        Text("Choose light/dark or accent colors.")
    }
}

// ---- Personal Doctor ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun PersonalDoctorScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Personal Doctor", onBack) {
        Text("Doctor’s details and quick contact.")
    }
}

// ---- Help & Support ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun HelpSupportScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Help & Support", onBack) {
        Text("FAQs, report an issue, contact support.")
    }
}

// ---- Logout (placeholder) ----
@OptIn(ExperimentalMaterial3Api::class)
@Composable fun LogoutScreen(onBack: () -> Unit) {
    SimpleTopBarPage("Log Out", onBack) {
        Text("Show a confirmation dialog and clear session.")
    }
}

/* ---------- Shared layout ---------- */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SimpleTopBarPage(
    title: String,
    onBack: () -> Unit,
    content: @Composable ColumnScope.() -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            Modifier
                .padding(inner)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            content()
        }
    }
}
