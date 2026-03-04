package com.youtuberhn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.data.BookContent

@Composable
fun ActionDetailScreen(navController: NavHostController, actionType: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Acción del Día",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(16.dp)
        )
        Divider(modifier = Modifier.padding(16.dp))
        
        when {
            actionType.contains("1") || actionType.contains("título") -> {
                VideoTitlesAction()
            }
            actionType.contains("2") || actionType.contains("equipo") -> {
                EquipmentChecklistAction()
            }
            actionType.contains("3") || actionType.contains("planificador") -> {
                ContentPlannerAction()
            }
            actionType.contains("4") || actionType.contains("graba") -> {
                GrabaPracticeAction()
            }
            actionType.contains("5") || actionType.contains("editor") -> {
                VideoEditorAction()
            }
            actionType.contains("6") || actionType.contains("publicación") -> {
                PublicacionPlanAction()
            }
            actionType.contains("7") || actionType.contains("monetización") || actionType.contains("calculadora") -> {
                MonetizationCalculatorAction()
            }
            else -> {
                Text(
                    text = "Acción no encontrada. Próximamente más acciones.",
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Composable
fun VideoTitlesAction() {
    var titles by remember { mutableStateOf(listOf("", "", "", "", "", "", "", "", "", "")) }
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 1: Escribe 10 Títulos de Video",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Usa la fórmula: Cómo [beneficio] en [lugar/tiempo] sin [problema común]",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(titles.size) { index ->
                OutlinedTextField(
                    value = titles[index],
                    onValueChange = { newValue ->
                        titles = titles.toMutableList().apply { this[index] = newValue }
                    },
                    label = { Text("Título ${index + 1}") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                )
            }
        }
        
        Button(
            onClick = { /* Save titles */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Títulos")
        }
    }
}

@Composable
fun EquipmentChecklistAction() {
    val equipment = remember {
        mutableStateListOf(
            "Teléfono móvil (cámara)" to false,
            "Trípode" to false,
            "Anillo de luz" to false,
            "Micrófono externo" to false,
            "Iluminación extra" to false,
            "Fondo para grabación" to false,
            "Computadora para edición" to false,
            "Software de edición" to false
        )
    }
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 2: Checklist de Equipo",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Marca lo que ya tenés",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(equipment.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = equipment[index].second,
                        onCheckedChange = { checked ->
                            equipment[index] = equipment[index].first to checked
                        }
                    )
                    Text(
                        text = equipment[index].first,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
        
        val ownedCount = equipment.count { it.second }
        Text(
            text = "Tenés $ownedCount de ${equipment.size} elementos",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        
        Button(
            onClick = { /* Save progress */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Progreso")
        }
    }
}

@Composable
fun ContentPlannerAction() {
    var tanates by remember { mutableStateOf("") }
    var cacerias by remember { mutableStateOf("") }
    var chanchuyos by remember { mutableStateOf("") }
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 3: Planificador 3x3",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Planificá tu mes: 3 Tanates, 3 Cacerías Diarias, y los Chanchuyos",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = tanates,
            onValueChange = { tanates = it },
            label = { Text("3 Tanates (Videos principales)") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = cacerias,
            onValueChange = { cacerias = it },
            label = { Text("3 Cacerías Diarias") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = chanchuyos,
            onValueChange = { chanchuyos = it },
            label = { Text("Chanchuyos (Oportunidades)") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* Save plan */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Plan")
        }
    }
}

@Composable
fun GrabaPracticeAction() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 4: Graba 3 Minutos Ahora",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Abre la cámara de tu teléfono y graba 3 minutos de práctica. ¡No te preocupes por errores, son parte del aprendizaje!",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "🎬",
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Presiona el botón para abrir la cámara",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* Open camera */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Abrir Cámara")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedButton(
            onClick = { /* Playback */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ver Grabación")
        }
    }
}

@Composable
fun VideoEditorAction() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 5: Editor de Video Simple",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Edita tu video de práctica: agrega texto y música",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "✂️",
                    style = MaterialTheme.typography.displayLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Importa tu video de práctica",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* Import video */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Importar Video")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text("Texto introductorio") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedButton(
            onClick = { /* Add music */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Música")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(
            onClick = { /* Save */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Video Editado")
        }
    }
}

@Composable
fun PublicacionPlanAction() {
    var publishDate by remember { mutableStateOf("") }
    var publishTime by remember { mutableStateOf("") }
    var videoTitle by remember { mutableStateOf("") }
    var thumbnailDesc by remember { mutableStateOf("") }
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 6: Planifica tu Publicación",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Crea un calendario de publicación para los próximos 7 días",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = videoTitle,
            onValueChange = { videoTitle = it },
            label = { Text("Título del video") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = publishDate,
            onValueChange = { publishDate = it },
            label = { Text("Fecha de publicación (DD/MM)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = publishTime,
            onValueChange = { publishTime = it },
            label = { Text("Hora de publicación (HH:MM)") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = thumbnailDesc,
            onValueChange = { thumbnailDesc = it },
            label = { Text("Descripción de miniatura") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 2
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { /* Save */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Publicación")
        }
    }
}

@Composable
fun MonetizationCalculatorAction() {
    var viewsInput by remember { mutableStateOf("") }
    var estimatedEarnings by remember { mutableStateOf(0.0) }
    var cpm by remember { mutableStateOf(2.0) } // Average CPM for Honduras
    
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(
            text = "Capítulo 7: Calculadora de Monetización",
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Ingresá tus vistas estimadas y ve cuánto podrías ganar",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = viewsInput,
            onValueChange = { 
                viewsInput = it
                val views = it.toDoubleOrNull() ?: 0.0
                estimatedEarnings = (views / 1000) * cpm
            },
            label = { Text("Vistas estimadas") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "CPM (costo por mil anuncios): L. ${cpm * 24:.2f} (aproximado)",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Ganancias Estimadas",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "L. ${estimatedEarnings * 24:.2f}",
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "(${estimatedEarnings:.2f} USD)",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Nota: Esto es una estimación. Las ganancias reales varían según el tipo de contenido, ubicación de espectadores, temporada, etc.",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
