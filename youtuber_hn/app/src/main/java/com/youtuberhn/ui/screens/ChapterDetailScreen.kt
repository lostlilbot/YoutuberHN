package com.youtuberhn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.data.BookContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChapterDetailScreen(navController: NavHostController, chapterId: String) {
    val chapter = BookContent.chapters.find { it.id == chapterId }
    
    // Get gradient colors based on chapter
    val gradientColors = when (chapterId) {
        "prologo" -> listOf(Color(0xFF6B4EFF), Color(0xFF9B7DFF), Color(0xFFB8A9FF))
        "introduccion" -> listOf(Color(0xFF2196F3), Color(0xFF64B5F6), Color(0xFF90CAF9))
        "capitulo1" -> listOf(Color(0xFFFF0000), Color(0xFFFF6B6B), Color(0xFFFFABAB))
        "capitulo2" -> listOf(Color(0xFF4CAF50), Color(0xFF81C784), Color(0xFFA5D6A7))
        "capitulo3" -> listOf(Color(0xFFFF9800), Color(0xFFFFB74D), Color(0xFFFFCC80))
        "capitulo4" -> listOf(Color(0xFFE91E63), Color(0xFFF06292), Color(0xFFF8BBD9))
        "capitulo5" -> listOf(Color(0xFF00BCD4), Color(0xFF4DD0E1), Color(0xFF80DEEA))
        "capitulo6" -> listOf(Color(0xFF9C27B0), Color(0xFFBA68C8), Color(0xFFE1BEE7))
        "capitulo7" -> listOf(Color(0xFFFFEB3B), Color(0xFFFFF176), Color(0xFFFFF9C4))
        "conclusion" -> listOf(Color(0xFF00C853), Color(0xFF69F0AE), Color(0xFFB9F6CA))
        else -> listOf(Color(0xFFFF0000), Color(0xFFFF6B6B), Color(0xFFFFABAB))
    }
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(chapter?.title ?: "Capítulo") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { paddingValues ->
        chapter?.let {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                // Header with gradient
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .background(
                            Brush.verticalGradient(colors = gradientColors)
                        )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        // Chapter number badge
                        Surface(
                            shape = RoundedCornerShape(20.dp),
                            color = Color.White.copy(alpha = 0.2f)
                        ) {
                            Text(
                                text = when (chapterId) {
                                    "prologo" -> "📖 PRÓLOGO"
                                    "introduccion" -> "📖 INTRODUCCIÓN"
                                    "capitulo1" -> "📖 CAPÍTULO 1"
                                    "capitulo2" -> "📖 CAPÍTULO 2"
                                    "capitulo3" -> "📖 CAPÍTULO 3"
                                    "capitulo4" -> "📖 CAPÍTULO 4"
                                    "capitulo5" -> "📖 CAPÍTULO 5"
                                    "capitulo6" -> "📖 CAPÍTULO 6"
                                    "capitulo7" -> "📖 CAPÍTULO 7"
                                    "conclusion" -> "📖 CONCLUSIÓN"
                                    else -> "📖 CAPÍTULO"
                                },
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                            )
                        }
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
                
                // Content
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    // Main content card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(
                                text = it.content,
                                style = MaterialTheme.typography.bodyLarge,
                                lineHeight = MaterialTheme.typography.bodyLarge.lineHeight * 1.4
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    // Action section
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Surface(
                                    shape = RoundedCornerShape(12.dp),
                                    color = MaterialTheme.colorScheme.primary
                                ) {
                                    Text(
                                        text = "⚡",
                                        style = MaterialTheme.typography.titleLarge,
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = "ACCIÓN DEL DÍA",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            Spacer(modifier = Modifier.height(16.dp))
                            Text(
                                text = it.actionTitle,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = it.actionDescription,
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                            )
                        }
                    }
                    
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        } ?: run {
            // Chapter not found
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "📖",
                        style = MaterialTheme.typography.displayLarge
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Capítulo no encontrado",
                        style = MaterialTheme.typography.headlineSmall
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(onClick = { navController.popBackStack() }) {
                        Text("Volver")
                    }
                }
            }
        }
    }
}
