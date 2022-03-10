package com.example.exampleapp.domain.dto

data class PostComment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)