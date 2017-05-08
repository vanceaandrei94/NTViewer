package com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.activities.common.mvp.BaseView;
import com.unbm.andrei.ntviewer.activities.sitesmap.SitesMapActivity;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

@SuppressWarnings("MissingPermission")
public class SitesMapView extends FrameLayout implements BaseView, OnMapReadyCallback {

    private SitesMapPresenter presenter;

    private GoogleMap map;

    public SitesMapView(@NonNull Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_sites_map, this);
        SupportMapFragment mapFragment = (SupportMapFragment) ((SitesMapActivity) context).getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (SitesMapPresenter) presenter;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setMyLocationEnabled(true);
    }

    public void moveCamera(LatLng position) {
        map.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

    public void buildOverlay(LatLngBounds bounds) {
        GroundOverlayOptions siteOverlay = new GroundOverlayOptions()
                .positionFromBounds(bounds)
                .image(BitmapDescriptorFactory.defaultMarker())
                .transparency(50);
        map.addGroundOverlay(siteOverlay);
    }

}
