package com.example.exampleapp.domain

import com.example.exampleapp.domain.usecases.GetCommentsUseCase
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.domain.usecases.implementation.GetCommentsUseCaseImpl
import com.example.exampleapp.domain.usecases.implementation.GetPostsUseCaseImpl
import org.koin.dsl.module

val domain = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
    factory<GetCommentsUseCase> { GetCommentsUseCaseImpl(get()) }
}