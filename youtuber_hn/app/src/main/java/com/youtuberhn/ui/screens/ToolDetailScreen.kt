package com.youtuberhn.ui.screens

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.youtuberhn.ReminderBroadcastReceiver
import java.util.*

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
            Divider(modifier = Modifier.padding(horizontal = 16.dp))
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
    var reminderTime by remember { mutableStateOf("08:00") }
    var reminderDays by remember { mutableStateOf(setOf<String>()) }
    var isNotificationPermissionGranted by remember { mutableStateOf(false) }
    var showPermissionDialog by remember { mutableStateOf(false) }
    
    val context = LocalContext.current
    val days = listOf(
        "Lunes" to Calendar.MONDAY,
        "Martes" to Calendar.TUESDAY,
        "Miércoles" to Calendar.WEDNESDAY,
        "Jueves" to Calendar.THURSDAY,
        "Viernes" to Calendar.FRIDAY,
        "Sábado" to Calendar.SATURDAY,
        "Domingo" to Calendar.SUNDAY
    )
    
    // Check notification permission
    LaunchedEffect(Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            isNotificationPermissionGranted = context.checkSelfPermission(
                android.Manifest.permission.POST_NOTIFICATIONS
            ) == android.content.pm.PackageManager.PERMISSION_GRANTED
        } else {
            isNotificationPermissionGranted = true
        }
    }
    
    // Function to schedule notifications
    fun scheduleReminders() {
        if (!isNotificationPermissionGranted) {
            showPermissionDialog = true
            return
        }
        
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        
        // Schedule for each selected day
        reminderDays.forEach { dayName ->
            val calendar = Calendar.getInstance().apply {
                val dayOfWeek = days.find { it.first == dayName }?.second ?: return@forEach
                set(Calendar.DAY_OF_WEEK, dayOfWeek)
                
                // Parse time
                val timeParts = reminderTime.split(":")
                set(Calendar.HOUR_OF_DAY, timeParts[0].toInt())
                set(Calendar.MINUTE, timeParts[1].toInt())
                set(Calendar.SECOND, 0)
                
                // If time has passed this week, schedule for next week
                if (timeInMillis <= System.currentTimeMillis()) {
                    add(Calendar.WEEK_OF_YEAR, 1)
                }
            }
            
            val intent = Intent(context, ReminderBroadcastReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(
                context,
                dayName.hashCode(),
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        pendingIntent
                    )
                } else {
                    alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.timeInMillis,
                        pendingIntent
                    )
                }
            } catch (e: SecurityException) {
                // Handle case where exact alarm permission is not granted
            }
        }
    }
    
    // Permission dialog
    if (showPermissionDialog) {
        AlertDialog(
            onDismissRequest = { showPermissionDialog = false },
            title = { Text("Permiso de Notificaciones") },
            text = { Text("Para recibir recordatorios, por favor permite las notificaciones en la configuración.") },
            confirmButton = {
                TextButton(onClick = {
                    showPermissionDialog = false
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                        val intent = Intent(Settings.ACTION_APP_NOTIFICATION_SETTINGS).apply {
                            putExtra(Settings.EXTRA_APP_PACKAGE, context.packageName)
                        }
                        context.startActivity(intent)
                    }
                }) {
                    Text("Abrir Configuración")
                }
            },
            dismissButton = {
                TextButton(onClick = { showPermissionDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        // Header with icon
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🔔",
                    style = MaterialTheme.typography.displaySmall
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Recordatorios de Grabación",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "No olvides crear tu contenido diario",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Selecciona la hora:",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        // Time picker button
        OutlinedButton(
            onClick = {
                val timeParts = reminderTime.split(":")
                val hour = timeParts[0].toInt()
                val minute = timeParts[1].toInt()
                
                TimePickerDialog(
                    context,
                    { _, selectedHour, selectedMinute ->
                        reminderTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                    },
                    hour,
                    minute,
                    true
                ).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("🕐 Hora: $reminderTime")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Selecciona los días:",
            style = MaterialTheme.typography.titleSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        
        days.forEach { (dayName, _) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = reminderDays.contains(dayName),
                    onCheckedChange = { checked ->
                        reminderDays = if (checked) {
                            reminderDays + dayName
                        } else {
                            reminderDays - dayName
                        }
                        if (checked && reminderDays.size == 1) {
                            scheduleReminders()
                        }
                    }
                )
                Text(text = dayName, modifier = Modifier.padding(start = 8.dp))
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Active reminders display
        if (reminderDays.isNotEmpty()) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.tertiaryContainer
                )
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "✅",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Recordatorios Activos",
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Días: ${reminderDays.sortedBy { days.indexOfFirst { d -> d.first == it } }.joinToString(", ")}",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "Hora: $reminderTime",
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "🎬 Te notificaremos cuando sea hora de grabar tu video!",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.8f)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            // Save button
            Button(
                onClick = { scheduleReminders() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("💾 Guardar Recordatorios")
            }
            
            Spacer(modifier = Modifier.height(8.dp))
            
            // Clear button
            OutlinedButton(
                onClick = {
                    reminderDays = emptySet()
                    val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
                    reminderDays.forEach { dayName ->
                        val intent = Intent(context, ReminderBroadcastReceiver::class.java)
                        val pendingIntent = PendingIntent.getBroadcast(
                            context,
                            dayName.hashCode(),
                            intent,
                            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                        )
                        alarmManager.cancel(pendingIntent)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("🗑️ Eliminar Recordatorios")
            }
        } else {
            // Empty state
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "📅",
                        style = MaterialTheme.typography.displayMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "No hay recordatorios configurados",
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        text = "Selecciona los días de la semana para recibir notificaciones",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
        
        Spacer(modifier = Modifier.height(24.dp))
        
        // Tips section
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "💡 Tips para ser consistente",
                    style = MaterialTheme.typography.titleSmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "• Graba varios videos en un día para tener stockpile",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "• Establece un horario fijo de grabación",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = "• Trata la grabación como una cita importante",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
