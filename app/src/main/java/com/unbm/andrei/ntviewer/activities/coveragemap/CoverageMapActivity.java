package com.unbm.andrei.ntviewer.activities.coveragemap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.PolygonOptions;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger.CoverageMapModule;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger.DaggerCoverageMapComponent;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.CoverageMapPresenter;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.ICoverageMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CoverageMapActivity extends AppCompatActivity implements ICoverageMapView, OnMapReadyCallback {

    public static final String PROVIDERS_LIST = "PROVIDERS_LIST";

    public static void start(Context context, List<NetworkProvider> providers) {
        Intent intent = new Intent(context, CoverageMapActivity.class);
        intent.putParcelableArrayListExtra(PROVIDERS_LIST, new ArrayList<>(providers));
        context.startActivity(intent);
    }

    @Inject
    CoverageMapPresenter presenter;

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCoverageMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .coverageMapModule(new CoverageMapModule(this))
                .build().inject(this);

        setContentView(R.layout.activity_map);
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter.onCreate();
        getSupportActionBar().setTitle("Coverage Map");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
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
