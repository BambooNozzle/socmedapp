package com.cesaanwar.socmedapp.domain

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.PostRepository
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error

class DeletePostFromLocalUseCase @Inject constructor(
    private val postRepository: PostRepository
) {

    suspend fun removePostFromLocal(post: Post): Result<String> {
        return try {
            postRepository.removePostFromLocal(post)
            Success(post.id)
        } catch (e: Exception) {
            Error(e)
        }
    }

}