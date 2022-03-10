package com.example.exampleapp.domain.repository


import com.example.exampleapp.domain.dto.PostComment

interface CommentRepository {
    suspend fun getPostComments(postId: Int): List<PostComment>
}