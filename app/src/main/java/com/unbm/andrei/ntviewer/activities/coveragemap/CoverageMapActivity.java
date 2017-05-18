package com.unbm.andrei.ntviewer.activities.coveragemap;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger.CoverageMapModule;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.dagger.DaggerCoverageMapComponent;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.CoverageMapPresenter;
import com.unbm.andrei.ntviewer.activities.coveragemap.config.mvp.CoverageMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProviders;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CoverageMapActivity extends AppCompatActivity {

    public static final String SITES_LIST = "SITES_LIST";

    public static void start(Context context, List<NetworkProviders> providers) {
        Intent intent = new Intent(context, CoverageMapActivity.class);
        intent.putParcelableArrayListExtra(SITES_LIST, new ArrayList<>(providers));
        context.startActivity(intent);
    }

    @Inject
    CoverageMapPresenter presenter;

    @Inject
    CoverageMapView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCoverageMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .coverageMapModule(new CoverageMapModule(this))
                .build().inject(this);

        setContentView(view);
        view.setPresenter(presenter);
        presenter.onCreate();
        getSupportActionBar().setTitle("Coverage Map");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
