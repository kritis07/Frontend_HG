package com.example.frontend_hg.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.R
import com.example.frontend_hg.ui.components.PeachBackground
import com.example.frontend_hg.ui.theme.HG

@Composable
fun LoginScreen(
    onSignIn: () -> Unit,
    onForgotPassword: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    PeachBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(Modifier.height(40.dp))

            // ===== Header: logo tile + big title =====
            Row(verticalAlignment = Alignment.CenterVertically) {

                // Replaces the white Surface with a peach gradient tile
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .clip(RoundedCornerShape(28.dp))
                        .background(
                            brush = Brush.verticalGradient(
                                listOf(
                                    Color(0xFFFFF4EC), // light peach
                                    Color(0xFFFFE4D6)  // slightly deeper peach
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_heartguard),
                        contentDescription = null,
                        modifier = Modifier.size(64.dp)
                    )
                }

                Spacer(Modifier.width(16.dp))
                Text(
                    text = "Heart Guard",
                    color = HG.Orange,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 0.5.sp
                )
            }

            Spacer(Modifier.height(28.dp))

            // ===== Card with outline around fields =====
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(28.dp),
                tonalElevation = 1.dp,
                shadowElevation = 0.dp,
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
                )
            ) {
                Column(Modifier.padding(20.dp)) {
                    // Email
                    Text("Email", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        placeholder = { Text("Value") },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                            focusedBorderColor = HG.Orange,
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface
                        )
                    )

                    Spacer(Modifier.height(18.dp))

                    // Password
                    Text("Password", fontSize = 18.sp, fontWeight = FontWeight.Medium)
                    Spacer(Modifier.height(8.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = { Text("Value") },
                        singleLine = true,
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.35f),
                            focusedBorderColor = HG.Orange,
                            focusedContainerColor = MaterialTheme.colorScheme.surface,
                            unfocusedContainerColor = MaterialTheme.colorScheme.surface
                        )
                    )

                    Spacer(Modifier.height(22.dp))

                    // Sign In button (fat & rounded)
                    Button(
                        onClick = onSignIn,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(54.dp),
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = HG.Orange,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text("Sign In", fontSize = 18.sp, fontWeight = FontWeight.SemiBold)
                    }

                    Spacer(Modifier.height(18.dp))

                    // Link (underlined, left aligned)
                    TextButton(
                        onClick = onForgotPassword,
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            "Forgot password?",
                            color = MaterialTheme.colorScheme.onSurface,
                            textDecoration = TextDecoration.Underline,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Spacer(Modifier.height(24.dp))
        }
    }
}
