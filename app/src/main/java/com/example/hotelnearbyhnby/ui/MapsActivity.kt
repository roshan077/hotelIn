package com.example.hotelnearbyhnby.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelnearbyhnby.R
import com.example.hotelnearbyhnby.classes.LatitudeLongitude
import com.example.hotelnearbyhnby.databinding.ActivityMapsBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var lstLatitudeLongitude = ArrayList<LatitudeLongitude>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        // Add a marker in Sydney and move the camera
//        val sydney = LatLng(-34.0, 151.0)
//        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
//    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        lstLatitudeLongitude.add(LatitudeLongitude(27.7061842,85.3290819, "Softwarica College"))
        lstLatitudeLongitude.add(LatitudeLongitude(27.6509689,85.3168009, "Nakhipot (My Home"))

        //Load multiple locations

        for (location in lstLatitudeLongitude) {
            mMap.addMarker(
                MarkerOptions().position(LatLng(location.latitude, location.longitude))
                    .title(location.markerName)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
            )
        }

        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(27.7061949, 85.3300394),16F), 4000, null
        )
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}