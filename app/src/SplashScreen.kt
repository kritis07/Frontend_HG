package com.example.frontend_hg.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.platform.LocalDensity
import kotlinx.coroutines.delay
import androidx.compose.animation.core.Animatable
import com.example.frontend_hg.R
import com.example.frontend_hg.ui.components.PeachBackground

@Composable
fun SplashScreen(onDone: () -> Unit) {
    // Animatables for the icon
    val scale = remember { Animatable(0.8f) }
    val offsetY = remember { Animatable(60f) } // px, shifted down initially

    // Controls when the “Heart Guard” text fades/slides in
    var showTitle by remember { mutableStateOf(false) }

    // Run the animation sequence
    LaunchedEffect(Unit) {
        // icon pops & lifts
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing)
        )
        offsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 700, easing = FastOutSlowInEasing)
        )

        // now reveal the title
        showTitle = true

        // keep on screen a moment, then continue
        delay(900)
        onDone()
    }

    PeachBackground {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.Start, // title sits to the right of icon in wide layouts
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Row with icon + title (title animates in later)
                Row(verticalAlignment = Alignment.CenterVertically) {

                    val offsetYdp = with(LocalDensity.current) { offsetY.value.toDp() }

                    Image(
                        painter = painterResource(R.drawable.ic_heartguard), // your drawable
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .size(88.dp)          // visually close to the mock
                            .scale(scale.value)
                            .offset(y = offsetYdp)
                    )

                    Spacer(Modifier.width(20.dp))

                    AnimatedVisibility(
                        visible = showTitle,
                        enter = fadeIn(animationSpec = tween(450)) +
                                slideInHorizontally(
                                    initialOffsetX = { it / 4 },
                                    animationSpec = tween(450, easing = FastOutSlowInEasing)
                                )
                    ) {
                        androidx.compose.material3.Text(
                            text = "Heart Guard",
                            color = Color(0xFFFF6A00), // warm orange like the mock
                            fontSize = 34.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Start,
                            style = MaterialTheme.typography.headlineLarge
                        )
                    }
                }
            }
        }
    }
}
