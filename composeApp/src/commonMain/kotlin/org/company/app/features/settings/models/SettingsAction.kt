package org.company.app.features.settings.models

sealed class SettingsAction {
    data object OpenMainScreen : SettingsAction()
}