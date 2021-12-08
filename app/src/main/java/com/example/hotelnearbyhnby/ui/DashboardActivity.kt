package com.example.hotelnearbyhnby.ui

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.hotelnearbyhnby.R
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView
import com.google.android.material.textfield.TextInputEditText
import java.util.*

class DashboardActivity : AppCompatActivity() {
    private lateinit var navMenu: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var materialToolbar: MaterialToolbar
    private lateinit var tvCheckIn2: TextView
    private lateinit var tvCheckOut2: TextView
    private lateinit var imgLocation: ImageView
    private lateinit var btnSearch: Button
    private lateinit var btnLocation: Button

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // binding
        navMenu = findViewById(R.id.navMenu)
        drawer = findViewById(R.id.drawer)
        materialToolbar = findViewById(R.id.materialToolbar)
        tvCheckIn2 = findViewById(R.id.tvCheckIn2)
        tvCheckOut2 = findViewById(R.id.tvCheckOut2)
        imgLocation = findViewById(R.id.imgLocation)
        btnSearch = findViewById(R.id.btnSearch)
        btnLocation = findViewById(R.id.btnLocation)


        // After clicking on hamburger menu
        materialToolbar.setNavigationOnClickListener() {
            drawer.openDrawer(GravityCompat.START)
        }

        //
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navMenu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_account -> {
                    var intent = Intent(this, UserProfileActivity::class.java)
                    startActivity(intent)
                }

                R.id.menu_favorite -> Toast.makeText(
                    applicationContext,
                    "Clicked Favorite",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.menu_hotel -> {
                    var intent = Intent(this, LypActivity::class.java)
                    startActivity(intent)
                }

                R.id.menu_customerService -> {
                    var intent = Intent(this, CustomerServiceActivity::class.java)
                    startActivity(intent)
                }

                R.id.menu_FAQ -> Toast.makeText(
                    applicationContext,
                    "Clicked FAQ",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.menu_Logout -> Toast.makeText(
                    applicationContext,
                    "Clicked Logout",
                    Toast.LENGTH_SHORT
                ).show()
            }
            true
        }


        // After tapping on Date Textview of CheckIn
        tvCheckIn2.setOnClickListener {
            loadDate()
        }

        // After tapping on Date Textview of CheckOut
        tvCheckOut2.setOnClickListener {
            loadDate()
        }

        // After tapping on "Turn on your location" button
        btnLocation.setOnClickListener {
            var intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        // After tapping on Navbar notification icon
        imgLocation.setOnClickListener {
            var intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }
    }


    // loadDate function
    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadDate() {
        val c =
            Calendar.getInstance()             // Instance of calendar : for to bring current date
        val year = c.get(Calendar.YEAR)     // gives current year
        val month = c.get(Calendar.MONTH)       // gives current month
        val day = c.get(Calendar.DAY_OF_MONTH)      // gives current day or date

        // When user clicks on DatePickerStart button, there must be pop up date display, so we need to do following steps
        // we use DatePickerDialog
        DatePickerDialog(
            this,
            { view, year, month, dayOfMonth ->
                tvCheckIn2.text = "$dayOfMonth - ${month + 1} - $year"      // DD-MM-YYYY format
                tvCheckOut2.text = "$dayOfMonth - ${month + 1} - $year"      // DD-MM-YYYY format
            },
            year,
            month,      // month starts from 0, so December is 11. That's why we add +1 in month above
            day
        ).show()
    }


    //
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}