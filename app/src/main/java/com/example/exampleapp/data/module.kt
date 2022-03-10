package com.example.exampleapp.data
import com.example.exampleapp.data.net.HttpClientProvider
import com.example.exampleapp.data.net.comment.CommentApi
import com.example.exampleapp.data.net.comment.CommentApiImpl
import com.example.exampleapp.data.net.post.PostApi
import com.example.exampleapp.data.net.post.PostsApiImpl
import com.example.exampleapp.data.repository.CommentRepositoryImpl
import com.example.exampleapp.data.repository.PostsRepositoryImpl
import com.example.exampleapp.domain.repository.CommentRepository
import com.example.exampleapp.domain.repository.PostsRepository
import org.koin.dsl.module

val dataModule = module {
    single { ConstantsProvider() }
    single { HttpClientProvider(get()) }
    factory<PostApi> { PostsApiImpl(get()) }
    factory<PostsRepository> { PostsRepositoryImpl(get())}

    factory<CommentApi> { CommentApiImpl(get()) }
    factory<CommentRepository> { CommentRepositoryImpl(get()) }
//    factory<PostResponseMapper> { PostResponseMapperImpl() }
//    factory<PostsRepository> { PostsRepositoryImpl(get(),get()) }
}