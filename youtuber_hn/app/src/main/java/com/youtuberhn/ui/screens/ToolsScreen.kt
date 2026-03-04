package com.youtuberhn.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class Tool(
    val id: String,
    val title: String,
    val description: String
)

val toolsList = listOf(
    Tool(
        id = "idea_generator",
        title = "Banco de Ideas Generator",
        description = "Genera ideas de contenido basadas en tu nicho"
    ),
    Tool(
        id = "recording_checker",
        title = "Rincón de Grabación Checker",
        description = "Evalúa tu espacio de grabación"
    ),
    Tool(
        id = "schedule",
        title = "Horario Óptimo de Publicación",
        description = "Descubre el mejor momento para publicar"
    ),
    Tool(
        id = "reminders",
        title = "Recordatorios Diarios",
        description = "Configurarecordatorios para grabar"
    )
)

@Composable
fun ToolsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Herramientas Extras",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(horizontal = 16.dp))
        
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(toolsList) { tool ->
                ToolItem(
                    tool = tool,
                    onClick = { navController.navigate("tool/${tool.id}") }
                )
            }
        }
    }
}

@Composable
fun ToolItem(tool: Tool, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = tool.title,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = tool.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
