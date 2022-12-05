package com.cesaanwar.socmedapp.data.repositoryimpl

import com.cesaanwar.socmedapp.data.UserRepository
import com.cesaanwar.socmedapp.data.source.UserDataSource
import com.cesaanwar.socmedapp.data.source.remote.result.UserDetailResult
import com.cesaanwar.socmedapp.data.source.remote.result.UsersResult
import com.cesaanwar.socmedapp.di.AppModule.UserRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
   @UserRemoteDataSource private val remoteUserDataSource: UserDataSource
): UserRepository {
    override suspend fun getUsers(page: Int, limit: Int): UsersResult = withContext(Dispatchers.IO) {
        remoteUserDataSource.getUsers(page, limit)
    }

    override suspend fun getUserDetailById(id: String): UserDetailResult = withContext(Dispatchers.IO) {
        remoteUserDataSource.getUserDetail(id)
    }

}