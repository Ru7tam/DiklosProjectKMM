package org.company.app.features.settings

import org.company.app.base.BaseViewModel
import org.company.app.features.settings.models.SettingsAction
import org.company.app.features.settings.models.SettingsViewState
import org.company.app.features.settings.models.SettingsEvent

class SettingsViewModel : BaseViewModel<SettingsViewState, SettingsAction, SettingsEvent>(initialState = SettingsViewState()){
    
    override fun obtainEvent(viewEvent: SettingsEvent) {
        
    }

}