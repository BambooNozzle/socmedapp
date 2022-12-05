package com.cesaanwar.socmedapp.data.source.remote.service

import com.cesaanwar.socmedapp.data.source.remote.result.PostsResult
import com.cesaanwar.socmedapp.data.source.remote.result.UserDetailResult
import com.cesaanwar.socmedapp.data.source.remote.result.UsersResult
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface SocialService {

    @POST("user")
    suspend fun getUsers(@Query("page") page: Int, @Query("limit") limit: Int): UsersResult

    @POST("user/{id}")
    suspend fun getUserDetail(@Path("id") id: String): UserDetailResult

    @POST("post")
    suspend fun getAllPosts(@Query("page") page: Int, @Query("limit") limit: Int): PostsResult

    @POST("user/{id}/post")
    suspend fun getPostsFromUser(@Path("id") id: String, @Query("page") page: Int, @Query("limit") limit: Int): PostsResult

}