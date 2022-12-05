package com.cesaanwar.socmedapp.domain

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.PostRepository
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error

class GetSavedPostsUseCase @Inject constructor(
    private val postsRepository: PostRepository
) {

    suspend fun getAllLikedPosts(): Result<List<Post>> {
        return try {
            val res = postsRepository.getSavedPosts()
            Success(res)
        } catch (e: Exception) {
            Error(e)
        }
    }

}