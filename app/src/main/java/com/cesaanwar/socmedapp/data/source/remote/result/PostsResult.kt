package com.cesaanwar.socmedapp.data.source.remote.result
import com.cesaanwar.socmedapp.data.Post
import com.google.gson.annotations.SerializedName


data class PostsResult(
    @SerializedName("data")
    val data: List<Post> = mutableListOf(),
    @SerializedName("limit")
    val limit: Int = 0,
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total")
    val total: Int = 0
)

data class Owner(
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("title")
    val title: String
)