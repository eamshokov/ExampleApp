package com.example.exampleapp.domain.repository

import com.example.exampleapp.domain.dto.Post

interface PostsRepository {
    suspend fun getPost():List<Post>
}