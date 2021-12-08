package com.example.hotelnearbyhnby.api

import com.example.hotelnearbyhnby.model.Hotel
import com.example.hotelnearbyhnby.response.HotelResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface HotelAPI {
    // get room API
    @GET("hotel/showall")
    suspend fun getAllHotelAPI(): Response<HotelResponse>

    @POST("hotel/insert")
    suspend fun insertHotel(
        @Body hotel: Hotel
    ): Response<HotelResponse>

    @DELETE("hotel/delete/{id}")
    suspend fun deleteHotel(
        @Path("id") id: String,
        id1: String,
    ): Response<HotelResponse>

    @Multipart
    @PUT("hotel/upload/{id}/photo")
    suspend fun uploadImage(
        @Header("Authorization") token: String,
        @Path("id") id: String,
        @Part file: MultipartBody.Part
    ): Response<HotelResponse>

    @Multipart
    @PUT("music/update_image/{id}")
    suspend fun updateImg(
        @Path("id") id: String,
        @Part file: MultipartBody.Part,
    ): Response<HotelResponse>
}