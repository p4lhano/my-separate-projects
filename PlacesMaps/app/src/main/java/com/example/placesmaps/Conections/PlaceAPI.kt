package com.example.placesmaps.Conections

import com.example.placesmaps.Models.Places
import org.json.JSONObject

class PlaceAPI {
    //https://maps.googleapis.com/maps/api/place/textsearch/json?query=shopping%20em%Curitiba&key=AIzaSyDyFUltXibk_rGCb7Nak3wB5HC_KamkKRI&language=pt-BR
    fun searchPlaces(query: String,listener: PlaceAPIListener){
        var url = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=$query&key=AIzaSyDyFUltXibk_rGCb7Nak3wB5HC_KamkKRI&language=pt-BR"
        ConnectionTaks { resultObject ->
            val places = arrayListOf<Places>()
            resultObject?.let {
                val results = it.getJSONArray("results")
                for (i in 0 until results.length() ){
                    val objetoPlaces = results.getJSONObject(i)
                    val name = objetoPlaces.getString("name")
                    val location = objetoPlaces.getJSONObject("geometry").getJSONObject("location")
                    val lat = location.getDouble("lat")
                    val long = location.getDouble("lng")
                    val endereco = objetoPlaces.getString("formatted_address")
                    places.add(Places(name,lat,long,endereco))
                }
                listener.onPlacesResult(places)
            }
        }.execute(url)
    }

    interface PlaceAPIListener{
        fun onPlacesResult(places: ArrayList<Places>)
    }

}