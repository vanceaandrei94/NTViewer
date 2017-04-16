package com.unbm.andrei.ntviewer.api.google;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.unbm.andrei.ntviewer.NTViewerApplication;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class MapsClient implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private static final String TAG = "MapsClient";
    private static final long DEFAULT_LOCATION_UPDATE_INTERVAL = 10 * 1000; // 10 seconds

    private GoogleApiClient mGoogleApiClient;
    private Context context;
    private LocationRequest mLocationRequest;

    public MapsClient(Context context) {
        this.context = context;
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(DEFAULT_LOCATION_UPDATE_INTERVAL);

    }

    private void initGoogleApiClient() {
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(context)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }
    }

    public void connect() {
        initGoogleApiClient();
        mGoogleApiClient.connect();
    }


    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.d(TAG, "Google Api Connection established");
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        setLastKnownLocation(lastLocation);
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.e(TAG, "Google Api Connection failed");
    }

    public void disconnect() {
        mGoogleApiClient.disconnect();
        stopLocationUpdates();
    }

    @Override
    public void onLocationChanged(Location location) {
        setLastKnownLocation(location);
        Log.d(TAG, "Location changed, new Location bounds: lat=" + location.getLatitude() + ", lon=" + location.getLongitude());
    }

    public GoogleApiClient getGoogleClient() {
        return mGoogleApiClient;
    }

    private void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    private void stopLocationUpdates() {
        LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
    }

    private void setLastKnownLocation(Location location) {
        NTViewerApplication.getInstance().setLastKnownLocation(location);
    }
}
