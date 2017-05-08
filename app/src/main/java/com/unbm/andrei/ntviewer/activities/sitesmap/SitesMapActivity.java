package com.unbm.andrei.ntviewer.activities.sitesmap;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.activities.sitesmap.config.dagger.DaggerSitesMapComponent;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.dagger.SitesMapModule;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp.SitesMapPresenter;
import com.unbm.andrei.ntviewer.activities.sitesmap.config.mvp.SitesMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SitesMapActivity extends AppCompatActivity {

    public static final String SITES_LIST = "SITES_LIST";

    public static void start(Context context, List<Site> sites) {
        Intent intent = new Intent(context, SitesMapActivity.class);
        intent.putParcelableArrayListExtra(SITES_LIST, new ArrayList<>(sites));
        context.startActivity(intent);
    }

    @Inject
    SitesMapPresenter presenter;

    @Inject
    SitesMapView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSitesMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .sitesMapModule(new SitesMapModule(this))
                .build().inject(this);

        checkForNeededPermissions();
        setContentView(view);
        presenter.onCreate();
    }

    private void checkForNeededPermissions() {
        int fineLocation = PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int coarseLocation = PermissionChecker.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        if (coarseLocation != PackageManager.PERMISSION_GRANTED && fineLocation != PackageManager.PERMISSION_GRANTED) {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
