package com.youtuberhn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.R

@Composable
fun ChapterDetailScreen(navController: NavHostController, chapterName: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = chapterName,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Contenido del capítulo: $chapterName\n\nAquí se mostrará el texto completo del capítulo desde el libro.\n\nEn la versión final, este texto será una copia exacta de las páginas del libro, incluyendo ejemplos y ejercicios.\n\nPara este ejemplo, se muestra texto de muestra para demostrar la estructura.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        Button(
            onClick = { /* Mark as read */ },
            modifier = Modifier
                .align(Alignment.End)
                .padding(16.dp)
        ) {
            Text("Marcar como leído")
        }
    }
}