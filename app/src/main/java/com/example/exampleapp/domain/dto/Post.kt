package com.example.exampleapp.domain.dto

data class Post(
    val id:Int,
    val userId:Int,
    val title:String,
    val content:String
)