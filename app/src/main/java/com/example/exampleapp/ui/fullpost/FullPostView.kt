package com.example.exampleapp.ui.fullpost

import com.example.exampleapp.ui.dto.FullPost

interface FullPostView {
    fun showLoading()
    fun hideLoading()
    fun setData(post:FullPost)
}