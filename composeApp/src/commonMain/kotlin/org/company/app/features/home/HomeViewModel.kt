package org.company.app.features.home

import org.company.app.base.BaseViewModel
import org.company.app.features.home.models.HomeAction
import org.company.app.features.home.models.HomeEvent
import org.company.app.features.home.models.HomeViewState

class FeedViewModel : BaseViewModel<HomeViewState, HomeAction, HomeEvent>(initialState = HomeViewState()){
    
    override fun obtainEvent(viewEvent: HomeEvent) {
        
    }

}