package com.example.exampleapp.data

import com.example.exampleapp.DI
import com.example.exampleapp.data.mappers.PostResponseMapper
import com.example.exampleapp.data.net.PostApi
import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostsRepository

class PostsRepositoryImpl(
    private val postApi: PostApi = DI.getPostsApi(),
    private val postResponseMapper: PostResponseMapper = DI.getPostResponseMapper()
) : PostsRepository {

    // public PostsRepositoryImpl(postsApi = DI.getPostsApi())

    override suspend fun getPost(): List<Post> {
        //get data
        //save to db
        // return data from db
        return postApi.getPosts().map { postResponseMapper.postResponseToPost(it) }
    }
}