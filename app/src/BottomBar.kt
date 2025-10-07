package com.example.frontend_hg.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.frontend_hg.ui.theme.HG

@Composable
fun CenterFabBottomBar(
    leftIcon: ImageVector,
    rightIcon: ImageVector,
    onLeft: () -> Unit,
    onCenter: () -> Unit,
    onRight: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(HG.bgGradient())
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            tonalElevation = 2.dp,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(64.dp)
        ) { /* empty background */ }

        // Left button
        FilledIconButton(
            onClick = onLeft,
            shape = CircleShape,
            colors = IconButtonDefaults.filledIconButtonColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 24.dp, bottom = 10.dp)
                .size(44.dp)
        ) { Icon(leftIcon, contentDescription = null) }

        // Right button
        FilledIconButton(
            onClick = onRight,
            shape = CircleShape,
            colors = IconButtonDefaults.filledIconButtonColors(containerColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 24.dp, bottom = 10.dp)
                .size(44.dp)
        ) { Icon(rightIcon, contentDescription = null) }

        // Center heart button
        FloatingActionButton(
            onClick = onCenter,
            containerColor = MaterialTheme.colorScheme.primary,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .size(64.dp)
        ) { Text("❤") }
    }
}
