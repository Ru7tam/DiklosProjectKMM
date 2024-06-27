package org.company.app.features.login.ui

import org.company.app.base.BaseViewModel
import org.company.app.features.login.models.LoginAction
import org.company.app.features.login.models.LoginEvent
import org.company.app.features.login.models.LoginViewState


class LoginViewModel: BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {
    
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.IpAddressChanged -> viewState = viewState.copy(ipAddressValue = viewEvent.newValue)
            is LoginEvent.ApiPortChanged -> viewState = viewState.copy(apiPortValue = viewEvent.newValue)
            is LoginEvent.LoginChanged -> viewState = viewState.copy(loginValue = viewEvent.newValue)
            is LoginEvent.PasswordChanged -> viewState = viewState.copy(passwordValue = viewEvent.newValue)
            LoginEvent.LoginClicked -> loginClicked()
            LoginEvent.SignUpClicked -> signUpClicked()
        }
    }
    
    private fun loginClicked() {
        viewAction = LoginAction.OpenMainScreen
    }
    
    private fun signUpClicked() {
        
    }
}