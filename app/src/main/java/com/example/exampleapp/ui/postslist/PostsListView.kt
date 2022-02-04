package com.example.exampleapp.ui.postslist

import com.example.exampleapp.ui.dto.PostListItem

interface PostsListView {
    fun showLoading()
    fun hideLoading()
    fun setData(posts:List<PostListItem>)
}