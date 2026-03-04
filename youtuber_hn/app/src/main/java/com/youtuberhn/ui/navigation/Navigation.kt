package com.youtuberhn.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
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
