package com.cesaanwar.socmedapp.data.source.remote.result
import com.google.gson.annotations.SerializedName


data class UsersResult(
    @SerializedName("data")
    val data: List<User>,
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("total")
    val total: Int
)

data class User(
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
) {
    fun getFullName(): String = "$title. $firstName $lastName"
}