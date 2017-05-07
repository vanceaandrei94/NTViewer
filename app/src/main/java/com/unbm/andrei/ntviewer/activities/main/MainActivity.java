package com.unbm.andrei.ntviewer.activities.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.DaggerMainComponent;
import com.unbm.andrei.ntviewer.activities.main.config.dagger.MainModule;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.MainPresenter;
import com.unbm.andrei.ntviewer.activities.main.config.mvp.view.MainView;
import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.Site;
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
        presenter.onCreate();
        getSupportActionBar().setTitle("Profile");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
