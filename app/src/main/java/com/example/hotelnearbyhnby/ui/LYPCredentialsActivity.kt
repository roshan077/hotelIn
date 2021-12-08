package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.hotelnearbyhnby.R

class LYPCredentialsActivity : AppCompatActivity() {
    private lateinit var imgCredentialsHelp: ImageView
    private lateinit var imgCredentialsBack: ImageView
    private lateinit var etCredentialsUsername: EditText
    private lateinit var etCredentialsPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lypcredentials)

        // Binding
        imgCredentialsHelp = findViewById(R.id.imgCredentialsHelp)
        imgCredentialsBack = findViewById(R.id.imgCredentialsBack)
        etCredentialsUsername = findViewById(R.id.etCredentialsUsername)
        etCredentialsPassword = findViewById(R.id.etCredentialsPassword)
        btnLogin = findViewById(R.id.btnLogin)

        //
        imgCredentialsHelp.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Help")
            builder.setMessage("1. Same as your Hotel Nearby account Username. \n" +
                    "2. And Same as your Hotel Nearby account Password. \n" )
            builder.setIcon(android.R.drawable.ic_dialog_info)
            builder.setNeutralButton("Done"){ dialogInterface, which ->
                Toast.makeText(applicationContext, "Done", Toast.LENGTH_LONG).show()
            }

            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        //
        imgCredentialsBack.setOnClickListener {
            var intent = Intent(this, LypActivity::class.java)
            startActivity(intent)
        }

        //
        btnLogin.setOnClickListener {
            var intent = Intent(this, LYPWelcomeActivity::class.java)
            startActivity(intent)
        }
    }
}