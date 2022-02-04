package com.example.exampleapp.data.net

import com.example.exampleapp.DI
import com.example.exampleapp.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PostsApiImpl(
    private val client: HttpClient = DI.getHttpClient()
) : PostApi {
    override suspend fun getPosts(): List<PostResponse> {
        return client.get("posts")
    }
}