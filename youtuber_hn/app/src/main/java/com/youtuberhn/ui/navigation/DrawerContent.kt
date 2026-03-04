package com.youtuberhn.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

data class DrawerItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
    val gradientColors: List<Color> = listOf(Color(0xFF6366F1), Color(0xFF8B5CF6))
)

@Composable
fun DrawerContent(
    navController: NavHostController,
    onCloseDrawer: () -> Unit
) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    
    val drawerItems = listOf(
        DrawerItem("🏠 Inicio", Icons.Default.Home, "home", listOf(Color(0xFFFF0000), Color(0xFFFF6B6B))),
        DrawerItem("📖 Capítulos", Icons.Default.List, "chapters", listOf(Color(0xFF2196F3), Color(0xFF64B5F6))),
        DrawerItem("🎯 Acciones", Icons.Default.CheckCircle, "actions", listOf(Color(0xFF4CAF50), Color(0xFF81C784))),
        DrawerItem("🔧 Herramientas", Icons.Default.Settings, "tools", listOf(Color(0xFFFF9800), Color(0xFFFFB74D))),
        DrawerItem("✨ Extras", Icons.Default.Star, "extras", listOf(Color(0xFF9C27B0), Color(0xFFBA68C8))),
        DrawerItem("🎬 Grabar", Icons.Default.PlayArrow, "camera", listOf(Color(0xFFE91E63), Color(0xFFF06292)))
    )
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1A1A1A))
    ) {
        // Header with gradient
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFFF0000),
                            Color(0xFFFF6B6B),
                            Color(0xFFFF8E53)
                        )
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Text(
                    text = "🎬",
                    style = MaterialTheme.typography.displayMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "De Cero a Youtuber",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = "en Honduras 🇭🇳",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        // Drawer items
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(drawerItems) { item ->
                DrawerItemRow(
                    item = item,
                    isSelected = currentRoute == item.route,
                    onClick = {
                        // Navigate if not already on this route
                        if (currentRoute != item.route) {
                            navController.navigate(item.route) {
                                popUpTo("home") { inclusive = false }
                                launchSingleTop = true
                            }
                        }
                        onCloseDrawer()
                    }
                )
            }
            
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Divider(color = Color.White.copy(alpha = 0.2f))
                Spacer(modifier = Modifier.height(8.dp))
                
                // Footer
                Text(
                    text = "Versión 1.2.0",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.5f),
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun DrawerItemRow(
    item: DrawerItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backgroundColor = if (isSelected) {
        Brush.horizontalGradient(item.gradientColors)
    } else {
        null
    }
    
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) Color.Transparent else Color.Transparent
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .then(
                    if (backgroundColor != null) {
                        Modifier.background(backgroundColor)
                    } else {
                        Modifier.background(Color.Transparent)
                    }
                )
                .padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                if (isSelected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}
