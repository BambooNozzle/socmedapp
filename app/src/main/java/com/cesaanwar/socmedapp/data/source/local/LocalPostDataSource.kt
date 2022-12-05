package com.cesaanwar.socmedapp.data.source.local

import com.cesaanwar.socmedapp.data.OwnerId
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.source.PostDataSource
import com.cesaanwar.socmedapp.data.source.local.dao.PostDao
import com.cesaanwar.socmedapp.data.source.remote.result.PostsResult
import javax.inject.Inject
import javax.sql.DataSource

class LocalPostDataSource constructor(
    private val postDao: PostDao
): PostDataSource {
    override suspend fun getPosts(page: Int, limit: Int): PostsResult {
        return PostsResult()
    }

    override suspend fun getPostsFromUser(id: String, page: Int, limit: Int): PostsResult {
        return PostsResult()
    }

    override suspend fun getSavedPosts(): List<Post> {
        return postDao.getPosts()
    }

    override suspend fun addPostToLocal(post: Post) {
        postDao.addPost(post)
    }

    override suspend fun removePostFromLocal(post: Post) {
        val idToDelete = OwnerId(post.id)
        postDao.deletePost(idToDelete)
    }
}