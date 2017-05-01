package com.unbm.andrei.ntviewer.activities.main.config.mvp.view;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxAbsListView;
import com.jakewharton.rxbinding2.widget.RxAdapter;
import com.jakewharton.rxbinding2.widget.RxAdapterView;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressLint("ViewConstructor")
public class MainView extends FrameLayout {

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());
    private final SitesAdapter sitesAdapter = new SitesAdapter();

    // TODO: 4/30/2017 BIND VIEWS HERE (Build layout)
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.sites_list)
    ListView listView;

    public MainView(MainActivity activity) {
        super(activity);
        inflate(activity, R.layout.activity_main, this);
        ButterKnife.bind(this);
        setupUIComponents(activity);
    }

    //example of click observer
    public Observable<Object> observeButton() {
        return RxView.clicks(toolbar);
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
        activity.setSupportActionBar(toolbar);
        listView.setAdapter(sitesAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 5/1/2017 find a way to implement this using RxJava
            }
        });
    }

    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
