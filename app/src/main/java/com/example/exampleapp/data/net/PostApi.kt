package com.example.exampleapp.data.net

import com.example.exampleapp.data.dto.PostResponse

interface PostApi {
    suspend fun getPosts(): List<PostResponse>
}