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
import com.youtuberhn.ui.screens.ExtrasScreen

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
            route = "chapter/{chapterName}",
            arguments = listOf(navArgument("chapterName") { type = NavType.StringType })
        ) { backStackEntry ->
            val chapterName = backStackEntry.arguments?.getString("chapterName") ?: ""
            ChapterDetailScreen(navController, chapterName)
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
        
        composable("extras") {
            ExtrasScreen(navController)
        }
    }
}
