package com.example.exampleapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.R
import com.example.exampleapp.databinding.ItemCommentBinding
import com.example.exampleapp.ui.dto.CommentItem
import com.example.exampleapp.ui.dto.PostListItem


class CommentAdapter(
    private val postComments: List<CommentItem>
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {
    class CommentViewHolder(
        val itemBinding: ItemCommentBinding
    ) : RecyclerView.ViewHolder(itemBinding.root)

    //    ) : RecyclerView.Adapter<CommentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder =
        CommentViewHolder(
            ItemCommentBinding.bind(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_comment, parent, false)
            )
        )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.itemBinding.commentName.text = postComments[position].name
        holder.itemBinding.commentEmail.text = postComments[position].email
        holder.itemBinding.commentBody.text = postComments[position].body
    }

    override fun getItemCount() = postComments.size
}