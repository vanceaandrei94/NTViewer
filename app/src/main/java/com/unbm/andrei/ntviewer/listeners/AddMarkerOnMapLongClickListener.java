package com.unbm.andrei.ntviewer.listeners;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.unbm.andrei.ntviewer.NTViewerApplication;
import com.unbm.andrei.ntviewer.db.DBOperations;
import com.unbm.andrei.ntviewer.dialogs.AddLocationDialog;
import com.unbm.andrei.ntviewer.model.NetworkLocation;

/**
 * Created by andrei.vancea on 3/6/2017.
 */
public class AddMarkerOnMapLongClickListener implements GoogleMap.OnMapLongClickListener, AddLocationDialog.AddLocationDialogListener {

    private FragmentActivity activity;
    private DBOperations dbOperations;
    private GoogleMap mMap;
    private LatLng location;

    public AddMarkerOnMapLongClickListener(FragmentActivity activity, DBOperations dbOperations, GoogleMap mMap) {
        this.activity = activity;
        this.dbOperations = dbOperations;
        this.mMap = mMap;
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        location = latLng;
        DialogFragment fragment = new AddLocationDialog();
        ((AddLocationDialog) fragment).attachListener(this);
        fragment.show(activity.getSupportFragmentManager(), "Add Location");
    }

    @Override
    public void onDialogPositiveClick(String name, String ipAddress) {
        dbOperations.insert(new NetworkLocation(name, ipAddress, location.latitude, location.longitude));
        NTViewerApplication.getInstance().getLocationList().add(new NetworkLocation(name, ipAddress, location.latitude, location.longitude));
        MarkerOptions marker = new MarkerOptions().position(location).title(name);
        mMap.addMarker(marker);
    }
}
