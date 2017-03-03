package com.unbm.andrei.ntviewer.api.google;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class MapsClient implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static final String TAG = "MapsClient";

    private GoogleApiClient mGoogleApiClient;
    private Context context;

    public MapsClient(Context context) {
        this.context = context;
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
        Log.e(TAG, "Google Api Connection established");
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
    }

    public GoogleApiClient getGoogleClient() {
        return mGoogleApiClient;
    }
}
