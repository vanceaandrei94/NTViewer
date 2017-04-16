package com.unbm.andrei.ntviewer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.unbm.andrei.ntviewer.presenters.SiteInfoPresenter;
import com.unbm.andrei.ntviewer.presenters.SiteInfoPresenterImpl;
import com.unbm.andrei.ntviewer.views.SiteInfoView;

public class SiteInfoActivity extends AppCompatActivity implements SiteInfoView {


    private SiteInfoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site_info);
        presenter = new SiteInfoPresenterImpl(this);
        presenter.loadClosestSite();

    }

    @Override
    public void loadSite() {
        updateUI();
    }

    private void updateUI() {
        // TODO: 4/16/2017 Put all the data received into views
    }
}
