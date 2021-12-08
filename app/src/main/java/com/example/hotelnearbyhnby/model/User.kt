package com.example.hotelnearbyhnby.model

import android.os.Parcel
import android.os.Parcelable

// Columns should be same as collection's name
data class User(
    val username: String? = null,
    val email: String? = null,
    val password: String? = null,
    val address: String? = null,
    val contact: String? = null,
)
