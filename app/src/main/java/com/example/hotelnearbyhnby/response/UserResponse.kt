package com.example.hotelnearbyhnby.response

import com.example.hotelnearbyhnby.model.User

data class UserResponse(
    val success: Boolean? = null,
    val token: String? = null,
    val userid: String? = null,
    val data: MutableList<User>? = null,
)