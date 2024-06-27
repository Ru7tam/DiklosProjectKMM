package org.company.app.features.splash.ui

import org.company.app.base.BaseViewModel
import org.company.app.features.login.domain.IsUserAuthorizedUseCase
import org.company.app.features.splash.models.SplashAction

class SplashViewModel(
    private val  isUserAuthorizedUseCase: IsUserAuthorizedUseCase = IsUserAuthorizedUseCase()
):BaseViewModel<Unit, SplashAction, Unit>(
  initialState = Unit  
) {
    
    init {
        checkUserAithorized()
    }

    override fun obtainEvent(viewEvent: Unit) {
        
    }
    
    private fun checkUserAithorized() {
        viewAction = if (isUserAuthorizedUseCase.execute()){
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }

}