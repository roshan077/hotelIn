package com.example.hotelnearbyhnby.api

import android.util.Log
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException

abstract class MyApiRequest {
    suspend fun <A> apiRequest(call: suspend () -> Response<A>): A {
        val response = call.invoke()
        Log.d("affe", response.toString())
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.string()
            val message = StringBuilder()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("success"))
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            message.append("Error code : ${response.code()}")
            throw IOException(error)
        }
    }
}