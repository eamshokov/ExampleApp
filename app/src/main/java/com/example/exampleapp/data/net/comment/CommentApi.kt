package com.example.exampleapp.data.net.comment

import com.example.exampleapp.data.dto.CommentResponse

interface CommentApi {
    suspend fun getPostComments(postId: Int): List<CommentResponse>
}