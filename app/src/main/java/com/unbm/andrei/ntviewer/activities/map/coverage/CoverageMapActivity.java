package com.unbm.andrei.ntviewer.activities.map.coverage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.model.PolygonOptions;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.map.base.MapActivity;
import com.unbm.andrei.ntviewer.activities.map.coverage.config.dagger.CoverageMapModule;
import com.unbm.andrei.ntviewer.activities.map.coverage.config.dagger.DaggerCoverageMapComponent;
import com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp.CoverageMapPresenter;
import com.unbm.andrei.ntviewer.activities.map.coverage.config.mvp.ICoverageMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.GeoLocation;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;
import com.unbm.andrei.ntviewer.util.ColorUtil;
import com.unbm.andrei.ntviewer.util.LocationTranslator;

import java.util.List;

import javax.inject.Inject;

public class CoverageMapActivity extends MapActivity implements ICoverageMapView {

    public static void start(Context context) {
        Intent intent = new Intent(context, CoverageMapActivity.class);
        context.startActivity(intent);
    }

    @Inject
    CoverageMapPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCoverageMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .coverageMapModule(new CoverageMapModule(this))
                .build().inject(this);

        presenter.onCreate();
        getSupportActionBar().setTitle(getResources().getString(R.string.coverage_map_title));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void drawCoverage(List<NetworkProvider> providers) {
        for (NetworkProvider provider : providers) {
            PolygonOptions coverage = new PolygonOptions()
                    .fillColor(ColorUtil.getColorFromString(provider.getColor(), 40))
                    .strokeWidth(1)
                    .strokeColor(Color.parseColor(provider.getColor()));
            for (GeoLocation geoLocation : provider.getGeoLocations()) {
                coverage.add(LocationTranslator.translateGeoLocationIntoLatLng(geoLocation));
            }
            map.addPolygon(coverage);
        }
    }

}
