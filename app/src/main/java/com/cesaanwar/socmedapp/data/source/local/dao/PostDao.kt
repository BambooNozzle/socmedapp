package com.cesaanwar.socmedapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cesaanwar.socmedapp.data.OwnerId
import com.cesaanwar.socmedapp.data.Post

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPost(vararg posts: Post)

    @Query("select * from post")
    suspend fun getPosts(): List<Post>

    @Delete(entity = Post::class)
    suspend fun deletePost(id: OwnerId)

}