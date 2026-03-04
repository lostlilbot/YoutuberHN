package com.youtuberhn.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ToolDetailScreen(navController: NavHostController, toolId: String) {
    val tool = toolsList.find { it.id == toolId }
    
    Column(modifier = Modifier.fillMaxSize()) {
        tool?.let {
            Text(
                text = it.title,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp)
            )
            HorizontalDivider(modifier = Modifier.padding(horizontal = 16.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                when (toolId) {
                    "idea_generator" -> IdeaGeneratorContent()
                    "recording_checker" -> RecordingCheckerContent()
                    "schedule" -> ScheduleContent()
                    "reminders" -> RemindersContent()
                    else -> {
                        Text(
                            text = "Contenido de la herramienta",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        } ?: run {
            Text(
                text = "Herramienta no encontrada",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Composable
fun IdeaGeneratorContent() {
    var selectedNiche by remember { mutableStateOf("") }
    val niches = listOf(
        "Comida Hondureña",
        "Emprendimiento Local",
        "Turismo en Honduras",
        "Tutoriales Técnicos",
        "Comedia y Humor",
        "Vlogs Diarios"
    )
    
    val ideas = mapOf(
        "Comida Hondureña" to listOf(
            "Cómo hacer baleadas perfectas en casa",
            "Receta secret de la pasta de tortilla",
            "Comí solo comida hondureña por 24 horas",
            " probé los platos típicos de cada región",
            "Cómo hacer un atol de elote desde cero"
        ),
        "Emprendimiento Local" to listOf(
            "Cómo iniciar un negocio en Honduras con poco dinero",
            "Casos de éxito de emprendedores Hondureños",
            "Errores comunes al emprender en Honduras",
            "Cómo manejar clientes difíciles",
            "Consejos financieros para pequeños negocios"
        ),
        "Turismo en Honduras" to listOf(
            "Lugares desconocidos en Honduras que debes visitar",
            "Guía completa de Roatán en 3 días",
            " Aventura en Copán: qué ver y hacer",
            "Playas ocultas de Honduras",
            "Experiencia de ecoturismo en La Tigra"
        ),
        "Tutoriales Técnicos" to listOf(
            "Cómo usar CapCut para editar videos",
            "Tutorial de WhatsApp Business para negocios",
            "Cómo monetize tu canal de YouTube",
            "Tips para usar tu celular como cámara profesional",
            "Cómo configurar tu estudio de grabación casero"
        ),
        "Comedia y Humor" to listOf(
            "Cosas que solo pasan en Honduras",
            "El Hondureño vs el Extranjero",
            "Situaciones incómodas en Honduras",
            "Errores de traducción graciosos",
            "La vida cotidiana en Honduras"
        ),
        "Vlogs Diarios" to listOf(
            "Un día en Tegucigalpa",
            "Mi rutina de grabación",
            "Cómo grabo un video de principio a fin",
            "Detrás de cámaras de mi canal",
            "Mi setup de grabación completo"
        )
    )
    
    Text(
        text = "Selecciona tu nicho:",
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(8.dp))
    
    niches.forEach { niche ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selectedNiche == niche,
                onClick = { selectedNiche = niche }
            )
            Text(text = niche, modifier = Modifier.padding(start = 8.dp))
        }
    }
    
    if (selectedNiche.isNotEmpty()) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Ideas para videos:",
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        ideas[selectedNiche]?.forEach { idea ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "📹 $idea",
                    modifier = Modifier.padding(12.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun RecordingCheckerContent() {
    var hasGoodLighting by remember { mutableStateOf(false) }
    var hasQuietSpace by remember { mutableStateOf(false) }
    var hasCleanBackground by remember { mutableStateOf(false) }
    var hasStableSurface by remember { mutableStateOf(false) }
    
    Text(
        text = "Evalúa tu espacio de grabación",
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(16.dp))
    
    ChecklistItem(
        label = "Tengo buena iluminación (ventana o luz artificial)",
        checked = hasGoodLighting,
        onCheckedChange = { hasGoodLighting = it }
    )
    ChecklistItem(
        label = "El espacio es silencioso o puedo controlar el ruido",
        checked = hasQuietSpace,
        onCheckedChange = { hasQuietSpace = it }
    )
    ChecklistItem(
        label = "El fondo está limpio y organizado",
        checked = hasCleanBackground,
        onCheckedChange = { hasCleanBackground = it }
    )
    ChecklistItem(
        label = "Tengo una superficie estable para el celular/cámara",
        checked = hasStableSurface,
        onCheckedChange = { hasStableSurface = it }
    )
    
    Spacer(modifier = Modifier.height(16.dp))
    
    val score = listOf(hasGoodLighting, hasQuietSpace, hasCleanBackground, hasStableSurface).count { it }
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = when (score) {
                4 -> MaterialTheme.colorScheme.primaryContainer
                3 -> MaterialTheme.colorScheme.secondaryContainer
                else -> MaterialTheme.colorScheme.errorContainer
            }
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Tu puntuación: $score/4",
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = when (score) {
                    4 -> "¡Excelente! Tu espacio está listo para grabar."
                    3 -> "¡Muy bien! Solo necesitas mejorar un poco."
                    else -> "Necesitas preparar mejor tu espacio antes de grabar."
                },
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
fun ChecklistItem(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Text(
            text = label,
            modifier = Modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun ScheduleContent() {
    Text(
        text = "Horarios óptimos para publicar en Honduras:",
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(16.dp))
    
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "ENTRE SEMANA",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("🌅 6:00 PM - 8:00 PM (Prime time)")
            Text("🍽️ 12:00 PM - 1:00 PM (Hora del almuerzo)")
        }
    }
    
    Spacer(modifier = Modifier.height(8.dp))
    
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "FINES DE SEMANA",
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("☀️ Sábado 9:00 AM - 11:00 AM")
            Text("🌙 Domingo 7:00 PM - 9:00 PM")
        }
    }
    
    Spacer(modifier = Modifier.height(16.dp))
    
    Text(
        text = "💡 Nota: Publicar a las 6 PM hora de Honduras = 7-9 PM hora USA (buena cobertura para Hondureños en USA)",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
    )
}

@Composable
fun RemindersContent() {
    var reminderTime by remember { mutableStateOf("") }
    var reminderDays by remember { mutableStateOf(listOf<String>()) }
    val days = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    
    Text(
        text = "Configura recordatorios para grabar:",
        style = MaterialTheme.typography.titleMedium
    )
    Spacer(modifier = Modifier.height(16.dp))
    
    Text(
        text = "Selecciona los días:",
        style = MaterialTheme.typography.bodyMedium
    )
    Spacer(modifier = Modifier.height(8.dp))
    
    days.forEach { day ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = reminderDays.contains(day),
                onCheckedChange = { checked ->
                    reminderDays = if (checked) {
                        reminderDays + day
                    } else {
                        reminderDays - day
                    }
                }
            )
            Text(text = day, modifier = Modifier.padding(start = 8.dp))
        }
    }
    
    Spacer(modifier = Modifier.height(16.dp))
    
    if (reminderDays.isNotEmpty()) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "✅ Recordatorio configurado",
                    style = MaterialTheme.typography.titleSmall
                )
                Text(
                    text = "Días: ${reminderDays.joinToString(", ")}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "En la versión completa, recibirás notificaciones push.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
