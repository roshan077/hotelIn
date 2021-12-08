package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.hotelnearbyhnby.R

class CustomerServiceActivity : AppCompatActivity() {
    private lateinit var imgBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_service)

        // binding
        imgBack = findViewById(R.id.imgBack)

        imgBack.setOnClickListener {
            var intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }
    }
}