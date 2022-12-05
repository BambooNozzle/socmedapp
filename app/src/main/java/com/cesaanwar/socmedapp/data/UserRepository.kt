package com.cesaanwar.socmedapp.data

import com.cesaanwar.socmedapp.data.source.remote.result.UserDetailResult
import com.cesaanwar.socmedapp.data.source.remote.result.UsersResult

interface UserRepository {

    suspend fun getUsers(page: Int, limit: Int): UsersResult

    suspend fun getUserDetailById(id: String): UserDetailResult

}