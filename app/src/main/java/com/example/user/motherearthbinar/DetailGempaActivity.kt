package com.example.user.motherearthbinar

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory



private var mapView: MapView? = null

class DetailGempaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Mapbox Access token
        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));

        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_detail_gempa)

        mapView = findViewById(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync {
            // Customize map with markers, polylines, etc.private var mapView: MapView? = null
            it.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    LatLng(
                        51.507351,
                        -0.127758
                    ), 12.0
                )
            )
            it.addMarker(MarkerOptions().position(LatLng(51.507351, -0.127758)))
        }

        var dataModel = intent.getParcelableExtra<GempaModel>("data")

        var tv_lokasi = findViewById<TextView>(R.id.tv_lokasi)
        var tv_status = findViewById<TextView>(R.id.tv_status)

        tv_lokasi.text = dataModel.lokasi
        tv_status.text = dataModel.status


    }
}
