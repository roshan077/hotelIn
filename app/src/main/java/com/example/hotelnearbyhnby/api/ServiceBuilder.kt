package com.example.hotelnearbyhnby.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ServiceBuilder {
    // for emulator: 10.0.2.2
    // for physical device: we can see from cmd by doing, "ipconfig"
    private const val BASE_URL = "http://192.168.1.69:90/"
    var token: String? = null
    var userid: String? = null
    var okHttpClient = OkHttpClient.Builder()
        .connectTimeout(1, TimeUnit.MINUTES)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(15, TimeUnit.SECONDS)
        .build()

    // Create Retrofit instance
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    // Generic function
    fun <T> buildService(serviceType: Class<T>): T {
        return retrofitBuilder.create(serviceType)
    }
}