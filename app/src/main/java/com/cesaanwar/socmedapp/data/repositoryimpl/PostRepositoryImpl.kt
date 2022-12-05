package com.cesaanwar.socmedapp.data.repositoryimpl

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.PostRepository
import com.cesaanwar.socmedapp.data.source.PostDataSource
import com.cesaanwar.socmedapp.data.source.remote.result.PostsResult
import com.cesaanwar.socmedapp.di.AppModule.PostLocalDataSource
import com.cesaanwar.socmedapp.di.AppModule.PostRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    @PostLocalDataSource private val localPostDataSource: PostDataSource,
    @PostRemoteDataSource private val remotePostDataSource: PostDataSource
): PostRepository {
    override suspend fun getPosts(page: Int, limit: Int): PostsResult = withContext(Dispatchers.IO) {
        remotePostDataSource.getPosts(page, limit)
    }

    override suspend fun getPostsFromUser(id: String, page: Int, limit: Int): PostsResult = withContext(Dispatchers.IO) {
        remotePostDataSource.getPostsFromUser(id,page, limit)
    }

    override suspend fun getSavedPosts(): List<Post> = withContext(Dispatchers.IO) {
        localPostDataSource.getSavedPosts()
    }

    override suspend fun addPostToLocal(post: Post) = withContext(Dispatchers.IO) {
        localPostDataSource.addPostToLocal(post)
    }

    override suspend fun removePostFromLocal(post: Post) = withContext(Dispatchers.IO) {
        localPostDataSource.removePostFromLocal(post)
    }
}