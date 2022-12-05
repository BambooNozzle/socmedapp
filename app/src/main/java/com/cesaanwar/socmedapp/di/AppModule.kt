package com.cesaanwar.socmedapp.di

import android.content.Context
import androidx.room.Room
import com.cesaanwar.socmedapp.data.source.PostDataSource
import com.cesaanwar.socmedapp.data.source.UserDataSource
import com.cesaanwar.socmedapp.data.source.local.LocalPostDataSource
import com.cesaanwar.socmedapp.data.source.local.SocialDatabase
import com.cesaanwar.socmedapp.data.source.local.dao.PostDao
import com.cesaanwar.socmedapp.data.source.remote.RemotePostDataSource
import com.cesaanwar.socmedapp.data.source.remote.RemoteUserDataSource
import com.cesaanwar.socmedapp.data.source.remote.service.SocialService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(
    includes = [
        UserModule::class,
        PostModule::class
    ]
)
@InstallIn(SingletonComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PostLocalDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class PostRemoteDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class UserRemoteDataSource

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SocialDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            SocialDatabase::class.java,
            "social.db"
        ).build()
    }

    @Singleton
    @Provides
    fun providePostDao(
        database: SocialDatabase
    ): PostDao {
        return database.postDao()
    }

    @Provides
    @Singleton
    fun providesRetrofotService(): SocialService {
        return Retrofit.Builder()
            .baseUrl("https://dummyapi.io/data/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SocialService::class.java)
    }

    @Provides
    @UserRemoteDataSource
    fun provideRemoteUserDataSource(
        service: SocialService
    ): UserDataSource {
        return RemoteUserDataSource(service)
    }

    @Provides
    @PostRemoteDataSource
    fun provideRemotePostDataSource(
        service: SocialService
    ): PostDataSource {
        return RemotePostDataSource(service)
    }

    @Provides
    @PostLocalDataSource
    fun provideLocalPostDataSource(
        postDao: PostDao
    ): PostDataSource {
        return LocalPostDataSource(postDao)
    }

}