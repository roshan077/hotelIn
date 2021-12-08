package com.example.hotelnearbyhnby.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.model.User
import java.util.ArrayList

data class UserAdapter(
    val lstUser: ArrayList<User>,
    val context: Context
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    //view holder
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val username: TextView = view.findViewById(R.id.tvUsername)
        val email: TextView = view.findViewById(R.id.tvEmail)
        val contact: TextView = view.findViewById(R.id.tvContact)
        val address: TextView = view.findViewById(R.id.tvAddress)
    }

    // ACTUAL KURSI BANAU
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.lyp_recycler_design, parent, false)

        return UserViewHolder(view)
    }

    //Bhitra ko content lai change gara
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        // euta employee lai extract garau
        val hotel = lstUser[position]

        holder.username.text = hotel.username
        holder.email.text = hotel.email
        holder.contact.text = hotel.contact
        holder.address.text = hotel.address

//        Glide.with(context)
//            .load(hotel.imageUrl)
//            .circleCrop()
//            .into(holder.imgHotelImage)

        // delete item
//        holder.btnDelete.setOnClickListener {
//            LYPDetailsShowActivity.lstHotel.remove(hotel)
//            notifyDataSetChanged()
//        }

//        holder.imgHotelImage.setOnClickListener {
//            val intent = Intent(context, ProfileActivity::class.java)
//            intent.putExtra("hotel",hotel)
//
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return lstUser.size
    }

}