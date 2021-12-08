package com.example.hotelnearbyhnby.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.model.Hotel
import com.example.hotelnearbyhnby.ui.LYPDetailsShowActivity
import java.util.ArrayList

class HotelAdapter(
    val lstHotel: ArrayList<Hotel>,
    val context: Context
) : RecyclerView.Adapter<HotelAdapter.HotelViewHolder>() {

    //view holder
    class HotelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgHotelImage: ImageView = view.findViewById(R.id.imgHotelImage)
        val btnUpdate: TextView = view.findViewById(R.id.btnUpdate)
        val btnDelete: TextView = view.findViewById(R.id.btnDelete)
        val tvPropertyName: TextView = view.findViewById(R.id.tvPropertyName)
        val tvStreetAddress: TextView = view.findViewById(R.id.tvStreetAddress)
        val tvCity: TextView = view.findViewById(R.id.tvCity)
        val tvCountry: TextView = view.findViewById(R.id.tvCountry)
        val tvNoOfRooms2: TextView = view.findViewById(R.id.tvNoOfRooms2)
        val tvNoOfGuest2: TextView = view.findViewById(R.id.tvNoOfGuest2)
        val tvGuestCanUse2: TextView = view.findViewById(R.id.tvGuestCanUse2)
        val tvSmoke2: TextView = view.findViewById(R.id.tvSmoke2)
        val tvPet2: TextView = view.findViewById(R.id.tvPet2)
        val tvChildren2: TextView = view.findViewById(R.id.tvChildren2)
        val tvParties2: TextView = view.findViewById(R.id.tvParties2)
        val tvCheckInFromTime: TextView = view.findViewById(R.id.tvCheckInFromTime)
        val tvCheckInUntilTime: TextView = view.findViewById(R.id.tvCheckInUntilTime)
        val tvCheckOutFromTime: TextView = view.findViewById(R.id.tvCheckOutFromTime)
        val tvCheckOutUntilTime: TextView = view.findViewById(R.id.tvCheckOutUntilTime)
        val tvPrice3: TextView = view.findViewById(R.id.tvPrice3)

    }

    // ACTUAL KURSI BANAU
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lyp_recycler_design, parent, false)

        return HotelViewHolder(view)
    }

    //Bhitra ko content lai change gara
    override fun onBindViewHolder(holder: HotelViewHolder, position: Int) {
        // euta employee lai extract garau
        val hotel = lstHotel[position]

        holder.tvPropertyName.text = hotel.propertyName
        holder.tvStreetAddress.text = hotel.streetAddress
        holder.tvCity.text = hotel.city
        holder.tvCountry.text = hotel.country
        holder.tvNoOfRooms2.text = hotel.noOfRooms
        holder.tvNoOfGuest2.text = hotel.noOfGuests
        holder.tvGuestCanUse2.text = hotel.guestCanUse
        holder.tvSmoke2.text = hotel.smoke
        holder.tvPet2.text = hotel.pet
        holder.tvChildren2.text = hotel.children
        holder.tvParties2.text = hotel.parties
        holder.tvCheckInFromTime.text = hotel.checkInFrom
        holder.tvCheckInUntilTime.text = hotel.checkInUntil
        holder.tvCheckOutFromTime.text = hotel.checkOutFrom
        holder.tvCheckOutUntilTime.text = hotel.checkOutUntil
        holder.tvPrice3.text = hotel.price

        Glide.with(context)
            .load(hotel.imageUrl)
            .circleCrop()
            .into(holder.imgHotelImage)

        // delete item
        holder.btnDelete.setOnClickListener {
            LYPDetailsShowActivity.lstHotel.remove(hotel)
            notifyDataSetChanged()
        }

//        holder.imgHotelImage.setOnClickListener {
//            val intent = Intent(context, ProfileActivity::class.java)
//            intent.putExtra("hotel",hotel)
//
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return lstHotel.size
    }
}