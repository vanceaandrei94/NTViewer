package com.unbm.andrei.ntviewer.activities.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.DaggerMainComponent;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.MainModule;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.IMainView;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.models.User;
import com.unbm.andrei.ntviewer.util.DialogListener;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView, DialogListener {

    private static final String USER = "user";

    public static void start(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(USER, user);
        context.startActivity(intent);
    }

    @Inject
    MainPresenter<IMainView> presenter;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Preparing Data...");
        presenter.attachView(this);
        presenter.onCreate();
        getSupportActionBar().setTitle(getString(R.string.app_name));
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        presenter.onDestroy();
        super.onDestroy();
    }

    @OnClick(R.id.area_coverage_btn)
    public void startViewProfileActivity() {
        presenter.onViewCoverageActivity();
    }

    @OnClick(R.id.complaints_btn)
    public void startViewComplaintsActivity() {
        presenter.onViewComplaintsActivity();
    }

    @OnClick(R.id.network_route_btn)
    public void startNetworkRouteActivity() {
        presenter.onNetworkRouteActivity();
    }

    @OnClick(R.id.fab_report_problem)
    public void showReportProblemPopup() {
        presenter.onReportProblemScreen();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onDialogPositiveClick() {
        Intent intent = getIntent();
        Bundle intentExtras = intent.getExtras();
    }
}
