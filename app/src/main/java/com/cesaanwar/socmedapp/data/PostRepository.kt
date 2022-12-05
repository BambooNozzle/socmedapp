package com.cesaanwar.socmedapp.data

import com.cesaanwar.socmedapp.data.source.remote.result.PostsResult

interface PostRepository {

    suspend fun getPosts(page: Int, limit: Int): PostsResult

    suspend fun getPostsFromUser(id: String, page: Int, limit: Int): PostsResult

    suspend fun getSavedPosts(): List<Post>

    suspend fun addPostToLocal(post: Post)

    suspend fun removePostFromLocal(post: Post)

}