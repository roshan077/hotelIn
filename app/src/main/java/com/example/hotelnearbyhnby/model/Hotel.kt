package com.example.hotelnearbyhnby.model

import android.os.Parcel
import android.os.Parcelable

data class Hotel(
    val imageUrl: String? = null,
    val propertyName: String? = null,
    val streetAddress: String? = null,
    val city: String? = null,
    val country: String? = null,
    val noOfRooms: String? = null,
    val noOfGuests: String? = null,
    val guestCanUse: String? = null,
    val smoke: String? = null,
    val pet: String? = null,
    val children: String? = null,
    val parties: String? = null,
    val checkInFrom: String? = null,
    val checkInUntil: String? = null,
    val checkOutFrom: String? = null,
    val checkOutUntil: String? = null,
    val price: String? = null,
    val rb: String? = null,
) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(imageUrl)
        parcel.writeString(propertyName)
        parcel.writeString(streetAddress)
        parcel.writeString(city)
        parcel.writeString(country)
        parcel.writeString(noOfRooms)
        parcel.writeString(noOfGuests)
        parcel.writeString(guestCanUse)
        parcel.writeString(smoke)
        parcel.writeString(pet)
        parcel.writeString(children)
        parcel.writeString(parties)
        parcel.writeString(checkInFrom)
        parcel.writeString(checkInUntil)
        parcel.writeString(checkOutFrom)
        parcel.writeString(checkOutUntil)
        parcel.writeString(price)
        parcel.writeString(rb)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hotel> {
        override fun createFromParcel(parcel: Parcel): Hotel {
            return Hotel(parcel)
        }

        override fun newArray(size: Int): Array<Hotel?> {
            return arrayOfNulls(size)
        }
    }

}