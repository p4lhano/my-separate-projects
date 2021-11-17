package com.example.placesmaps

import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.placesmaps.databinding.ActivityMapsBinding
import java.util.jar.Manifest

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
//":" == extends, deve ter por padrão o construtor
//"," == implemts

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private lateinit var locationManager : LocationManager

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

        verifyCheckPermission()

        locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
    }

    fun verifyCheckPermission(){
        if (ActivityCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) == PackageManager.PERMISSION_GRANTED ){
            var locationUser = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

            locationUser?.let { location ->
                // Add a marker in myPosition and move the camera
                val myPosition = LatLng(locationUser.latitude, locationUser.longitude)
                mMap.addMarker(MarkerOptions().position(myPosition).title("Minha Posição"))
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myPosition))
            }

        } else {
        //ActivityCompat.OnRequestPermissionsResultCallback()
        requestPermissions( arrayOf( android.Manifest.permission.ACCESS_COARSE_LOCATION ),1000 )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if ( requestCode == 1000 && grantResults[0] == PackageManager.PERMISSION_GRANTED ){

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
    }
}