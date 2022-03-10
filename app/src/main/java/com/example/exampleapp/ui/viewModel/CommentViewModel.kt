package com.example.exampleapp.ui.viewModel

import androidx.lifecycle.*
import com.example.exampleapp.domain.usecases.GetCommentsUseCase
import com.example.exampleapp.ui.dto.CommentItem
import com.example.exampleapp.ui.mapper.postCommentToPostListItem
import kotlinx.coroutines.launch

class CommentViewModel(
    private val getPostsCommentsUseCase: GetCommentsUseCase) : ViewModel() {

    private val _commentsLoaded = MutableLiveData<List<CommentItem>>()
    private val _loading = MutableLiveData<Boolean>()
    val commentsLoaded: LiveData<List<CommentItem>> get() = _commentsLoaded
    val loading: LiveData<Boolean> get() = _loading

    fun init(postId: Int) {
        viewModelScope.launch {
            if (_commentsLoaded.value == null) {
                val comments = getPostsCommentsUseCase.getComments(postId)
                    .map { it.postCommentToPostListItem() }
                _commentsLoaded.value = comments
            }
        }
    }

}