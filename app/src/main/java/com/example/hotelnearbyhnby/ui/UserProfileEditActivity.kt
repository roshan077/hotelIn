package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.hotelnearbyhnby.R

class UserProfileEditActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var tvUsername2: TextView
    private lateinit var tvEmail2: TextView
    private lateinit var tvAddress2: TextView
    private lateinit var tvContact2: TextView
    private lateinit var btnUpdate: Button
    private lateinit var imgBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile_edit)

        // binding
        imgProfile = findViewById(R.id.imgProfile)
        tvUsername2 = findViewById(R.id.tvUsername2)
        tvEmail2 = findViewById(R.id.tvEmail2)
        tvAddress2 = findViewById(R.id.tvAddress2)
        tvContact2 = findViewById(R.id.tvContact2)
        btnUpdate = findViewById(R.id.btnUpdate)
        imgBack = findViewById(R.id.imgBack)

        //
        imgBack.setOnClickListener {
            var intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }
    }
}