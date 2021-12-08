package com.example.hotelnearbyhnby.repository

import android.content.Context
import com.example.hotelnearbyhnby.api.HotelAPI
import com.example.hotelnearbyhnby.api.MyApiRequest
import com.example.hotelnearbyhnby.api.ServiceBuilder
import com.example.hotelnearbyhnby.api.ServiceBuilder.buildService
import com.example.hotelnearbyhnby.model.Hotel
import com.example.hotelnearbyhnby.response.HotelResponse
import okhttp3.MultipartBody

class HotelRepository(context: Context) : MyApiRequest() {
    private val hotelApi = buildService(HotelAPI::class.java)

    //    private val roomDao = RoomDB.getInstance(context).roomDAO()
    //get Room
    suspend fun getAllHotelWithAPI(): HotelResponse {
        return apiRequest {
            hotelApi.getAllHotelAPI()
        }
    }

    suspend fun insertHotel(hotel: Hotel): HotelResponse {
        return apiRequest {
            hotelApi.insertHotel(hotel)
        }
    }

    suspend fun deleteHotel(id: String): HotelResponse {
        return apiRequest {
            hotelApi.deleteHotel(ServiceBuilder.token!!, id)
        }
    }

    suspend fun uploadImage(id: String, body: MultipartBody.Part)
            : HotelResponse {
        return apiRequest {
            hotelApi.uploadImage(ServiceBuilder.token!!, id, body)
        }
    }
    // Login user
    //get Room
//    suspend fun getAllRoomWithDB(): List<RoomEntity> {
//        return roomDao.getAllRoom()
//    }
//
//    suspend fun addRoomToDB(room: RoomEntity) {
//        roomDao.addRoom(room)
//    }
}