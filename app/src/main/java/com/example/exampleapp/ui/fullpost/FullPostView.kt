package com.example.exampleapp.ui.fullpost

import com.example.exampleapp.ui.dto.FullPostItem

interface FullPostView {
    fun showLoading()
    fun hideLoading()
    fun setData(post:FullPostItem)
}