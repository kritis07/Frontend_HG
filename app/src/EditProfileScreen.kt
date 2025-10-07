package com.example.frontend_hg.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.frontend_hg.ui.components.PeachBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProfileScreen(onBack: () -> Unit) {
    var name by remember { mutableStateOf("character") }
    var email by remember { mutableStateOf("user@example.com") }
    var phone by remember { mutableStateOf("+918888800000") }
    var pass by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("25") }
    var gender by remember { mutableStateOf("Male") }

    PeachBackground {
        Column(Modifier.fillMaxSize()) {
            TopAppBar(
                title = { Text("Edit Profile") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
            Spacer(Modifier.height(12.dp))
            Column(Modifier.padding(horizontal = 16.dp)) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Username") },
                    modifier = Modifier.fillMaxWidth()
                )
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text("Email ID") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = phone,
                    onValueChange = { phone = it },
                    label = { Text("Phone Number") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
                OutlinedTextField(
                    value = pass,
                    onValueChange = { pass = it },
                    label = { Text("Password") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                )
                Row(Modifier.fillMaxWidth()) {
                    OutlinedTextField(
                        value = age,
                        onValueChange = { age = it },
                        label = { Text("Age") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, end = 6.dp)
                    )
                    OutlinedTextField(
                        value = gender,
                        onValueChange = { gender = it },
                        label = { Text("Gender") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(top = 8.dp, start = 6.dp)
                    )
                }
                Spacer(Modifier.height(18.dp))
                Button(
                    onClick = { /* Save profile logic */ },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Update", fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}
