package com.example.exampleapp.ui.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.FragmentPostBinding
import com.example.exampleapp.ui.adapters.PostsAdapter
import com.example.exampleapp.ui.dto.PostListItem
import com.example.exampleapp.ui.viewModel.PostsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostFragment : Fragment(R.layout.fragment_post) {
    private lateinit var binding: FragmentPostBinding
    private lateinit var adapter: PostsAdapter
    private val postsViewModel by viewModel<PostsViewModel>()

    companion object {
        @JvmStatic
        fun newInstance() = PostFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPostBinding.bind(view)
        adapter = PostsAdapter(mutableListOf()) { postId ->
            onPostClick(postId)
        }
        binding.rvPosts.adapter = adapter
        setDecorator()
        initObservers()

        lifecycleScope.launchWhenCreated {
            postsViewModel.init()
        }
    }

    private fun initObservers() {
        postsViewModel.loading.observe(viewLifecycleOwner, ::showLoadingEvent)
        postsViewModel.postsLoaded.observe(viewLifecycleOwner, ::setData)
    }

    private fun showLoadingEvent(loading: Boolean) {
        if (loading) {
            binding.rvPosts.isVisible = false
            binding.progressBar.isVisible = true}
        else {
            binding.rvPosts.isVisible = true
            binding.progressBar.isVisible = false
        }

    }


    private fun setData(posts: List<PostListItem>) {
        adapter.posts.clear()
        adapter.posts.addAll(posts)
    }

    private fun setDecorator() {
        binding.rvPosts.addItemDecoration(
            object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(
                    outRect: Rect,
                    view: View,
                    parent: RecyclerView,
                    state: RecyclerView.State
                ) {
                    if (parent.getChildLayoutPosition(view) == 0) {
                        outRect.top = resources.getDimension(R.dimen.list_item_spacing).toInt()
                    }
                    outRect.bottom = resources.getDimension(R.dimen.list_item_spacing).toInt()
                }
            }
        )
    }

     private fun onPostClick(postId: Int) {
        val f: Fragment = CommentFragment.newInstance()
        val bundle = Bundle()
        bundle.putInt("postId", postId)
        f.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.postViewFragment, f).commit()
    }

}


