package com.youtuberhn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.data.BookContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExtrasScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Extras",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        
        // Search bar
        var searchQuery by remember { mutableStateOf("") }
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar en el libro") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = { Text("Escribe una palabra...") }
        )
        
        // Search results
        if (searchQuery.isNotEmpty()) {
            val matchingChapters = BookContent.chapters.filter { chapter ->
                chapter.title.contains(searchQuery, ignoreCase = true) ||
                chapter.content.contains(searchQuery, ignoreCase = true) ||
                chapter.actionTitle.contains(searchQuery, ignoreCase = true)
            }
            
            if (matchingChapters.isNotEmpty()) {
                Text(
                    text = "Resultados de búsqueda: ${matchingChapters.size} capítulo(s) encontrado(s)",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    items(matchingChapters) { chapter ->
                        SearchResultItem(
                            chapterTitle = chapter.title,
                            searchQuery = searchQuery,
                            onClick = { navController.navigate("chapter/${chapter.id}") }
                        )
                    }
                }
            } else {
                Text(
                    text = "No se encontraron resultados para \"$searchQuery\"",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        
        Divider(modifier = Modifier.padding(vertical = 16.dp))
        var isDarkMode by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Modo Oscuro",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = isDarkMode,
                onCheckedChange = { isDarkMode = it }
            )
        }
        
        // Large text toggle
        var isLargeText by remember { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Texto Grande",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = isLargeText,
                onCheckedChange = { isLargeText = it }
            )
        }
        
        // Export notes button
        Button(
            onClick = { /* Export notes */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Exportar Notas como PDF/Imagen")
        }
        
        // Progress dashboard
        Text(
            text = "Mi Progreso",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(16.dp)
        )
        
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "¡Púchica, vas bien! 🔥",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Progreso: 15% completado",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Maje, sigue así que vas a llegar lejos. ¡Ya eres un catracho más creativo! 💪",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchResultItem(chapterTitle: String, searchQuery: String, onClick: () -> Unit) {
    val matchingChapter = BookContent.chapters.find { it.title == chapterTitle }
    val snippet = matchingChapter?.content?.take(200) ?: ""
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        onClick = onClick
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = chapterTitle,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            // Show content snippet with highlighted search terms
            Text(
                text = buildAnnotatedString {
                    val lowerContent = snippet.lowercase()
                    val lowerQuery = searchQuery.lowercase()
                    var lastIndex = 0
                    var index = lowerContent.indexOf(lowerQuery)
                    
                    while (index >= 0 && index < snippet.length) {
                        append(snippet.substring(lastIndex, index))
                        withStyle(SpanStyle(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )) {
                            append(snippet.substring(index, index + searchQuery.length))
                        }
                        lastIndex = index + searchQuery.length
                        index = lowerContent.indexOf(lowerQuery, lastIndex)
                    }
                    append(snippet.substring(lastIndex))
                    if (lastIndex == 0 && snippet.isNotEmpty()) {
                        append("...")
                    }
                },
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Toca para ver el capítulo completo",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
