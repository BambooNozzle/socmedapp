package com.cesaanwar.socmedapp.domain

import com.cesaanwar.socmedapp.data.UserRepository
import javax.inject.Inject
import com.cesaanwar.socmedapp.data.Result
import com.cesaanwar.socmedapp.data.Result.Success
import com.cesaanwar.socmedapp.data.Result.Error
import com.cesaanwar.socmedapp.data.source.remote.result.User

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {

    companion object {
        const val DEFAULT_ITEM_LIMIT = 20
    }

    suspend fun getUsers(page: Int): Result<List<User>> {
        return try {
            val res = userRepository.getUsers(page, DEFAULT_ITEM_LIMIT)
            return Success(res.data)
        } catch (e: Exception) {
            Error(e)
        }
    }

}