package com.youtuberhn.ui.screens

import android.Manifest
import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.video.*
import androidx.camera.view.PreviewView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
    
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        hasCameraPermission = permissions[Manifest.permission.CAMERA] == true
        hasAudioPermission = permissions[Manifest.permission.RECORD_AUDIO] == true
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
                    imageVector = Icons.Default.Cameraswitch,
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
                    Icon(
                        imageVector = Icons.Default.CameraAlt,
                        contentDescription = null,
                        tint = Color.White,
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
            // Gallery button (placeholder)
            IconButton(
                onClick = { /* Open gallery */ }
            ) {
                Icon(
                    imageVector = Icons.Default.PhotoLibrary,
                    contentDescription = "Galería",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
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
                                                Log.d("CameraScreen", "Video saved: ${recordEvent.outputResults.outputUri}")
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
                        imageVector = Icons.Default.Stop,
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
                Icon(
                    imageVector = Icons.Default.FlipCameraAndroid,
                    contentDescription = "Cambiar cámara",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}
