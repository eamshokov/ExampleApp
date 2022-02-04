package com.example.exampleapp.domain.usecases.implementation

import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostsRepository
import com.example.exampleapp.domain.usecases.GetPostsUseCase

class GetPostsUseCaseImpl(
    private val postsRepository: PostsRepository
): GetPostsUseCase {
    override suspend fun getPosts(): List<Post> {
        return postsRepository.getPost()
    }
}