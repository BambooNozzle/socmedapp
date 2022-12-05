package com.cesaanwar.socmedapp.data.source.remote

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.source.PostDataSource
import com.cesaanwar.socmedapp.data.source.remote.result.PostsResult
import com.cesaanwar.socmedapp.data.source.remote.service.SocialService
import javax.inject.Inject

class RemotePostDataSource constructor(
    private val service: SocialService
): PostDataSource {

    override suspend fun getPosts(page: Int, limit: Int): PostsResult {
        return service.getAllPosts(page, limit)
    }

    override suspend fun getPostsFromUser(id: String, page: Int, limit: Int): PostsResult {
        return service.getPostsFromUser(id, page, limit)
    }

    override suspend fun getSavedPosts(): List<Post> {
        return listOf()
    }

    override suspend fun addPostToLocal(post: Post) {

    }

    override suspend fun removePostFromLocal(post: Post) {

    }
}