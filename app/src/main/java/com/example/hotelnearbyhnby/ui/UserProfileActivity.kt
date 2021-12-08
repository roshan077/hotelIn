package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.api.ServiceBuilder
import com.example.hotelnearbyhnby.model.User
import com.example.hotelnearbyhnby.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserProfileActivity : AppCompatActivity() {
    private lateinit var imgProfile: ImageView
    private lateinit var tvUsername: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvAddress: TextView
    private lateinit var tvContact: TextView
    private lateinit var btnEdit: Button
    private lateinit var imgBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        // binding
        imgProfile = findViewById(R.id.imgProfile)
        tvUsername = findViewById(R.id.tvUsername)
        tvEmail = findViewById(R.id.tvEmail)
        tvAddress = findViewById(R.id.tvAddress)
        tvContact = findViewById(R.id.tvContact)
        btnEdit = findViewById(R.id.btnEdit)
        imgBack = findViewById(R.id.imgBack)

        //
        imgBack.setOnClickListener {
            var intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }


        btnEdit.setOnClickListener {
            var intent = Intent(this, UserProfileEditActivity::class.java)
            startActivity(intent)
        }

        CoroutineScope(Dispatchers.Main).launch {
//
            try {
                val repository = UserRepository()
                val response = repository.getUserProfile(ServiceBuilder.userid!!)

                Log.d("afridi", response.data.toString())
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@UserProfileActivity, "afe", Toast.LENGTH_SHORT).show()
//                        tvUsername.setText(response.data.username)
//                        tvEmail.setText(str?.email)
//                        tvAddress.setText(str?.address)
//                        tvContact.setText(str?.contact)
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Log.d("helo", ex.printStackTrace().toString())
                    Toast.makeText(this@UserProfileActivity, ex.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }
}




//            Glide.with(this@UserProfileActivity)
//                .load(ServiceBuilder.BASE_URL + str?.movieimage )
//                .into(imageView)
//

