package com.youtuberhn.ui.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.youtuberhn.ui.screens.HomeScreen
import com.youtuberhn.ui.screens.ChaptersScreen
import com.youtuberhn.ui.screens.ChapterDetailScreen
import com.youtuberhn.ui.screens.ActionsScreen
import com.youtuberhn.ui.screens.ActionDetailScreen
import com.youtuberhn.ui.screens.ToolsScreen
import com.youtuberhn.ui.screens.ToolDetailScreen
import com.youtuberhn.ui.screens.ExtrasScreen
import com.youtuberhn.ui.screens.CameraScreen
import com.youtuberhn.ui.screens.LandingScreen

// Routes that should show the drawer
val drawerRoutes = setOf("home", "chapters", "actions", "tools", "extras", "camera")

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    
    // Determine if we should show drawer (hide on detail screens and landing)
    val showDrawer = currentRoute in drawerRoutes
    
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    
    if (showDrawer) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent(
                    navController = navController,
                    onCloseDrawer = { 
                        // Use run to execute suspend function in coroutine scope
                    }
                )
            }
        ) {
            Scaffold(
                topBar = {
                    if (showDrawer) {
                        TopAppBar(
                            title = {
                                Text(
                                    text = when (currentRoute) {
                                        "home" -> "🏠 Inicio"
                                        "chapters" -> "📖 Capítulos"
                                        "actions" -> "🎯 Acciones"
                                        "tools" -> "🔧 Herramientas"
                                        "extras" -> "✨ Extras"
                                        "camera" -> "🎬 Grabar"
                                        else -> "YoutuberHN"
                                    }
                                )
                            },
                            navigationIcon = {
                                IconButton(onClick = { 
                                    // Open drawer - handle suspend function properly
                                }) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Menú"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                            )
                        )
                    }
                }
            ) { paddingValues ->
                NavigationContent(
                    navController = navController,
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    } else {
        // No drawer for detail screens
        NavigationContent(
            navController = navController,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
private fun NavigationContent(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "landing",
        modifier = modifier
    ) {
        composable("landing") {
            LandingScreen(navController)
        }
        
        composable("home") {
            HomeScreen(navController)
        }
        
        composable("chapters") {
            ChaptersScreen(navController)
        }
        
        composable(
            route = "chapter/{chapterId}",
            arguments = listOf(navArgument("chapterId") { type = NavType.StringType })
        ) { backStackEntry ->
            val chapterId = backStackEntry.arguments?.getString("chapterId") ?: ""
            ChapterDetailScreen(navController, chapterId)
        }
        
        composable("actions") {
            ActionsScreen(navController)
        }
        
        composable(
            route = "action/{actionType}",
            arguments = listOf(navArgument("actionType") { type = NavType.StringType })
        ) { backStackEntry ->
            val actionType = backStackEntry.arguments?.getString("actionType") ?: ""
            ActionDetailScreen(navController, actionType)
        }
        
        composable("tools") {
            ToolsScreen(navController)
        }
        
        composable(
            route = "tool/{toolId}",
            arguments = listOf(navArgument("toolId") { type = NavType.StringType })
        ) { backStackEntry ->
            val toolId = backStackEntry.arguments?.getString("toolId") ?: ""
            ToolDetailScreen(navController, toolId)
        }
        
        composable("extras") {
            ExtrasScreen(navController)
        }
        
        composable("camera") {
            CameraScreen(navController)
        }
    }
}
