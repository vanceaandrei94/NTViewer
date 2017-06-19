package com.unbm.andrei.ntviewer.activities.map.base;

import android.Manifest;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.util.DialogHelper;

/**
 * Created by Andrei on 6/11/2017.
 */

public abstract class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    protected GoogleMap map;
    private boolean isGpsEnabled;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isGpsEnabled) {
            DialogHelper.showActivateGpsDialog(this);
        }
    }

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
