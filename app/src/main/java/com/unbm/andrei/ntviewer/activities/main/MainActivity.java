package com.unbm.andrei.ntviewer.activities.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.unbm.andrei.ntviewer.activities.main.config.dagger.DaggerMainComponent;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.MainModule;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.models.User;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private static final String USER = "user";

    public static void start(Context context, User user) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(USER, user);
        context.startActivity(intent);
    }

    @Inject
    MainView view;

    @Inject
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .mainModule(new MainModule(this))
                .build().inject(this);

        setContentView(view);
        view.setPresenter(presenter);
        presenter.onCreate();
        getSupportActionBar().setTitle("NTViewer");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

}
