package com.cesaanwar.socmedapp.data.source

import com.cesaanwar.socmedapp.data.source.remote.result.UserDetailResult
import com.cesaanwar.socmedapp.data.source.remote.result.UsersResult

interface UserDataSource {

    suspend fun getUsers(page: Int, limit: Int): UsersResult

    suspend fun getUserDetail(id: String): UserDetailResult

}