package org.company.app.features.login.models

sealed class LoginEvent {
    data class IpAddressChanged(val newValue: String) : LoginEvent()
    data class ApiPortChanged(val newValue: String) : LoginEvent()
    data class LoginChanged(val newValue: String) : LoginEvent()
    data class PasswordChanged(val newValue: String) : LoginEvent()
    data object LoginClicked : LoginEvent()
    data object SignUpClicked : LoginEvent()
    data object ErrorDismissed : LoginEvent()
}
