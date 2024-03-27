package com.cel.kotlintest.network

import com.cel.kotlintest.model.User
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("users/{user}")
    suspend fun getUser(@Path("user") userId: String): User

    @GET("users")
    suspend fun getUserList(): List<User>
}
