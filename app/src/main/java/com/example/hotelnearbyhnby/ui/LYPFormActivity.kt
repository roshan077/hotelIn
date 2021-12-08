package com.example.hotelnearbyhnby.ui

import android.app.Activity
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.model.Hotel
import com.example.hotelnearbyhnby.repository.HotelRepository
import com.github.dhaval2404.imagepicker.ImagePicker
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URI
import java.text.SimpleDateFormat
import java.util.*

class LYPFormActivity : AppCompatActivity() {
    private lateinit var spinnerNoOfGuest: Spinner
    private lateinit var tvCheckInFromTime: TextView
    private lateinit var tvCheckInUntilTime: TextView
    private lateinit var tvCheckOutFromTime: TextView
    private lateinit var tvCheckOutUntilTime: TextView
    private lateinit var imgUploadImage: ImageView
    private lateinit var btnPickImage: Button
    private lateinit var btnSubmit: Button
    private lateinit var etName: EditText
    private lateinit var etStreet: EditText
    private lateinit var etCountry: EditText
    private lateinit var etCity: EditText
    private lateinit var etNoOfRooms: EditText
    private lateinit var rg: RadioGroup
    private lateinit var rb1: RadioButton
    private lateinit var rb2: RadioButton
    private lateinit var rb3: RadioButton
    private lateinit var rb4: RadioButton
    private lateinit var rb5: RadioButton
    private lateinit var rb6: RadioButton
    private lateinit var rb7: RadioButton
    private lateinit var rb8: RadioButton
    private lateinit var rb9: RadioButton
    private lateinit var rb10: RadioButton
    private lateinit var swSmoke: Switch
    private lateinit var swPet: Switch
    private lateinit var swChildren: Switch
    private lateinit var swParties: Switch
    private lateinit var tvPrice: TextView


    companion object {
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lypform)

        // binding
        spinnerNoOfGuest = findViewById(R.id.spinnerNoOfGuest)
        tvCheckInFromTime = findViewById(R.id.tvCheckInFromTime)
        tvCheckInUntilTime = findViewById(R.id.tvCheckInUntilTime)
        tvCheckOutFromTime = findViewById(R.id.tvCheckOutFromTime)
        tvCheckOutUntilTime = findViewById(R.id.tvCheckOutUntilTime)
        imgUploadImage = findViewById(R.id.imgUploadImage)
        btnPickImage = findViewById(R.id.btnPickImage)
        btnSubmit = findViewById(R.id.btnSubmit)
        etName = findViewById(R.id.etName)
        etStreet = findViewById(R.id.etStreet)
        etCountry = findViewById(R.id.etCountry)
        etCity = findViewById(R.id.etCity)
        etNoOfRooms = findViewById(R.id.etNoOfRooms)
        rg = findViewById(R.id.rg)
        swSmoke = findViewById(R.id.swSmoke)
        swPet = findViewById(R.id.swPet)
        swChildren = findViewById(R.id.swChildren)
        swParties = findViewById(R.id.swParties)
        tvPrice = findViewById(R.id.tvPrice)
        rb1 = findViewById(R.id.rb1)
        rb2 = findViewById(R.id.rb2)
        rb3 = findViewById(R.id.rb3)
        rb4 = findViewById(R.id.rb4)
        rb5 = findViewById(R.id.rb5)
        rb6 = findViewById(R.id.rb6)
        rb7 = findViewById(R.id.rb7)
        rb8 = findViewById(R.id.rb8)
        rb9 = findViewById(R.id.rb9)
        rb10 = findViewById(R.id.rb10)

        // Array adapter
        val adapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, resources.getStringArray(R.array.noOfGuest)
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerNoOfGuest.adapter = adapter


        // After clicking on Submit button
        btnSubmit.setOnClickListener {
            addHotel()
        }


        //
        tvCheckInFromTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                // set time to textview
                tvCheckInFromTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        tvCheckInUntilTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                // set time to textview
                tvCheckInUntilTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        tvCheckOutFromTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                // set time to textview
                tvCheckOutFromTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        tvCheckOutUntilTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                // set time to textview
                tvCheckOutUntilTime.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        //
        btnPickImage.setOnClickListener {
//            ImagePicker.with(this)
//                .crop()                    //Crop image(Optional), Check Customization for more option
//                .compress(1024)            //Final image size will be less than 1 MB(Optional)
//                .maxResultSize(
//                    1080,
//                    1080
//                )    //Final image resolution will be less than 1080 x 1080(Optional)
//                .start()

            pickImageGallery()
        }
    }

    //
    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            imgUploadImage.setImageURI(data?.data)
        }
    }


    // addHotel function
    private fun addHotel() {
        val propertyName = etName.text.toString()
        val streetAddress = etStreet.text.toString()
        val city = etCity.text.toString()
        val country = etCountry.text.toString()
        val noOfRooms = etNoOfRooms.text.toString()
        val noOfGuests = spinnerNoOfGuest.toString()
        val smoke = swSmoke.text.toString()
        val pet = swPet.text.toString()
        val children = swChildren.text.toString()
        val parties = swParties.text.toString()
        val checkInFrom = tvCheckInFromTime.text.toString()
        val checkInUntil = tvCheckInUntilTime.text.toString()
        val checkOutFrom = tvCheckOutFromTime.text.toString()
        val checkOutUntil = tvCheckOutUntilTime.text.toString()
        val price = tvPrice.text.toString()
        var rb = ""
        when {
            rb1.isChecked -> {
                rb = "Sauna"
            }
            rb2.isChecked -> {
                rb = "Bar"
            }
            rb3.isChecked -> {
                rb = "Garden"
            }
            rb4.isChecked -> {
                rb = "Terrace"
            }
            rb5.isChecked -> {
                rb = "Tub/Jacuzzi"
            }
            rb6.isChecked -> {
                rb = "Heating"
            }
            rb7.isChecked -> {
                rb = "Free Wi-Fi"
            }
            rb8.isChecked -> {
                rb = "Air Conditioning"
            }
            rb9.isChecked -> {
                rb = "On-site Parking"
            }
            rb10.isChecked -> {
                rb = "Swimming Pool"
            }
        }

        val hotel = Hotel(
            propertyName = propertyName,
            streetAddress = streetAddress,
            city = city,
            country = country,
            noOfRooms = noOfRooms,
            noOfGuests = noOfGuests,
            smoke = smoke,
            pet = pet,
            children = children,
            parties = parties,
            checkInFrom = checkInFrom,
            checkInUntil = checkInUntil,
            checkOutFrom = checkOutFrom,
            checkOutUntil = checkOutUntil,
            price = price,
            rb = rb,
        )

        println(hotel)
        Log.d("hotelData", hotel.toString())
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelRepository = HotelRepository(this@LYPFormActivity)
                val response = hotelRepository.insertHotel(hotel)
//                    Hotel(
//                        propertyName = propertyName,
//                        streetAddress = streetAddress,
//                        city = city,
//                        country = country,
//                        noOfRooms = noOfRooms,
//                        noOfGuests = noOfGuests,
//                        smoke = smoke,
//                        pet = pet,
//                        children = children,
//                        parties = parties,
//                        checkInFrom = checkInFrom,
//                        checkInUntil = checkInUntil,
//                        checkOutFrom = checkOutFrom,
//                        checkOutUntil = checkOutUntil,
//                        price = price,
//                        rb = rb,
//
//                        )

//                println(response)
                if (response.success == true) {
//                    if (imageUrl != "") {
//                        uploadImage(response.data!!._id.toString())
//                    }
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LYPFormActivity,
                            "Space Added",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@LYPFormActivity,
                        ex.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}