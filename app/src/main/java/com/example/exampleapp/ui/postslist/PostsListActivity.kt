package com.example.exampleapp.ui.postslist

import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ActivityMainBinding
import com.example.exampleapp.ui.adapters.PostsAdapter
import com.example.exampleapp.ui.dto.PostListItem
import com.example.exampleapp.ui.fullpost.FullPostActivity
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*

class PostsListActivity : AppCompatActivity(), PostsListView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: PostsListPresenter
    private lateinit var adapter: PostsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = PostsListPresenter(this)
        adapter = PostsAdapter(mutableListOf()){ postId ->
            onPostClick(postId)
        }
        binding.rvPosts.adapter = adapter
        setDecorator()
        lifecycleScope.launchWhenCreated {
            presenter.init()
        }

        /*val client = HttpClient {
            install(JsonFeature) {
                serializer = GsonSerializer()
            }
            defaultRequest {
                host = BASE_URL
                url {
                    protocol = URLProtocol.HTTPS
                }
            }
        }


        lifecycleScope.launchWhenCreated {
            val posts: List<Post> = try {

            } catch (e: Throwable) {
                Toast.makeText(
                    this@PostsListActivity,
                    R.string.loading_error_happened,
                    Toast.LENGTH_SHORT
                ).show()
                listOf()
            }


            binding.progressBar.isVisible = false
            binding.rvPosts.isVisible = true
        }*/

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
                        outRect.top =
                            resources.getDimension(R.dimen.list_item_spacing).toInt()
                    }
                    outRect.bottom = resources.getDimension(R.dimen.list_item_spacing).toInt()
                }
            }
        )
    }

    private fun onPostClick(postId: Int) {
        val intent = Intent(this@PostsListActivity, FullPostActivity::class.java)
        intent.putExtra(FullPostActivity.POST_ID_ARG, postId)
        startActivity(intent)
    }

    companion object {
        const val BASE_URL = "jsonplaceholder.typicode.com"
    }

    override fun showLoading() {
        binding.rvPosts.isVisible = false
        binding.progressBar.isVisible = true
    }

    override fun hideLoading() {
        binding.rvPosts.isVisible = true
        binding.progressBar.isVisible = false
    }

    override fun setData(posts: List<PostListItem>) {
        adapter.posts.clear()
        adapter.posts.addAll(posts)
    }
}