package com.example.exampleapp

import com.example.exampleapp.data.PostsRepositoryImpl
import com.example.exampleapp.data.mappers.PostResponseMapper
import com.example.exampleapp.data.mappers.PostResponseMapperImpl
import com.example.exampleapp.data.net.PostApi
import com.example.exampleapp.data.net.PostsApiImpl
import com.example.exampleapp.domain.repository.PostsRepository
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.domain.usecases.implementation.GetPostsUseCaseImpl
import com.example.exampleapp.ui.mapper.PostMapper
import com.example.exampleapp.ui.mapper.PostMapperImpl
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

object DI {

    const val BASE_URL = "jsonplaceholder.typicode.com"

    fun getMapper():PostMapper = PostMapperImpl()

    fun getPostResponseMapper():PostResponseMapper = PostResponseMapperImpl()

    fun getPostsRepository(): PostsRepository = PostsRepositoryImpl()

    fun getGetPostsUseCase():GetPostsUseCase = GetPostsUseCaseImpl()

    fun getPostsApi():PostApi = PostsApiImpl()

    fun getHttpClient(baseUrl:String = BASE_URL) = HttpClient {
        install(JsonFeature) {
            serializer = GsonSerializer()
        }
        defaultRequest {
            host = baseUrl
            url {
                protocol = URLProtocol.HTTPS
            }
        }
    }
}