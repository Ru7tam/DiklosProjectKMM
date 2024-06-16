package org.company.app.features.archive.presentation.models

data class ArchiveViewState(
    val avatarUrl: String = "",
    val name: String = "",
    val subscribers: String = "",
    val joinedIn: String = "",
    val isSubscribed: Boolean? = null,
    val selectedTabIndex: Int = 0,
    val videos: List<Any> = emptyList(),
    val playlists: List<Any> = emptyList(),
    val about: String = ""
)