package com.unbm.andrei.ntviewer;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.api.google.MapsClient;
import com.unbm.andrei.ntviewer.model.NetworkNode;
import com.unbm.andrei.ntviewer.model.NetworkSite;
import com.unbm.andrei.ntviewer.test.helper.NetworkTestHelper;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnCircleClickListener {

    public static final int REQUEST_PERMISSIONS_CODE = 1;
    private static final String TAG = "[MapsActivity]";

    private GoogleMap mMap;
    private Location mLastLocation;
    private MapsClient mapsClient;
    private NetworkSite networkSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapsClient = new MapsClient(getApplicationContext());
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setOnMyLocationButtonClickListener(() -> {
            if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mapsClient.getGoogleClient());
            if (mLastLocation != null) {
                CameraUpdate cameraUpdate1 = CameraUpdateFactory.newLatLngZoom(new LatLng(mLastLocation.getLatitude(), mLastLocation.getLongitude()), 12);
                mMap.animateCamera(cameraUpdate1);
            }
            return true;
        });
        mMap.setMyLocationEnabled(true);
        mMap.setOnCircleClickListener(this);

        networkSite = NetworkTestHelper.getTestNetworkSite();
        buildNetworkMap(networkSite.getNetworkNodes());
    }

    public void buildNetworkMap(List<NetworkNode> nodes) {
        for (NetworkNode node : nodes) {
            mMap.addCircle(node.getMapObject());
        }
    }


    @Override
    public void onCircleClick(Circle circle) {
        // TODO: 4/16/2017 Implement logic when a node in the main network is clicked.
        NetworkNode node = networkSite.getNetworkNodeByMapObject(circle);
        node.setPublicIp("1.2.3.4");
        Log.d(TAG, node.getPublicIp() + ", Node LatLng: " + node.getLat() + ", " + node.getLon());
        circle.setFillColor(Color.GREEN);
        circle.setStrokeColor(Color.GREEN);
    }
}
