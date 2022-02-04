package com.example.exampleapp.ui.postslist

import com.example.exampleapp.DI
import com.example.exampleapp.domain.usecases.GetPostsUseCase
import com.example.exampleapp.ui.mapper.PostMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PostsListPresenter(
    private val view:PostsListView,
    private val getPostsUseCase: GetPostsUseCase = DI.getGetPostsUseCase(),
    private val postMapper:PostMapper = DI.getMapper()
) {
    suspend fun init(){
        view.showLoading()
        withContext(Dispatchers.IO){
            val posts = getPostsUseCase.getPosts()
            withContext(Dispatchers.Main){
                view.setData(posts.map {
                    postMapper.postToPostListItem(it)
                })
            }
        }
        view.hideLoading()
    }
}