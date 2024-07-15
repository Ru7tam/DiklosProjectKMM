package org.company.app.features.login.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import org.company.app.features.login.models.LoginAction
import org.company.app.navigation.AppScreens
import org.company.app.navigation.LocalNavHost

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel { LoginViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by loginViewModel.viewStates().collectAsState()
    val viewAction by loginViewModel.viewActions().collectAsState(null)

    LoginView(viewState = viewState) { event ->
        loginViewModel.obtainEvent(event)
    }

    when (viewAction) {
        LoginAction.OpenMainScreen -> {
            externalNavHost.navigate(AppScreens.Home.title)
            loginViewModel.clearAction()
        }

        null -> {}
    }
}