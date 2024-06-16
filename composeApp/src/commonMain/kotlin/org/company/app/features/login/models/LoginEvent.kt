package org.company.app.features.login.models

sealed class LoginEvent {
    class IpAddressChanged(val newValue: String) : LoginEvent()
    class ApiPortChanged(val newValue: String) : LoginEvent()
    class LoginChanged(val newValue: String) : LoginEvent()
    class PasswordChanged(val newValue: String) : LoginEvent()
    data object SignUpClicked : LoginEvent()
    data object LoginClicked : LoginEvent()
}