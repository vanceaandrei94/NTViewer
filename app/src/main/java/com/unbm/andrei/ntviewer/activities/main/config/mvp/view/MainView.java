package com.unbm.andrei.ntviewer.activities.main.config.mvp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressLint("ViewConstructor")
public class MainView extends FrameLayout {

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());
    private final SitesAdapter sitesAdapter = new SitesAdapter();

    public MainView(MainActivity activity) {
        super(activity);
        inflate(activity, R.layout.activity_main, this);
        ButterKnife.bind(this);
        setupUIComponents(activity);
        progressDialog.setMessage("Loading Data...");
    }


    public void showLoading(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    public void updateSitesList(List<Site> siteList) {
        sitesAdapter.swapData(siteList);
    }

    private void setupUIComponents(MainActivity activity) {

    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
