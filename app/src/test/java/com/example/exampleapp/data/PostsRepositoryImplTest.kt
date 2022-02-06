package com.example.exampleapp.data

import com.example.exampleapp.data.dto.PostResponse
import com.example.exampleapp.data.mappers.PostResponseMapper
import com.example.exampleapp.data.net.PostApi
import com.example.exampleapp.domain.dto.Post
import com.google.common.truth.Truth
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.runBlocking
import org.junit.Test

internal class PostsRepositoryImplTest {

    private val api = mockk<PostApi>()
    private val mapper = mockk<PostResponseMapper>()

    private val repository = PostsRepositoryImpl(api, mapper)
    private val postsResponse = listOf(
        PostResponse(1,1, "title", "content"),
        PostResponse(2,2, "title2", "content2")
    )

    private val posts = listOf(
        Post(1,1, "title", "content"),
        Post(2,2, "title2", "content2")
    )

    @Test
    fun getPosts() {
        every { runBlocking {  api.getPosts() } } returns postsResponse
        every { mapper.postResponseToPost(any()) } returns posts[0]

        val ans = runBlocking {  repository.getPost() }

        Truth.assertThat(ans).isEqualTo(posts)

    }
}