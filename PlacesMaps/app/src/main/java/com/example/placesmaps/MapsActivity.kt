package com.example.placesmaps

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.example.placesmaps.Conections.PlaceAPI
import com.example.placesmaps.Models.Places

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.placesmaps.databinding.ActivityMapsBinding
import com.google.android.gms.common.GooglePlayServicesUtil
import com.google.android.gms.location.*
import com.google.android.material.textfield.TextInputEditText
import java.security.Permission
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
//":" == extends, deve ter por padrão o construtor
//"," == implemts

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager : LocationManager
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    val locationCallback = object : LocationCallback(){
        override fun onLocationResult(resultLocation: LocationResult) {
            super.onLocationResult(resultLocation)
            if (resultLocation.locations.size > 0){
                val location = resultLocation.locations[0]
                val myPosition = LatLng(location.latitude, location.longitude)
                mMap.addMarker(MarkerOptions().position(myPosition).title("Minha Posição"))
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,15f))
            }
        }
    }
    // funções tipificação com ": type" ausencia diz void
    // nulabilidade de variaveis com "?" ao final da declaração
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)



        //locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)



        verifyCheckPermission()

        val inputSearch = binding.root.findViewById<TextInputEditText>(R.id.input_text_search)

        inputSearch.setOnEditorActionListener { view,id,keyEvent ->
            if(id == EditorInfo.IME_ACTION_SEARCH){
                val stringSearch = view.text.toString()
                Log.v("BUSCADOR", "Buscando: $stringSearch")
                PlaceAPI().searchPlaces(stringSearch, object : PlaceAPI.PlaceAPIListener{
                    override fun onPlacesResult(places: ArrayList<Places>) {
                        places?.let {
                            addMarker(it)
                        }
                    }
                })
                return@setOnEditorActionListener false
            }

             true
        }

    }

    private fun addMarker(places: ArrayList<Places>){
        for (i in 0 until places.size ){
            val location = places[i]
            val myPosition = LatLng(location.lat, location.long)
            mMap.addMarker(MarkerOptions().position(myPosition).title(location.name))
            //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,15f))
        }
    }


    @SuppressLint("MissingPermission")
    private fun realTimeLocation(){


        val locationRequest = LocationRequest()
        locationRequest.interval = 5000

        fusedLocationProviderClient.requestLocationUpdates(
            locationRequest,
            locationCallback,
            Looper.getMainLooper()
        )

        fusedLocationProviderClient.lastLocation.addOnSuccessListener{ location ->
            // Add a marker in myPosition and move the camera
            val myPosition = LatLng(location.latitude, location.longitude)
            mMap.addMarker(MarkerOptions().position(myPosition).title("Minha Posição1"))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myPosition,15f))
        }
    }

    fun verifyCheckPermission(){
        if(ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            realTimeLocation()

        }else{
            requestPermissions(arrayOf(android.Manifest.permission.ACCESS_COARSE_LOCATION ), 1000)
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if ( requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){
            verifyCheckPermission()
        }

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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
    }
}