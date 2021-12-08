package com.example.hotelnearbyhnby.api

import com.example.hotelnearbyhnby.model.User
import com.example.hotelnearbyhnby.response.UserResponse
import retrofit2.Response
import retrofit2.http.*

interface UserAPI {
    @POST("user/register")
    suspend fun registerUser(
        @Body user: User
    ): Response<UserResponse>

    @FormUrlEncoded
    @POST("user/login")
    suspend fun loginUser(
//        @Body user: String,
//        password: String
        @Field("username") username: String,
        @Field("password") password: String
    ): Response<UserResponse>

    @GET("profile/single/{id}")
    suspend fun getUserAPI(
        @Header("Authorization")token:String,
        @Path("id") id: String
    ):Response<UserResponse>
}