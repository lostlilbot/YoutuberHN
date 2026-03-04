package com.youtuberhn.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.data.BookContent
import com.youtuberhn.data.Chapter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtrasScreen(navController: NavHostController) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearching by remember { mutableStateOf(false) }
    
    Column(modifier = Modifier.fillMaxSize()) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Extras",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.weight(1f)
            )
        }
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        
        // Search bar - More prominent
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { 
                searchQuery = it
                isSearching = it.isNotEmpty()
            },
            label = { Text("🔍 Buscar en el libro") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Escribe palabras clave...") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Buscar"
                )
            },
            trailingIcon = {
                if (searchQuery.isNotEmpty()) {
                    IconButton(onClick = { 
                        searchQuery = ""
                        isSearching = false
                    }) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "Limpiar"
                        )
                    }
                }
            },
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
        
        // Search results or regular content
        if (isSearching && searchQuery.isNotEmpty()) {
            SearchResultsContent(searchQuery = searchQuery, navController = navController)
        } else {
            RegularExtrasContent(navController = navController)
        }
    }
}

@Composable
private fun SearchResultsContent(searchQuery: String, navController: NavHostController) {
    // Search through all chapters and content
    val matchingChapters = BookContent.chapters.filter { chapter ->
        chapter.title.contains(searchQuery, ignoreCase = true) ||
        chapter.content.contains(searchQuery, ignoreCase = true) ||
        chapter.actionTitle.contains(searchQuery, ignoreCase = true) ||
        chapter.actionDescription.contains(searchQuery, ignoreCase = true)
    }
    
    if (matchingChapters.isNotEmpty()) {
        Text(
            text = "📚 Resultados: ${matchingChapters.size} capítulo(s) encontrado(s)",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = MaterialTheme.colorScheme.primary
        )
        
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(matchingChapters) { chapter ->
                SearchResultCard(
                    chapter = chapter,
                    searchQuery = searchQuery,
                    onClick = { navController.navigate("chapter/${chapter.id}") }
                )
            }
        }
    } else {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "🔍",
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "No se encontraron resultados",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "para \"$searchQuery\"",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun SearchResultCard(
    chapter: Chapter,
    searchQuery: String,
    onClick: () -> Unit
) {
    // Find content snippet around the search term
    val content = chapter.content
    val lowerContent = content.lowercase()
    val lowerQuery = searchQuery.lowercase()
    val index = lowerContent.indexOf(lowerQuery)
    
    val snippet = if (index >= 0) {
        val start = maxOf(0, index - 50)
        val end = minOf(content.length, index + searchQuery.length + 100)
        val prefix = if (start > 0) "..." else ""
        val suffix = if (end < content.length) "..." else ""
        prefix + content.substring(start, end) + suffix
    } else {
        content.take(150) + "..."
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Chapter title with gradient indicator
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(
                            Brush.linearGradient(
                                colors = chapter.gradientColors.map { Color(it.toInt()) }
                            )
                        )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = chapter.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(1f)
                )
            }
            
            Spacer(modifier = Modifier.height(12.dp))
            
            // Content snippet with highlighted search terms
            Text(
                text = buildAnnotatedString {
                    val lowerSnippet = snippet.lowercase()
                    val lowerQ = searchQuery.lowercase()
                    var lastIndex = 0
                    var idx = lowerSnippet.indexOf(lowerQ)
                    
                    while (idx >= 0 && idx < snippet.length) {
                        append(snippet.substring(lastIndex, idx))
                        withStyle(SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            background = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.3f)
                        )) {
                            append(snippet.substring(idx, idx + searchQuery.length))
                        }
                        lastIndex = idx + searchQuery.length
                        idx = lowerSnippet.indexOf(lowerQ, lastIndex)
                    }
                    append(snippet.substring(lastIndex))
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            
            Spacer(modifier = Modifier.height(8.dp))
            
            Text(
                text = "👆 Toca para ver el capítulo completo",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Composable
private fun RegularExtrasContent(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Tips section
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "💡 Consejo del día",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Usa la búsqueda arriba para encontrar temas específicos en el libro. Busca palabras como: YouTube, dinero, grabar, editar, suscriptores, y más.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
        
        // Settings section
        item {
            Text(
                text = "Configuración",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        
        item {
            var isDarkMode by remember { mutableStateOf(false) }
            SettingsToggleRow(
                title = "Modo Oscuro",
                subtitle = "Cambia el tema de la app",
                icon = "🌙",
                isChecked = isDarkMode,
                onCheckedChange = { isDarkMode = it }
            )
        }
        
        item {
            var isLargeText by remember { mutableStateOf(false) }
            SettingsToggleRow(
                title = "Texto Grande",
                subtitle = "Aumenta el tamaño del texto",
                icon = "🔤",
                isChecked = isLargeText,
                onCheckedChange = { isLargeText = it }
            )
        }
        
        item {
            Button(
                onClick = { /* Export notes */ },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Text("📄 Exportar Notas como PDF/Imagen")
            }
        }
        
        // Progress section
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "📊 Mi Progreso",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        
        item {
            ProgressCard()
        }
        
        // Quick links
        item {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "🔗 Acceso Rápido",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        
        item {
            QuickLinkCard(
                title = "📖 Capítulos",
                description = "Lee el libro completo",
                gradientColors = listOf(Color(0xFF2196F3), Color(0xFF64B5F6)),
                onClick = { navController.navigate("chapters") }
            )
        }
        
        item {
            QuickLinkCard(
                title = "🎯 Acciones del Día",
                description = "Practica con cada capítulo",
                gradientColors = listOf(Color(0xFF4CAF50), Color(0xFF81C784)),
                onClick = { navController.navigate("actions") }
            )
        }
        
        item {
            QuickLinkCard(
                title = "🔧 Herramientas",
                description = "Banco de ideas y más",
                gradientColors = listOf(Color(0xFFFF9800), Color(0xFFFFB74D)),
                onClick = { navController.navigate("tools") }
            )
        }
        
        item {
            QuickLinkCard(
                title = "🎬 Grabar Video",
                description = "Abre la cámara",
                gradientColors = listOf(Color(0xFFFF0000), Color(0xFFFF6B6B)),
                onClick = { navController.navigate("camera") }
            )
        }
    }
}

@Composable
private fun SettingsToggleRow(
    title: String,
    subtitle: String,
    icon: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = icon,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Switch(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}

@Composable
private fun ProgressCard() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "🔥",
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Tu Progreso",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                }
                Text(
                    text = "15%",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            LinearProgressIndicator(
                progress = 0.15f,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(5.dp)),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "¡Sigue así, vas muy bien! Púchica, vas bien! 🔥",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
private fun QuickLinkCard(
    title: String,
    description: String,
    gradientColors: List<Color>,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Brush.linearGradient(colors = gradientColors))
                .padding(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }
                Text(
                    text = "→",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }
        }
    }
}
