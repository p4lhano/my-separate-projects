package br.com.up.mypins.network

import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.os.AsyncTask
import org.json.JSONObject
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.nio.charset.StandardCharsets

class ConnectionAsyncTask(private val listener: ConnectionListener) :



    AsyncTask<String?, Int?, String?>() {

    override fun doInBackground(vararg p0: String?): String? {
        TODO("Not yet implemented")
        val stringUrl = strings[0]
        return try {
            val url = URL(stringUrl)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.connect()
            if (urlConnection.responseCode == 200) {
                val inputStream = urlConnection.inputStream
                org.apache.commons.io.IOUtils.toString(inputStream, StandardCharsets.UTF_8)
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
/*
    protected override fun doInBackground(vararg strings: String): String? {
        val stringUrl = strings[0]
        return try {
            val url = URL(stringUrl)
            val urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod = "GET"
            urlConnection.connect()
            if (urlConnection.responseCode == 200) {
                val inputStream = urlConnection.inputStream
                org.apache.commons.io.IOUtils.toString(inputStream, StandardCharsets.UTF_8)
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
*/
    override fun onPostExecute(s: String?) {
        super.onPostExecute(s)
        try {
            val `object` = JSONObject(s)
            listener.onRequestFinish(`object`)
        } catch (e: Exception) {
            listener.onRequestFinish(null)
        }
    }

    interface ConnectionListener {
        fun onRequestFinish(`object`: JSONObject?)
    }


}