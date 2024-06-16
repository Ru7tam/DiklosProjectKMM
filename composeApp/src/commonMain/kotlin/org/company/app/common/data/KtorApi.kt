package org.company.app.common.data

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

private const val BASE_URL = "http://192.168.1.105:5005/"

internal abstract class KtorApi {
    
    val client = HttpClient {
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
                useAlternativeNames = false
            })
        }
    }
    
    fun HttpRequestBuilder.endpoint(path: String) {
        url {
            takeFrom(BASE_URL)
            path(path)
            contentType(ContentType.Application.Json)
        }
    }
    
}