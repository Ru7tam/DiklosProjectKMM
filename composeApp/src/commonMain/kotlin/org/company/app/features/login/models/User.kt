package org.company.app.features.login.models

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(
    val user: User,
    val accessToken: String,
    val refreshToken: String
)

@Serializable
data class User(
    val login: String,
    val normalizedLogin: String,
    val registerTime: String,
    val lastLogin: String,
    val registerIp: String,
    val lastloginIp: String,
    val roleId: Int,
    val roleName: String,
    val isAdmin: Boolean,
    val gridId: Int,
    val id: Int
)
