package com.cesaanwar.socmedapp.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.cesaanwar.socmedapp.data.source.remote.result.Owner
import com.google.gson.annotations.SerializedName

@Entity(tableName = "post")
data class Post(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("publishDate")
    val publishDate: String,
    @SerializedName("tags")
    @Ignore
    val tags: List<String> = listOf(),
    @SerializedName("text")
    val text: String,
    @Ignore
    var liked: Boolean = false
)

data class OwnerId (
    val id: String
)

