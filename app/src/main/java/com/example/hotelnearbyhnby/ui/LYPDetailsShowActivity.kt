package com.example.hotelnearbyhnby.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.adapter.HotelAdapter
import com.example.hotelnearbyhnby.model.Hotel

class LYPDetailsShowActivity : AppCompatActivity() {
    companion object{
        var lstHotel : ArrayList<Hotel> = ArrayList<Hotel>()

    }

    private lateinit var lstHotel: ArrayList<Hotel>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lypdetails_show)

        // binding
        recyclerView = findViewById(R.id.recyclerView)
        populateHotel()

        val adapter = HotelAdapter(lstHotel, this)
        // kun layout ma dekhaune, here we have used linear layout
        recyclerView.layoutManager = LinearLayoutManager(this@LYPDetailsShowActivity)
        recyclerView.adapter = adapter
    }

    private fun populateHotel() {
        lstHotel.add(
            Hotel()
        )
    }
}