package com.example.frontend_hg.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.frontend_hg.R
import com.example.frontend_hg.ui.theme.HG

@Composable
fun PeachBackground(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(HG.bgGradient())
    ) { content() }
}

@Composable
fun BrandRow(modifier: Modifier = Modifier, title: String = "Heart Guard") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
        val logo = runCatching { painterResource(id = R.drawable.ic_heartguard) }.getOrNull()
        if (logo != null) {
            Image(
                painter = logo,
                contentDescription = "logo",
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
        } else {
            Icon(
                Icons.Default.Favorite, contentDescription = "logo",
                tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(44.dp)
            )
        }
        Spacer(Modifier.width(12.dp))
        Text(title, fontSize = 28.sp, fontWeight = FontWeight.SemiBold, color = MaterialTheme.colorScheme.primary)
    }
}

@Composable
fun SectionCard(
    modifier: Modifier = Modifier,
    corner: Dp = 18.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(2.dp, RoundedCornerShape(corner)),
        shape = RoundedCornerShape(corner),
        tonalElevation = 1.dp
    ) {
        Column(Modifier.padding(16.dp), content = content)
    }
}
