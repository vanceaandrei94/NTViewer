package com.unbm.andrei.ntviewer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.unbm.andrei.ntviewer.api.google.MapsClient;
import com.unbm.andrei.ntviewer.db.DBOperations;
import com.unbm.andrei.ntviewer.dialogs.AddLocationDialog;
import com.unbm.andrei.ntviewer.model.NetworkLocation;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, AddLocationDialog.AddLocationDialogListener {

    private static final String ACTION_VIEW_SKETCH = "View Sketch";
    public static final int REQUEST_PERMISSIONS_CODE = 1;

    private GoogleMap mMap;
    private Location mLastLocation;
    private MapsClient mapsClient;
    private DBOperations dbOperations;
    private LatLng location;

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
        mMap.setOnMapLongClickListener(onMapLongClickListener);
        mMap.setOnMarkerClickListener(onMarkerClickListener);

        showMarkers();
    }

    // Add location logic
    private GoogleMap.OnMapLongClickListener onMapLongClickListener = new GoogleMap.OnMapLongClickListener() {

        @Override
        public void onMapLongClick(LatLng latLng) {
            location = latLng;
            DialogFragment fragment = new AddLocationDialog();
            ((AddLocationDialog) fragment).attachListener(MapsActivity.this);
            fragment.show(getSupportFragmentManager(), "Add Location");
        }
    };

    @Override
    public void onDialogPositiveClick(String name, String ipAddress) {
        dbOperations.insertLocation(new NetworkLocation(name, location.latitude, location.longitude));
        NTViewerApplication.getInstance().getLocationList().add(new NetworkLocation(name, location.latitude, location.longitude));
        MarkerOptions marker = new MarkerOptions().position(location).title(name);
        mMap.addMarker(marker);
    }
    // ---

    // Show location info logic and start activity on snackbar action button click
    private GoogleMap.OnMarkerClickListener onMarkerClickListener = new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.map), marker.getTitle(), Snackbar.LENGTH_LONG);
            snackbar.setActionTextColor(Color.GREEN);
            snackbar.setAction(ACTION_VIEW_SKETCH, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MapsActivity.this, SketchViewActivity.class));
                }
            });
            snackbar.show();
            return true;
        }
    };
    // ---

    private void showMarkers() {
        List<NetworkLocation> locationList = NTViewerApplication.getInstance().getLocationList();
        for (NetworkLocation location : locationList) {
            LatLng position = new LatLng(location.getLat(), location.getLon());
            MarkerOptions marker = new MarkerOptions().position(position).title(location.getName());
            mMap.addMarker(marker);
        }
    }
}
