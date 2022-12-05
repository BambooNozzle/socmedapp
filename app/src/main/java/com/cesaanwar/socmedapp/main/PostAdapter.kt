package com.cesaanwar.socmedapp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.databinding.ItemPostBinding

class PostAdapter: ListAdapter<Post, PostAdapter.PostViewHolder>(PostDiffUtil()) {

    class PostViewHolder(val binding: ItemPostBinding): ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): PostViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPostBinding.inflate(layoutInflater, parent, false)

                return PostViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val binding = holder.binding
        val post = getItem(position)
        binding.post = post
        if (post.tags.isEmpty()) {
            binding.rvTags.visibility = View.GONE
        }
        Glide.with(holder.itemView.context)
            .load(post.image).into(binding.ivImage).clearOnDetach()
    }

}

class PostDiffUtil: DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem == newItem
    }

}