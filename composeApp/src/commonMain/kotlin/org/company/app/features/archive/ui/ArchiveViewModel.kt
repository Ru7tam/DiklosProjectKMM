package org.company.app.features.archive.ui

import org.company.app.base.BaseViewModel
import org.company.app.features.archive.presentation.models.ArchiveAction
import org.company.app.features.archive.presentation.models.ArchiveEvent
import org.company.app.features.archive.presentation.models.ArchiveViewState

class ProfileViewModel(
    
): BaseViewModel<ArchiveViewState, ArchiveAction, ArchiveEvent>(initialState = ArchiveViewState()) {
    
    override fun obtainEvent(viewEvent: ArchiveEvent) {
        when (viewEvent) {
            is ArchiveEvent.TabSelected -> viewState = viewState.copy(selectedTabIndex = viewEvent.selectedIndex)
        }
    }

}