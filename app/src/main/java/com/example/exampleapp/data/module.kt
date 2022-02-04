package com.example.exampleapp.data

import com.example.exampleapp.data.mappers.PostResponseMapper
import com.example.exampleapp.data.mappers.PostResponseMapperImpl
import com.example.exampleapp.data.net.HttpClientProvider
import com.example.exampleapp.data.net.PostApi
import com.example.exampleapp.data.net.PostsApiImpl
import com.example.exampleapp.domain.repository.PostsRepository
import org.koin.dsl.module

val dataModule = module {
    single { ConstantsProvider() }
    single { HttpClientProvider(get()) }

    factory<PostApi> { PostsApiImpl(get()) }
    factory<PostResponseMapper> { PostResponseMapperImpl() }
    factory<PostsRepository> { PostsRepositoryImpl(get(), get()) }
}