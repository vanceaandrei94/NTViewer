package com.unbm.andrei.ntviewer.activities.login;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
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

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    @Inject
    LoginPresenter presenter;

    @BindView(R.id.input_username)
    EditText usernameEt;

    @BindView(R.id.input_password)
    EditText passwordEt;

    private final ProgressDialog progressDialog = new ProgressDialog(this);

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
        progressDialog.setMessage("Signing in...");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark, null));
        }
        presenter.onCreate();
    }

    @OnClick(R.id.btn_sign_in)
    public void signInButtonClick(){
        String username = usernameEt.getText().toString();
        String password = passwordEt.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
            presenter.signInUser(username, password);
        } else {
            showToast("Fields must not be empty");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
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
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
