package com.example.exampleapp.ui

import com.example.exampleapp.ui.mapper.PostMapper
import com.example.exampleapp.ui.mapper.PostMapperImpl
import com.example.exampleapp.ui.viewModel.CommentViewModel
import com.example.exampleapp.ui.viewModel.PostsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentation = module {
    factory<PostMapper> { PostMapperImpl() }

    viewModel { PostsViewModel(get(), get()) }
    viewModel{CommentViewModel(get())}
}