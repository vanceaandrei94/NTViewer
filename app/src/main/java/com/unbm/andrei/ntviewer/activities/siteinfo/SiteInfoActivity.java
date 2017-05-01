package com.unbm.andrei.ntviewer.activities.siteinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.activities.siteinfo.config.dagger.DaggerSiteComponent;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.dagger.SiteModule;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp.SitePresenter;
import com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp.SiteView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Andrei on 5/1/2017.
 */

public class SiteInfoActivity extends AppCompatActivity {

    public static final String SITE = "SITE";

    public static void start(Context context, Site site) {
        Intent intent = new Intent(context, SiteInfoActivity.class);
        intent.putExtra(SITE, site);
        context.startActivity(intent);
    }

    @Inject
    SiteView view;

    @Inject
    SitePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSiteComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .siteModule(new SiteModule(this))
                .build().inject(this);

        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
