package com.cesaanwar.socmedapp.main.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.cesaanwar.socmedapp.data.source.remote.result.User
import com.cesaanwar.socmedapp.databinding.ItemUserBinding

class UserAdapter: ListAdapter<User, UserAdapter.UserViewHolder>(UserDiffCallback()) {

    class UserViewHolder(val binding: ItemUserBinding): ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemUserBinding.inflate(layoutInflater, parent, false)

                return UserViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        val binding = holder.binding
        binding.user = user
        Glide.with(holder.itemView.context).load(
            user.picture
        ).into(binding.ivProfile).clearOnDetach()
    }

}

class UserDiffCallback: DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }

}