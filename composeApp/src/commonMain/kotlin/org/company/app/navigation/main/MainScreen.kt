package org.company.app.navigation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kmp_project.composeapp.generated.resources.Res
import kmp_project.composeapp.generated.resources.bottom_arcihve
import kmp_project.composeapp.generated.resources.bottom_main
import kmp_project.composeapp.generated.resources.bottom_settings
import org.company.app.features.archive.ui.ArchiveScreen
import org.company.app.features.home.ui.HomeScreen
import org.company.app.features.settings.ui.SettingsScreen
import org.company.app.theme.FamousTheme
import org.jetbrains.compose.resources.stringResource

enum class MainScreens(val route: String) {
    Home("home"),
    Archive("archive"),
    Settings("settings")
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val items = MainScreens.entries.toTypedArray()
    val bottomNavigationHeight = 75.dp

    Box(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController,
            modifier = Modifier.padding(bottom = bottomNavigationHeight).fillMaxHeight(),
            startDestination = MainScreens.Home.route
        ) {
            composable(MainScreens.Home.route) { HomeScreen() }
            composable(MainScreens.Archive.route) { ArchiveScreen() }
            composable(MainScreens.Settings.route) { SettingsScreen() }
        }

        BottomNavigation(
            modifier = Modifier.align(Alignment.BottomStart).fillMaxWidth()
                .height(bottomNavigationHeight),
            backgroundColor = FamousTheme.colors.secondaryBackground
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            items.forEach { screen ->
                val isSelected =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = when (screen) {
                                MainScreens.Home -> Icons.Filled.Home
                                MainScreens.Archive -> Icons.Filled.Info
                                MainScreens.Settings -> Icons.Filled.Settings
                            },

                            contentDescription = screen.route,
                            tint = if (isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor
                        )
                    },
                    label = {
                        Text(
                            modifier = Modifier.padding(top = 16.dp),
                            text = stringResource(
                                when (screen) {
                                    MainScreens.Home -> Res.string.bottom_main
                                    MainScreens.Archive -> Res.string.bottom_arcihve
                                    MainScreens.Settings -> Res.string.bottom_settings
                                }
                            ),

                            color = if (isSelected) FamousTheme.colors.primaryText else FamousTheme.colors.tintColor

                        )
                    },
                    selected = isSelected,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().displayName) {
                                saveState = true
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}