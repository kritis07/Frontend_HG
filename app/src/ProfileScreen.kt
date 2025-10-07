package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.frontend_hg.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    onBack: () -> Unit,
    onEditProfile: () -> Unit,
    onOpen: (String) -> Unit,      // pass nav::navigate from App
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Profile Dashboard") },
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
                .fillMaxSize()
                .padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp)) {
                    Text("Abdul", style = MaterialTheme.typography.titleMedium)
                    Text("age 25 • Male")
                    Text("nicole.dos@example.com", color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Spacer(Modifier.height(12.dp))
                    Button(onClick = onEditProfile) { Text("Edit Profile") }
                }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureTile(
                    title = "Achievements",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.Achievements.route) }

                FeatureTile(
                    title = "Weekly Reports",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.WeeklyReports.route) }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureTile(
                    title = "Notifications & Alerts",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.Notifications.route) }

                FeatureTile(
                    title = "Emergency Contacts",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.EmergencyContacts.route) }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureTile(
                    title = "Theme",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.Theme.route) }

                FeatureTile(
                    title = "Personal Doctor",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.PersonalDoctor.route) }
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                FeatureTile(
                    title = "Help & Support",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.HelpSupport.route) }

                FeatureTile(
                    title = "Log Out",
                    modifier = Modifier.weight(1f)
                ) { onOpen(Screen.Logout.route) }
            }
        }
    }
}

@Composable
private fun FeatureTile(
    title: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        shape = MaterialTheme.shapes.large,
        tonalElevation = 1.dp,
        modifier = modifier.height(72.dp) // fixed height works well here
    ) {
        Box(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
        }
    }
}
