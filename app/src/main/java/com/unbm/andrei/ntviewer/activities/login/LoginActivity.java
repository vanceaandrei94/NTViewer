package com.unbm.andrei.ntviewer.activities.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.activities.login.config.dagger.DaggerLoginComponent;
import com.unbm.andrei.ntviewer.activities.login.config.dagger.LoginModule;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginPresenter;
import com.unbm.andrei.ntviewer.activities.login.config.mvp.LoginView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity {

    @Inject
    LoginView view;

    @Inject
    LoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerLoginComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);

        setContentView(view);
        view.setPresenter(presenter);
        presenter.onCreate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
