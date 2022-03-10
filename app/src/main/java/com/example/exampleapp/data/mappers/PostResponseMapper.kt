package com.example.exampleapp.data.mappers


import com.example.exampleapp.data.dto.PostResponse
import com.example.exampleapp.domain.dto.Post

fun PostResponse.toPostResponse() = Post(id,userId,title,body)

