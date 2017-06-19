package com.unbm.andrei.ntviewer.activities.map.base;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.tbruyelle.rxpermissions2.RxPermissions;

/**
 * Created by Andrei on 6/11/2017.
 */

public abstract class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap map;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> addMapFeaturesIfGranted(granted));
    }

    @SuppressWarnings("MissingPermission")
    private void addMapFeaturesIfGranted(Boolean granted) {
        if (granted) {
            map.setMyLocationEnabled(true);
        }
    }
}
