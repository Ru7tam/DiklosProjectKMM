package org.company.app.common.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.company.app.features.login.models.AuthResponse

object KtorApi {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun loginUser(
        ipAddress: String,
        apiPort: String,
        deviceId: String,
        login: String,
        password: String
    ): AuthResponse? {
        val requestBody = mapOf(
            "deviceId" to deviceId,
            "login" to login,
            "password" to password
        )

        return try {
            client.post {
                url("http://$ipAddress:$apiPort/api/v1/login/")
                contentType(ContentType.Application.Json)
                setBody(requestBody)
            }.body<AuthResponse>()
        } catch (e: Exception) {
            println("Request failed: ${e.message}")
            null
        }
    }
}
