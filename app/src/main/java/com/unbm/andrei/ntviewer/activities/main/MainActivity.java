package com.unbm.andrei.ntviewer.activities.main;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.DaggerMainComponent;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.MainModule;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.IMainView;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.models.User;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMainView {

    private static final String USER = "user";

    public static void start(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(USER, user);
        context.startActivity(intent);
    }

    @Inject
    MainPresenter presenter;

    private final ProgressDialog progressDialog = new ProgressDialog(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog.setMessage("Preparing Data...");
        presenter.onCreate();
        getSupportActionBar().setTitle("NTViewer");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @OnClick(R.id.area_coverage_btn)
    public void startViewProfileActivity() {
        presenter.startViewCoverageActivity();
    }

    @OnClick(R.id.requests_btn)
    public void startViewRequestsActivity() {
        showToast("Requests btn clicked.");
    }

    @OnClick(R.id.complaints_btn)
    public void startViewComplaintsActivity() {
        showToast("Complaints btn clicked.");
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
