package com.example.exampleapp.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.exampleapp.R
import com.example.exampleapp.databinding.FragmentCommentBinding
import com.example.exampleapp.ui.adapters.CommentAdapter
import com.example.exampleapp.ui.dto.CommentItem
import com.example.exampleapp.ui.viewModel.CommentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentFragment : Fragment(R.layout.fragment_comment) {

    private lateinit var binding: FragmentCommentBinding
    private lateinit var commentsAdapter: CommentAdapter
    private val commentViewModel by viewModel<CommentViewModel>()

    companion object {
        @JvmStatic
        fun newInstance() = CommentFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = requireArguments()
        val postId = args.getInt("postId")
        binding = FragmentCommentBinding.bind(view)
        commentViewModel.init(postId)
        commentViewModel.commentsLoaded.observe(viewLifecycleOwner, ::setComments)
    }

    private fun setComments(list: List<CommentItem>) {
        commentsAdapter = CommentAdapter(list)
        binding.rvPosts.adapter = commentsAdapter
    }

}
