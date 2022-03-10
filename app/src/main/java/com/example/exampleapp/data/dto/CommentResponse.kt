package com.example.exampleapp.data.dto

data class CommentResponse(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)

