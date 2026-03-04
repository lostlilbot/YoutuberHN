package com.youtuberhn.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.R

@Composable
fun ChaptersScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Capítulos",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        val chapters = listOf(
            "Prólogo",
            "Introducción",
            "Capítulo 1: Cómo empezar",
            "Capítulo 2: Equipo básico",
            "Capítulo 3: Planificación de contenido",
            "Capítulo 4: Grabación",
            "Capítulo 5: Edición",
            "Capítulo 6: Publicación",
            "Capítulo 7: Monetización",
            "Conclusión"
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(chapters) { chapter ->
                ChapterItem(
                    chapter = chapter,
                    onClick = { navController.navigate("chapter/${chapter.replace(" ", "_")}") }
                )
            }
        }
    }
}

@Composable
fun ChapterItem(chapter: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = chapter,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        if (chapter == "Capítulo 1: Cómo empezar") {
            Text(
                text = "Leído",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}