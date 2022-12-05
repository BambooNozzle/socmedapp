package com.cesaanwar.socmedapp.data.source.remote

import com.cesaanwar.socmedapp.data.source.UserDataSource
import com.cesaanwar.socmedapp.data.source.remote.result.UserDetailResult
import com.cesaanwar.socmedapp.data.source.remote.result.UsersResult
import com.cesaanwar.socmedapp.data.source.remote.service.SocialService
import javax.inject.Inject

class RemoteUserDataSource @Inject constructor(
    val service: SocialService
): UserDataSource {

    override suspend fun getUsers(page: Int, limit: Int): UsersResult {
        return service.getUsers(page, limit)
    }

    override suspend fun getUserDetail(id: String): UserDetailResult {
        return service.getUserDetail(id)
    }
}