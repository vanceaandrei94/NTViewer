package com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp;

import android.Manifest;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.FrameLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolygonOptions;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.common.mvp.BasePresenter;
import com.unbm.andrei.ntviewer.activities.common.mvp.BaseView;
import com.unbm.andrei.ntviewer.activities.coveragemap.CoverageMapActivity;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class CoverageMapView extends FrameLayout implements BaseView, OnMapReadyCallback, GoogleMap.OnMapLongClickListener {

    private CoverageMapPresenter presenter;

    private GoogleMap map;

    public CoverageMapView(@NonNull Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_sites_map, this);
        MapFragment mapFragment = (MapFragment) ((CoverageMapActivity) context).getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (CoverageMapPresenter) presenter;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.setOnMapLongClickListener(this);
        RxPermissions rxPermissions = new RxPermissions((CoverageMapActivity) getContext());
        rxPermissions.request(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION)
                .subscribe(granted -> addMapFeaturesIfGranted(granted));
    }

    @SuppressWarnings("MissingPermission")
    private void addMapFeaturesIfGranted(Boolean granted) {
        map.setMyLocationEnabled(true);
    }

    public void moveCamera(LatLng position) {
        map.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

    public void buildOverlay(PolygonOptions polygonOptions) {
        //just for testing purposes
        map.addPolygon(polygonOptions);
    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        Log.d("MAP", "Long Click Triggered...");
        presenter.addSiteOverlay();
    }
}
