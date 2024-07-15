package org.company.app.features.login.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.company.app.base.BaseViewModel
import org.company.app.common.data.KtorApi
import org.company.app.features.login.models.LoginAction
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState

class LoginViewModel :
    BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {

    private val viewModelScope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.IpAddressChanged -> viewState =
                viewState.copy(ipAddressValue = viewEvent.newValue)

            is LoginEvent.ApiPortChanged -> viewState =
                viewState.copy(apiPortValue = viewEvent.newValue)

            is LoginEvent.LoginChanged -> viewState =
                viewState.copy(loginValue = viewEvent.newValue)

            is LoginEvent.PasswordChanged -> viewState =
                viewState.copy(passwordValue = viewEvent.newValue)

            LoginEvent.LoginClicked -> onLoginButtonClicked(
                deviceId = "32",
                ipAddress = viewState.ipAddressValue,
                apiPort = viewState.apiPortValue,
                login = viewState.loginValue,
                password = viewState.passwordValue
            )

            LoginEvent.ErrorDismissed -> TODO()
            LoginEvent.SignUpClicked -> TODO()
        }
    }

    private fun onLoginButtonClicked(
        deviceId: String,
        ipAddress: String,
        apiPort: String,
        login: String,
        password: String
    ) {
        if (login.isBlank() || password.isBlank()) {
            viewState = viewState.copy(errorMessage = "Login and password cannot be empty")
            return
        }

        viewModelScope.launch {
            val response = KtorApi.loginUser(ipAddress, apiPort, deviceId, login, password)
            println("Login request: deviceId=$deviceId, login=$login, password=$password")
            println("Response: $response")
            if (response != null) {
                println("Login successful: ${response.accessToken}")
                viewAction = LoginAction.OpenMainScreen
            } else {
                viewState = viewState.copy(errorMessage = "Invalid login or password")
                println("Login failed")
            }
        }
    }

}
