package com.unbm.andrei.ntviewer.listeners;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.unbm.andrei.ntviewer.MapsActivity;
import com.unbm.andrei.ntviewer.R;

/**
 * Created by andrei.vancea on 2/8/2017.
 */
public class NavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

    private AppCompatActivity activity;
    private DrawerLayout drawer;

    public NavigationItemSelectedListener(AppCompatActivity activity, DrawerLayout drawer) {
        this.activity = activity;
        this.drawer = drawer;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_view_locations:
                activity.startActivity(new Intent(activity, MapsActivity.class));
                break;
            case R.id.nav_about:
                //TODO start "about" activity
                break;
            case R.id.nav_user_info:
                //TODO replace with something else
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}