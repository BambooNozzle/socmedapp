package com.cesaanwar.socmedapp.domain

import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.PostRepository
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error

class GetAllPostsUseCase @Inject constructor(
    private val postsRepository: PostRepository
) {

    companion object {
        const val DEFAULT_ITEM_LIMIT = 20
    }

    suspend fun getAllPosts(page: Int): Result<List<Post>> {
        return try {
            val likedIds = getLikedIds(postsRepository.getSavedPosts())
            val res = postsRepository.getPosts(page, DEFAULT_ITEM_LIMIT)
            val posts = res.data
            posts.forEach {
                if (likedIds.contains(it.id)) {
                    it.liked = true
                }
            }
            return Success(posts)
        } catch (e: Exception) {
            Error(e)
        }
    }

    private fun getLikedIds(posts: List<Post>): Set<String> {
        val res = HashSet<String>()
        posts.forEach {
            res.add(it.id)
        }
        return res
    }

}