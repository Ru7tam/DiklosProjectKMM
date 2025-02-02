package org.company.app


import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import org.company.app.features.addcamera.ui.AddCameraScreen
import org.company.app.features.addserver.ui.AddServerScreen
import org.company.app.features.archive.ui.ArchiveScreen
import org.company.app.features.arguspro.ui.ArgusProScreen
import org.company.app.features.cameralist.ui.CameraListScreen
import org.company.app.features.login.ui.LoginScreen
import org.company.app.features.roles.ui.RolesScreen
import org.company.app.features.serverlist.ui.ServerListScreen
import org.company.app.features.settings.ui.SettingsScreen
import org.company.app.features.splash.ui.SplashScreen
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost
import org.company.app.navigation.main.MainScreen
import org.company.app.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    FamousApp()
}

@Composable
internal fun FamousApp(
    navController: NavHostController = rememberNavController()
) {

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreens.Login.title
        ) {
            composable(route = AppScreens.Splash.title) {
                SplashScreen(navController = navController)
            }

            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }

            composable(route = AppScreens.Home.title) {
                MainScreen()
            }

            composable(route = AppScreens.Archive.title) {
                ArchiveScreen()
            }

            composable(route = AppScreens.Settings.title) {
                SettingsScreen()
            }

            composable(route = AppScreens.Roles.title) {
                RolesScreen()
            }

            composable(route = AppScreens.ArgusPro.title) {
                ArgusProScreen()
            }

            composable(route = AppScreens.AddCamera.title) {
                AddCameraScreen()
            }

            composable(route = AppScreens.CameraList.title) {
                CameraListScreen()
            }

            composable(route = AppScreens.AddServer.title) {
                AddServerScreen()
            }

            composable(route = AppScreens.ServerList.title) {
                ServerListScreen()
            }


        }
    }
}

internal expect fun openUrl(url: String?)