package com.example.exampleapp.data.net.comment

import com.example.exampleapp.data.dto.CommentResponse
import com.example.exampleapp.data.net.HttpClientProvider
import io.ktor.client.request.*

class CommentApiImpl(
    private val client: HttpClientProvider
) : CommentApi {
    override suspend fun getPostComments(postId: Int): List<CommentResponse> {
        return client.getHttpClient().get("comments?postId=${postId}")
    }
}