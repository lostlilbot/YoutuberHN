package com.youtuberhn.ui.screens

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.*
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.navigation.NavHostController
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.Executor

@Composable
fun CameraScreen(navController: NavHostController) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    
    var hasCameraPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == 
            PackageManager.PERMISSION_GRANTED
        )
    }
    
    var hasAudioPermission by remember {
        mutableStateOf(
            ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) == 
            PackageManager.PERMISSION_GRANTED
        )
    }
    
    var isRecording by remember { mutableStateOf(false) }
    var recording: Recording? by remember { mutableStateOf(null) }
    var useFrontCamera by remember { mutableStateOf(false) }
    var videoCapture: VideoCapture<Recorder>? by remember { mutableStateOf(null) }
    var recordingStarted by remember { mutableStateOf(false) }
    
    // Video gallery state
    var showGallery by remember { mutableStateOf(false) }
    var savedVideos by remember { mutableStateOf<List<File>>(emptyList()) }
    var selectedVideo by remember { mutableStateOf<File?>(null) }
    var showVideoPlayer by remember { mutableStateOf(false) }
    var showDeleteDialog by remember { mutableStateOf(false) }
    var videoToDelete by remember { mutableStateOf<File?>(null) }
    
    // Last saved video path
    var lastSavedVideoPath by remember { mutableStateOf<String?>(null) }
    
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasCameraPermission = permissions[Manifest.permission.CAMERA] == true
        hasAudioPermission = permissions[Manifest.permission.RECORD_AUDIO] == true
    }
    
    // Function to load saved videos
    fun loadSavedVideos() {
        val videosDir = context.getExternalFilesDir(null)
        videosDir?.let { dir ->
            val videos = dir.listFiles { file ->
                file.isFile && file.name.endsWith(".mp4")
            }?.sortedByDescending { it.lastModified() } ?: emptyList()
            savedVideos = videos
        }
    }
    
    LaunchedEffect(Unit) {
        if (!hasCameraPermission || !hasAudioPermission) {
            permissionLauncher.launch(
                arrayOf(
                    Manifest.permission.CAMERA,
                    Manifest.permission.RECORD_AUDIO
                )
            )
        }
        loadSavedVideos()
    }
    
    // Gallery Dialog
    if (showGallery) {
        AlertDialog(
            onDismissRequest = { showGallery = false },
            title = { Text("Mis Videos") },
            text = {
                if (savedVideos.isEmpty()) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "🎬",
                            style = MaterialTheme.typography.displayLarge,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("No hay videos guardados")
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        items(savedVideos) { video ->
                            VideoListItem(
                                video = video,
                                onPlay = {
                                    selectedVideo = video
                                    showVideoPlayer = true
                                },
                                onDelete = {
                                    videoToDelete = video
                                    showDeleteDialog = true
                                }
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showGallery = false }) {
                    Text("Cerrar")
                }
            }
        )
    }
    
    // Video Player Dialog
    if (showVideoPlayer && selectedVideo != null) {
        AlertDialog(
            onDismissRequest = { showVideoPlayer = false },
            title = { Text(selectedVideo!!.name) },
            text = {
                VideoPlayerView(
                    videoFile = selectedVideo!!,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9f)
                )
            },
            confirmButton = {
                TextButton(onClick = { showVideoPlayer = false }) {
                    Text("Cerrar")
                }
            }
        )
    }
    
    // Delete Confirmation Dialog
    if (showDeleteDialog && videoToDelete != null) {
        AlertDialog(
            onDismissRequest = { 
                showDeleteDialog = false
                videoToDelete = null
            },
            title = { Text("Eliminar Video") },
            text = { Text("¿Estás seguro de que quieres eliminar este video?") },
            confirmButton = {
                TextButton(
                    onClick = {
                        videoToDelete?.let { video ->
                            if (video.delete()) {
                                loadSavedVideos()
                            }
                        }
                        showDeleteDialog = false
                        videoToDelete = null
                    },
                    colors = ButtonDefaults.textButtonColors(
                        contentColor = MaterialTheme.colorScheme.error
                    )
                ) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                TextButton(onClick = { 
                    showDeleteDialog = false
                    videoToDelete = null
                }) {
                    Text("Cancelar")
                }
            }
        )
    }
    
    Column(modifier = Modifier.fillMaxSize()) {
        // Top bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
            Text(
                text = if (isRecording) "Grabando..." else "Cámara",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )
            IconButton(onClick = { useFrontCamera = !useFrontCamera }) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Cambiar cámara",
                    tint = Color.White
                )
            }
        }
        
        // Camera preview
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            if (hasCameraPermission && hasAudioPermission) {
                AndroidView(
                    factory = { ctx ->
                        val previewView = PreviewView(ctx)
                        val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
                        
                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()
                            
                            val preview = Preview.Builder().build().also {
                                it.setSurfaceProvider(previewView.surfaceProvider)
                            }
                            
                            val recorder = Recorder.Builder()
                                .setQualitySelector(QualitySelector.from(Quality.HD))
                                .build()
                            
                            videoCapture = VideoCapture.withOutput(recorder)
                            
                            val cameraSelector = if (useFrontCamera) {
                                CameraSelector.DEFAULT_FRONT_CAMERA
                            } else {
                                CameraSelector.DEFAULT_BACK_CAMERA
                            }
                            
                            try {
                                cameraProvider.unbindAll()
                                cameraProvider.bindToLifecycle(
                                    lifecycleOwner,
                                    cameraSelector,
                                    preview,
                                    videoCapture
                                )
                            } catch (e: Exception) {
                                Log.e("CameraScreen", "Camera binding failed", e)
                            }
                        }, ContextCompat.getMainExecutor(ctx))
                        
                        previewView
                    },
                    modifier = Modifier.fillMaxSize(),
                    update = { previewView ->
                        val cameraProviderFuture = ProcessCameraProvider.getInstance(context)
                        cameraProviderFuture.addListener({
                            val cameraProvider = cameraProviderFuture.get()
                            
                            val preview = Preview.Builder().build().also {
                                it.setSurfaceProvider(previewView.surfaceProvider)
                            }
                            
                            val recorder = Recorder.Builder()
                                .setQualitySelector(QualitySelector.from(Quality.HD))
                                .build()
                            
                            videoCapture = VideoCapture.withOutput(recorder)
                            
                            val cameraSelector = if (useFrontCamera) {
                                CameraSelector.DEFAULT_FRONT_CAMERA
                            } else {
                                CameraSelector.DEFAULT_BACK_CAMERA
                            }
                            
                            try {
                                cameraProvider.unbindAll()
                                cameraProvider.bindToLifecycle(
                                    lifecycleOwner,
                                    cameraSelector,
                                    preview,
                                    videoCapture
                                )
                            } catch (e: Exception) {
                                Log.e("CameraScreen", "Camera binding failed", e)
                            }
                        }, ContextCompat.getMainExecutor(context))
                    }
                )
            } else {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "📹",
                        style = MaterialTheme.typography.displayLarge,
                        modifier = Modifier.size(64.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Se requieren permisos de cámara",
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        permissionLauncher.launch(
                            arrayOf(
                                Manifest.permission.CAMERA,
                                Manifest.permission.RECORD_AUDIO
                            )
                        )
                    }) {
                        Text("Otorgar permisos")
                    }
                }
            }
            
            // Recording indicator
            if (isRecording) {
                Row(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(16.dp)
                        .background(Color.Red, CircleShape)
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .background(Color.White, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "REC",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
        
        // Controls
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(24.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Gallery button
            IconButton(
                onClick = { 
                    loadSavedVideos()
                    showGallery = true
                }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🎬",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        text = "Mis Videos",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
            
            // Record button
            IconButton(
                onClick = {
                    if (isRecording) {
                        // Stop recording
                        recording?.stop()
                        isRecording = false
                        recordingStarted = false
                    } else {
                        // Start recording
                        videoCapture?.let { vc ->
                            val name = SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS", Locale.US)
                                .format(System.currentTimeMillis())
                            val videoFile = File(
                                context.getExternalFilesDir(null),
                                "YoutuberHN_$name.mp4"
                            )
                            
                            val outputOptions = FileOutputOptions.Builder(videoFile).build()
                            
                            recording = vc.output
                                .prepareRecording(context, outputOptions)
                                .apply {
                                    if (hasAudioPermission) {
                                        withAudioEnabled()
                                    }
                                }
                                .start(ContextCompat.getMainExecutor(context)) { recordEvent ->
                                    when (recordEvent) {
                                        is VideoRecordEvent.Start -> {
                                            isRecording = true
                                            recordingStarted = true
                                        }
                                        is VideoRecordEvent.Finalize -> {
                                            if (!recordEvent.hasError()) {
                                                lastSavedVideoPath = recordEvent.outputResults.outputUri.toString()
                                                Log.d("CameraScreen", "Video saved: ${recordEvent.outputResults.outputUri}")
                                                // Reload videos after saving
                                                loadSavedVideos()
                                            } else {
                                                Log.e("CameraScreen", "Recording error: ${recordEvent.error}")
                                            }
                                        }
                                    }
                                }
                        }
                    }
                },
                modifier = Modifier
                    .size(72.dp)
                    .background(
                        if (isRecording) Color.Red else Color.White,
                        CircleShape
                    )
            ) {
                if (isRecording) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Detener",
                        tint = Color.White,
                        modifier = Modifier.size(36.dp)
                    )
                } else {
                    Box(
                        modifier = Modifier
                            .size(56.dp)
                            .background(Color.Red, CircleShape)
                    )
                }
            }
            
            // Switch camera button
            IconButton(
                onClick = { useFrontCamera = !useFrontCamera }
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "🔄",
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.size(28.dp)
                    )
                    Text(
                        text = "Cambiar",
                        color = Color.White,
                        style = MaterialTheme.typography.labelSmall
                    )
                }
            }
        }
    }
}

@Composable
private fun VideoListItem(
    video: File,
    onPlay: () -> Unit,
    onDelete: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = video.name,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${formatFileSize(video.length())} • ${dateFormat.format(Date(video.lastModified()))}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Row {
                IconButton(onClick = onPlay) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Reproducir",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                IconButton(onClick = onDelete) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar",
                        tint = MaterialTheme.colorScheme.error
                    )
                }
            }
        }
    }
}

@Composable
private fun VideoPlayerView(
    videoFile: File,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    AndroidView(
        factory = { ctx ->
            VideoView(ctx).apply {
                val uri = Uri.fromFile(videoFile)
                setVideoURI(uri)
                
                val mediaController = MediaController(ctx)
                mediaController.setAnchorView(this)
                setMediaController(mediaController)
                
                setOnPreparedListener { mp ->
                    mp.isLooping = false
                    start()
                }
                
                setOnErrorListener { _, _, _ ->
                    true
                }
            }
        },
        modifier = modifier,
        update = { videoView ->
            val uri = Uri.fromFile(videoFile)
            videoView.setVideoURI(uri)
            videoView.start()
        }
    )
}

private fun formatFileSize(bytes: Long): String {
    return when {
        bytes < 1024 -> "$bytes B"
        bytes < 1024 * 1024 -> "${bytes / 1024} KB"
        else -> String.format("%.1f MB", bytes / (1024.0 * 1024.0))
    }
}
