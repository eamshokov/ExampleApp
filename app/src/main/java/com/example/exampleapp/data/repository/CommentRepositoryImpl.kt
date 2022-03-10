package com.example.exampleapp.data.repository

//import com.example.exampleapp.data.mappers.CommentResponseMapper
import com.example.exampleapp.data.mappers.toPostComment
import com.example.exampleapp.data.net.comment.CommentApi
import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.domain.repository.CommentRepository

class CommentRepositoryImpl(
    private val postCommentApi: CommentApi
) : CommentRepository {

    override suspend fun getPostComments(postId: Int): List<PostComment> =
        postCommentApi.getPostComments(postId).map { it.toPostComment() }
}