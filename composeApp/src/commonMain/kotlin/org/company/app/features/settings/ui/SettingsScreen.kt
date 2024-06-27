package org.company.app.features.settings.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.company.app.features.addcamera.ui.AddCameraScreen
import org.company.app.features.addserver.ui.AddServerScreen
import org.company.app.features.arguspro.ui.ArgusProScreen
import org.company.app.features.cameralist.ui.CameraListScreen
import org.company.app.features.roles.ui.RolesScreen
import org.company.app.features.serverlist.ui.ServerListScreen
import org.company.app.features.settings.models.SettingsAction
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = viewModel { SettingsViewModel() }
) {
    val navController = rememberNavController() // Создаем NavController
    val externalNavHost = LocalNavHost.current
    val viewState by settingsViewModel.viewStates().collectAsState()
    val viewAction by settingsViewModel.viewActions().collectAsState(null)

    // Добавляем NavHost и устанавливаем граф навигации
    NavHost(
        navController = navController,
        startDestination = "settings"
    ) {
        composable("settings") {
            SettingsView(viewState = viewState, eventHandler = { event ->
                settingsViewModel.obtainEvent(event)
            }, navController = navController)
        }
        composable(SettingsScreens.Roles.route) { RolesScreen() }
        composable(SettingsScreens.ArgusPro.route) { ArgusProScreen() }
        composable(SettingsScreens.AddCamera.route) { AddCameraScreen() }
        composable(SettingsScreens.CameraList.route) { CameraListScreen() }
        composable(SettingsScreens.AddServer.route) { AddServerScreen() }
        composable(SettingsScreens.ServerList.route) { ServerListScreen() }
    }

    when (viewAction) {
        SettingsAction.OpenMainScreen -> {
            externalNavHost.navigate(AppScreens.Home.title)
            settingsViewModel.clearAction()
        }

        null -> {}
    }
}
