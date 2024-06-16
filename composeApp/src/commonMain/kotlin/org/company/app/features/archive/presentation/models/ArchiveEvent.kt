package org.company.app.features.archive.presentation.models

sealed class ArchiveEvent {
    class TabSelected(val selectedIndex: Int) : ArchiveEvent()
} 