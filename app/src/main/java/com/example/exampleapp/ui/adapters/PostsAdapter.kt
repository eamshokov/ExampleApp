package com.example.exampleapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ItemPostBinding
import com.example.exampleapp.ui.dto.PostListItem

class PostsAdapter(
    val posts: MutableList<PostListItem>,
    private val onItemClicked: (postId: Int) -> Unit = {}
) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    class ViewHolder(
        val itemBinding: ItemPostBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPostBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_post, parent, false)
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.tvTitle.text = posts[position].title
        holder.itemBinding.root.setOnClickListener {
            onItemClicked(posts[position].id)
        }
    }
    override fun getItemCount(): Int = posts.size
}