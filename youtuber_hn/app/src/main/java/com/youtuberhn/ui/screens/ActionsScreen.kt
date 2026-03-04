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
fun ActionsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Acciones del Día",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        val actions = listOf(
            "Capítulo 1: Escribe 10 títulos de video",
            "Capítulo 2: Checklist de equipo",
            "Capítulo 3: Planificador de contenido",
            "Capítulo 4: Graba 3 minutos ahora",
            "Capítulo 5: Editor de video simple",
            "Capítulo 6: Planifica tu publicación",
            "Capítulo 7: Calculadora de monetización"
        )
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(actions) { action ->
                ActionItem(
                    action = action,
                    onClick = { navController.navigate("action/${action.replace(" ", "_")}") }
                )
            }
        }
    }
}

@Composable
fun ActionItem(action: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = action,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.weight(1f)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_action),
            contentDescription = "Acción",
            modifier = Modifier.size(24.dp)
        )
    }
}