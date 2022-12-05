package com.cesaanwar.socmedapp.data.source.remote.result
import com.google.gson.annotations.SerializedName


data class UserDetailResult(
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("location")
    val location: Location,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: String,
    @SerializedName("registerDate")
    val registerDate: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("updatedDate")
    val updatedDate: String
)

data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("street")
    val street: String,
    @SerializedName("timezone")
    val timezone: String
)