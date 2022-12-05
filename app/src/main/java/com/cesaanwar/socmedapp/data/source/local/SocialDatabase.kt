package com.cesaanwar.socmedapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cesaanwar.socmedapp.data.Post
import com.cesaanwar.socmedapp.data.source.local.dao.PostDao

@Database(
    entities = [
        Post::class
    ],
    version = 1,
    exportSchema = false
)
abstract class SocialDatabase: RoomDatabase() {

    abstract fun postDao(): PostDao

}