package com.example.exampleapp.domain.usecases.implementation

import com.example.exampleapp.domain.dto.Post
import com.example.exampleapp.domain.repository.PostsRepository
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import io.mockk.unmockkStatic
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import java.util.Calendar

class GetPostsUseCaseImplTest {

    @Before
    fun setUp() {

    }

    @Test
    fun getPosts() {

    }
}