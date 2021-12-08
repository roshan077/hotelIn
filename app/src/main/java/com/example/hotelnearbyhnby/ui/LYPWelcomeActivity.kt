package com.example.hotelnearbyhnby.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.hotelnearbyhnby.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class LYPWelcomeActivity : AppCompatActivity() {
    private lateinit var navMenu: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var materialToolbar: MaterialToolbar
    private lateinit var btnStart: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lypwelcome)

        // binding
        navMenu = findViewById(R.id.navMenu)
        drawer = findViewById(R.id.drawer)
        materialToolbar = findViewById(R.id.materialToolbar)
        btnStart = findViewById(R.id.btnStart)

        // After clicking on hamburger menu
        materialToolbar.setNavigationOnClickListener(){
            drawer.openDrawer(GravityCompat.START)
        }

        //
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_account -> Toast.makeText(applicationContext, "Clicked Manage Account", Toast.LENGTH_SHORT).show()
                R.id.menu_Logout -> Toast.makeText(applicationContext, "Clicked Logout", Toast.LENGTH_SHORT).show()
            }
            true
        }

        // After clicking on btnStart
        btnStart.setOnClickListener {
            var intent = Intent(this, LYPFormActivity::class.java)
            startActivity(intent)
        }

    }
}