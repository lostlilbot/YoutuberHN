package com.youtuberhn.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.R

@Composable
fun HomeScreen(navController: NavHostController) {
    var progress by remember { mutableStateOf(0.15f) } // 15% progress
    
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Spacer(modifier = Modifier.height(32.dp))
            
            // Book cover
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "📚",
                            style = MaterialTheme.typography.displayLarge
                        )
                        Text(
                            text = "De Cero a Youtuber en Honduras",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(24.dp))
            
            // Start button
            Button(
                onClick = { navController.navigate("chapters") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("Empezar Ahora", style = MaterialTheme.typography.titleMedium)
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Progress tracker
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Progreso",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(
                            text = "${(progress * 100).toInt()}%",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    LinearProgressIndicator(
                        progress = progress,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(8.dp),
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(32.dp))
            
            // Main navigation buttons
            Text(
                text = "Explora la Guía",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(horizontal = 0.dp)
            )
            
            Spacer(modifier = Modifier.height(16.dp))
        }
        
        item {
            // Capítulos button
            NavButton(
                title = "Capítulos",
                description = "Lee el libro completo",
                emoji = "📖",
                onClick = { navController.navigate("chapters") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            // Acciones del Día button
            NavButton(
                title = "Acciones del Día",
                description = "Interactúa con cada capítulo",
                emoji = "🎯",
                onClick = { navController.navigate("actions") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            // Herramientas button
            NavButton(
                title = "Herramientas Extras",
                description = "Banco de ideas, recording checker, horarios",
                emoji = "🔧",
                onClick = { navController.navigate("tools") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            // Extras button
            NavButton(
                title = "Extras",
                description = "Buscar, modo oscuro, exportar progreso",
                emoji = "⚙️",
                onClick = { navController.navigate("extras") }
            )
            Spacer(modifier = Modifier.height(12.dp))
            
            // Grabar Video button
            NavButton(
                title = "🎬 Grabar Video",
                description = "Abre la cámara para grabar",
                emoji = "🎥",
                onClick = { navController.navigate("camera") }
            )
            
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun NavButton(
    title: String,
    description: String,
    emoji: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = emoji,
                style = MaterialTheme.typography.displaySmall
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = "→",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}
