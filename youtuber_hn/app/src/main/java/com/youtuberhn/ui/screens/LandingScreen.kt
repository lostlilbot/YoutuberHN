package com.youtuberhn.ui.screens

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun LandingScreen(navController: NavHostController) {
    var isPlaying by remember { mutableStateOf(false) }
    var navigateToHome by remember { mutableStateOf(false) }
    
    // Handle navigation when triggered
    LaunchedEffect(navigateToHome) {
        if (navigateToHome) {
            delay(1500)
            navController.navigate("home") {
                popUpTo("landing") { inclusive = true }
            }
        }
    }
    
    // Pulsating animation for the play button
    val infiniteTransition = rememberInfiniteTransition(label = "pulse")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.15f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = EaseInOutCubic),
            repeatMode = RepeatMode.Reverse
        ),
        label = "scale"
    )
    
    // Rotation animation for the circle around play button
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(3000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )
    
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1A1A1A),
                        Color(0xFF0D0D0D)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Logo/Brand area
            Text(
                text = "▶",
                style = MaterialTheme.typography.displayLarge.copy(fontSize = 80.sp),
                color = Color.White
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // App title with gradient
            Text(
                text = "YOUTUBER HN",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 4.sp
                ),
                color = Color.White
            )
            
            Text(
                text = "De Cero a Éxito",
                style = MaterialTheme.typography.titleLarge,
                color = Color(0xFFFF0000)
            )
            
            Spacer(modifier = Modifier.height(60.dp))
            
            // Play button with animation
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(120.dp)
                    .scale(if (isPlaying) scale else 1f)
                    .clickable {
                        isPlaying = true
                        navigateToHome = true
                    }
            ) {
                // Outer glow ring
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.1f))
                )
                
                // Red circle
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(
                            Brush.radialGradient(
                                colors = listOf(
                                    Color(0xFFFF0000),
                                    Color(0xFFCC0000)
                                )
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    // Play triangle
                    Text(
                        text = "▶",
                        style = MaterialTheme.typography.displayMedium,
                        color = Color.White
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            Text(
                text = "Toca para comenzar",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White.copy(alpha = 0.7f)
            )
            
            Spacer(modifier = Modifier.height(80.dp))
            
            // Loading dots
            if (isPlaying) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    repeat(3) { index ->
                        val dotScale by rememberInfiniteTransition(label = "dots").animateFloat(
                            initialValue = 0.5f,
                            targetValue = 1f,
                            animationSpec = infiniteRepeatable(
                                animation = tween(500, delayMillis = index * 150),
                                repeatMode = RepeatMode.Reverse
                            ),
                            label = "dot$index"
                        )
                        Box(
                            modifier = Modifier
                                .size(12.dp)
                                .scale(dotScale)
                                .clip(CircleShape)
                                .background(Color(0xFFFF0000))
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.weight(1f))
            
            // Bottom text
            Text(
                text = "🇭🇳 Hecho en Honduras para Honduras",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.5f)
            )
        }
    }
}
