package com.unbm.andrei.ntviewer.util;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;

/**
 * Created by Andrei on 8/27/2017.
 */

public class LocationProvider {

    public static final String LOCATION_TAG = "Location";
    private static LocationProvider instance;
    private LocationManager locationManager;
    private LocationListener locationListener;
    private Context context;
    private LatLng currentLocation;

    private FusedLocationProviderClient locationProviderClient;

    public static LocationProvider getInstance() {
        if (instance == null) {
            instance = new LocationProvider();
        }
        return instance;
    }

    private LocationProvider() {
    }

    public void init(Context context) {
        this.context = context;
    }

    @SuppressLint("NewApi")
    public void registerLocationListener() {
        locationProviderClient = LocationServices.getFusedLocationProviderClient(context.getApplicationContext());
        locationProviderClient.getLastLocation().addOnSuccessListener(location -> {
            if (location != null) {
                currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                Log.d(LOCATION_TAG, context.getString(R.string.current_location_found));
            }
        });
        locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (isGPSEnabled(context)) {
                    if (locationListener != null) {
                        if (ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }

                        if (locationManager != null) {
                            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                            if (location != null) {
                                setCurrentLocation(new LatLng(location.getLatitude(), location.getLongitude()));
                            }
                        }
                    }
                } else if (isInternetConnected(context)) {
                    if (locationManager != null) {
                        location = locationManager
                                .getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            setCurrentLocation(new LatLng(location.getLatitude(), location.getLongitude()));
                        }
                    }
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1, locationListener);
    }

    private static boolean isInternetConnected(Context ctx) {
        ConnectivityManager connectivityMgr = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobile = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // Check if wifi or mobile network is available or not. If any of them is
        // available or connected then it will return true, otherwise false;
        if (wifi != null) {
            if (wifi.isConnected()) {
                return true;
            }
        }
        if (mobile != null) {
            if (mobile.isConnected()) {
                return true;
            }
        }
        return false;
    }

    private boolean isGPSEnabled(Context mContext) {
        LocationManager locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }


    public LatLng getCurrentLocation() {
        return currentLocation;
    }

    private void setCurrentLocation(LatLng currentLocation) {
        this.currentLocation = currentLocation;
    }
}
