package com.youtuberhn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.R

@Composable
fun ToolsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Herramientas Extras",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        
        val tools = listOf(
            "Banco de Ideas Generator",
            "Rincón de Grabación Checker",
            "Horario Óptimo de Publicación",
            "Recordatorios Diarios"
        )
        
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tools) { tool ->
                ToolItem(
                    toolName = tool,
                    onClick = { navController.navigate("tool/${tool.replace(" ", "_")}") }
                )
            }
        }
    }
}

@Composable
fun ToolItem(toolName: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = toolName,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_tool),
            contentDescription = "Herramienta",
            modifier = Modifier.size(24.dp)
        )
    }
}
