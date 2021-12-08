package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.hotelnearbyhnby.R

class LypActivity : AppCompatActivity() {
    private lateinit var imgBack: ImageView
    private lateinit var imgHelp: ImageView
    private lateinit var btnList: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lyp)

        // binding
        imgBack = findViewById(R.id.imgBack)
        imgHelp = findViewById(R.id.imgHelp)
        btnList = findViewById(R.id.btnList)

        //
        imgHelp.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Help")
            builder.setMessage("1. You can list your Hotel if you have hotel.\n" +
                    "2. You can login via your Hotel Nearby account. \n" +
                    " 3. You do not need to create new account and password for to use this.\n" +
                    "4. If you already have account then sign in.")
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setNeutralButton("Done"){ dialogInterface, which ->
                Toast.makeText(applicationContext, "Done", Toast.LENGTH_LONG).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        //
        imgBack.setOnClickListener {
            var intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
        }

        //
        btnList.setOnClickListener {
            var intent = Intent(this, LYPCredentialsActivity::class.java)
            startActivity(intent)

        }
    }
}