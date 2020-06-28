package com.example.projekti.util;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.annotations.NotNull;



public class GoogleMapHelper {

    public static void defaultMapSettings(@NotNull GoogleMap googleMap) {
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(false);

        googleMap.getUiSettings().setRotateGesturesEnabled(true);
        float zoomLevel = 8.35f;
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(42.6026,20.9030),zoomLevel));
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(false);
        googleMap.setBuildingsEnabled(true);
    }
}
