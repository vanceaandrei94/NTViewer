package com.unbm.andrei.ntviewer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.unbm.andrei.ntviewer.api.google.MapsClient;
import com.unbm.andrei.ntviewer.db.DBOperations;
import com.unbm.andrei.ntviewer.listeners.AddMarkerOnMapLongClickListener;
import com.unbm.andrei.ntviewer.listeners.ShowSnackBarOnMarkerClickListener;
import com.unbm.andrei.ntviewer.model.NetworkLocation;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    DBOperations dbOperations;

    public static final int LOCATION_PERMISSIONS_REQUEST_CODE = 1;
    private GoogleMap mMap;
    private Location mLastLocation;
    private MapsClient mapsClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mapsClient = new MapsClient(getApplicationContext());
        dbOperations = NTViewerApplication.getInstance().getDbOperations();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mapsClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mapsClient.disconnect();
    }

    @Override
    protected void onDestroy() {
        dbOperations.closeConnection();
        super.onDestroy();
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
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {
                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
                mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mapsClient.getGoogleClient());
                if (mLastLocation != null) {
                    CameraUpdate cameraUpdate1 = CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 12);
                    mMap.animateCamera(cameraUpdate1);
                }
                return true;
            }
        });
        mMap.setMyLocationEnabled(true);
        mMap.setOnMapLongClickListener(new AddMarkerOnMapLongClickListener(this, dbOperations, mMap));
        mMap.setOnMarkerClickListener(new ShowSnackBarOnMarkerClickListener(this));

        showMarkers();
    }

    private void showMarkers() {
        List<NetworkLocation> locationList = NTViewerApplication.getInstance().getLocationList();
        for (NetworkLocation location : locationList) {
            LatLng position = new LatLng(location.getLat(), location.getLon());
            MarkerOptions marker = new MarkerOptions().position(position).title(location.getName());
            mMap.addMarker(marker);
        }
    }
}
