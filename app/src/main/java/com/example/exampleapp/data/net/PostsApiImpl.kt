package com.example.exampleapp.data.net

import com.example.exampleapp.data.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PostsApiImpl(
    private val client: HttpClientProvider
) : PostApi {
    override suspend fun getPosts(): List<PostResponse> {
        return client.getHttpClient().get("posts")
    }
}