package com.example.exampleapp.ui.mapper

import com.example.exampleapp.domain.dto.FullPost
import com.example.exampleapp.domain.dto.PostComment
import com.example.exampleapp.ui.dto.CommentItem
import com.example.exampleapp.ui.dto.FullPostItem

fun PostComment.postCommentToPostListItem() = CommentItem(id, postId, name, email, body)
fun FullPost.postFullToListItem() = FullPostItem(userId,id,title, body)