package com.cesaanwar.socmedapp.di

import com.cesaanwar.socmedapp.data.UserRepository
import com.cesaanwar.socmedapp.data.repositoryimpl.UserRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class UserModule {

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

}