package com.example.hotelnearbyhnby.repository

import com.example.hotelnearbyhnby.api.MyApiRequest
import com.example.hotelnearbyhnby.api.ServiceBuilder
import com.example.hotelnearbyhnby.api.UserAPI
import com.example.hotelnearbyhnby.model.User
import com.example.hotelnearbyhnby.response.UserResponse

class UserRepository : MyApiRequest() {
    private val userApi = ServiceBuilder.buildService(UserAPI::class.java)

    // Register User
    suspend fun registerUser(user: User): UserResponse {
        return apiRequest {
            userApi.registerUser(user)
        }
    }

    // Login User
    suspend fun login(username: String, password: String): UserResponse {
        return apiRequest {
            userApi.loginUser(username, password)
        }
    }

    suspend fun getUserProfile(id: String): UserResponse{
        return apiRequest {
            userApi.getUserAPI(ServiceBuilder.token!!, id)
        }
    }
}