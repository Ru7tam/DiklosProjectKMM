package org.company.app.features.settings

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.company.app.features.settings.models.SettingsAction
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost

@Composable
fun SettingsScreen(
    settingsViewModel: SettingsViewModel = viewModel { SettingsViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by settingsViewModel.viewStates().collectAsState()
    val viewAction by settingsViewModel.viewActions().collectAsState(null)
    
    SettingsView(viewState = viewState) { event ->
        settingsViewModel.obtainEvent(event)
    }
    
    when (viewAction) {
        SettingsAction.OpenMainScreen -> {
            externalNavHost.navigate(AppScreens.Home.title)
            settingsViewModel.clearAction()
        }
        null -> { }
    }
}