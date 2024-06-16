package org.company.app.features.login.models

data class LoginViewState(
    val ipAddressValue: String = "",
    val apiPortValue: String = "",
    val loginValue: String = "",
    val passwordValue: String = "",
    val isSending: Boolean = false
)