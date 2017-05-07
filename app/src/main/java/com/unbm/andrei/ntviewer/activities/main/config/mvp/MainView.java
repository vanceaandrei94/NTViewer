package com.unbm.andrei.ntviewer.activities.main.config.mvp;

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
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.application.network.models.Site;
import com.unbm.andrei.ntviewer.models.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Andrei on 4/30/2017.
 */

@SuppressLint("ViewConstructor")
public class MainView extends FrameLayout {

    private final ProgressDialog progressDialog = new ProgressDialog(getContext());
    private MainPresenter presenter;

    public MainView(MainActivity activity) {
        super(activity);
        inflate(activity, R.layout.activity_main, this);
        ButterKnife.bind(this);
        progressDialog.setMessage("Preparing Data...");
    }

    public void showLoading(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @OnClick(R.id.profile_btn)
    public void startViewProfileActivity() {
//        presenter.startViewProfileActivity();
        showToast("Profile btn clicked.");
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
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void setPresenter(MainPresenter presenter) {
        this.presenter = presenter;
    }
}