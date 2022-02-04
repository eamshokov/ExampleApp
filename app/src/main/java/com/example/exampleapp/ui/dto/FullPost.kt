package com.example.exampleapp.ui.dto

data class FullPost(
    val id:Int,
    val title:String,
    val content:String,
    val authorId:Int,
    val authorEmail:String,
    val authorName:String
)
