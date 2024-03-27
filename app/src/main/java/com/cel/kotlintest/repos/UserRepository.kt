package com.cel.kotlintest.repos
import com.cel.kotlintest.model.User
import com.cel.kotlintest.network.ApiService
import okhttp3.ResponseBody
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getUser(userId: String): User {
        return apiService.getUser(userId)
    }

    suspend fun getUserList(): List<User> {
        return apiService.getUserList()
    }
}
