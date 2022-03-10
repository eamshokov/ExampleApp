package com.example.exampleapp.data.mappers

import com.example.exampleapp.data.dto.CommentResponse
import com.example.exampleapp.domain.dto.PostComment

fun CommentResponse.toPostComment() = PostComment(body,email,id,name,postId)
