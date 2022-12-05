package com.cesaanwar.socmedapp.di

import com.cesaanwar.socmedapp.data.PostRepository
import com.cesaanwar.socmedapp.data.repositoryimpl.PostRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class PostModule {

    @Binds
    abstract fun bindPostRepository(
        postRepositoryImpl: PostRepositoryImpl
    ): PostRepository

}