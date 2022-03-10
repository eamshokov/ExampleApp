package com.example.exampleapp.data.repository

import com.example.exampleapp.data.mappers.toPostResponse
import com.example.exampleapp.data.net.post.PostApi
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostsRepository

class PostsRepositoryImpl(
    private val postApi: PostApi) : PostsRepository {
//    override suspend fun getPostComments(): List<PostComment> =
//        postCommentApi.getPostComments().map { it.toPostComment() }

    override suspend fun getPost(): List<Post> =
        postApi.getPosts().map { it.toPostResponse() }
}
