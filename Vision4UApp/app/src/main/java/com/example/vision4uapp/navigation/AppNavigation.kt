package com.example.vision4uapp.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vision4uapp.ui.screens.*

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Vision4U")
    object Map : Screen("map", "Bản đồ & Vị trí")
    object Messages : Screen("messages", "Tin nhắn thoại")
    object Settings : Screen("settings", "Cài đặt")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation(navController: NavHostController) {
    val screens = listOf(
        Screen.Home,
        Screen.Map,
        Screen.Messages,
        Screen.Settings
    )
    
    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                screens.forEach { screen ->
                    NavigationBarItem(
                        selected = currentRoute == screen.route,
                        onClick = {
                            if (currentRoute != screen.route) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.startDestinationId)
                                    launchSingleTop = true
                                }
                            }
                        },
                        label = { Text(screen.title) },
                        icon = { 
                            when (screen) {
                                Screen.Home -> Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Filled.Home,
                                    contentDescription = "Home"
                                )
                                Screen.Map -> Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Filled.Place,
                                    contentDescription = "Map"
                                )
                                Screen.Messages -> Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Filled.Message,
                                    contentDescription = "Messages"
                                )
                                Screen.Settings -> Icon(
                                    imageVector = androidx.compose.material.icons.Icons.Filled.Settings,
                                    contentDescription = "Settings"
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Home.route) { HomeScreen() }
            composable(Screen.Map.route) { MapScreen() }
            composable(Screen.Messages.route) { MessagesScreen() }
            composable(Screen.Settings.route) { SettingsScreen() }
        }
    }
}
