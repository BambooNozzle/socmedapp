package com.cesaanwar.socmedapp.domain

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.PostRepository
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error

class SavePostUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun savePost(post: Post): Result<String> {
        return try {
            postRepository.addPostToLocal(post)
            Success(post.id)
        } catch (e: Exception) {
            Error(e)
        }
    }

}