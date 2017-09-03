package com.unbm.andrei.ntviewer.activities.login;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.login.config.dagger.DaggerLoginComponent;
import com.unbm.andrei.ntviewer.activities.login.config.dagger.LoginModule;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.ILoginView;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginPresenter;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.util.LocationProvider;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView, OnRequestPermissionsResultCallback {

    public static final int ACCESS_LOCATION_PERMISSION_CODE = 112;
    @Inject
    LoginPresenter<ILoginView> presenter;

    @BindView(R.id.input_username)
    EditText usernameEt;

    @BindView(R.id.input_password)
    EditText passwordEt;

    private ProgressDialog progressDialog;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DaggerLoginComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
        ButterKnife.bind(this);

//       -- remove those from release
        usernameEt.setText("test");
        passwordEt.setText("pass");
//       -- remove those from release

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing in...");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark, null));
        }
        if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_LOCATION_PERMISSION_CODE);
        } else {
            LocationProvider.getInstance().registerLocationListener();
        }
        presenter.attachView(this);
        presenter.onCreate();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == ACCESS_LOCATION_PERMISSION_CODE) {
            boolean granted = true;
            for (int grantResult : grantResults) {
                if (grantResult != PackageManager.PERMISSION_GRANTED) {
                    granted = false;
                }
            }
            if (granted) {
                LocationProvider.getInstance().registerLocationListener();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @OnClick(R.id.btn_sign_in)
    public void signInButtonClick() {
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            presenter.signInUser(username, password);
        } else {
            showInvalidCredentialsError();
        }
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        presenter.onDestroy();
        super.onDestroy();
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
    public void showInvalidCredentialsError() {
        Toast.makeText(this, getString(R.string.invalid_credentials_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGenericError() {
        Toast.makeText(this, getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return this;
    }
}
