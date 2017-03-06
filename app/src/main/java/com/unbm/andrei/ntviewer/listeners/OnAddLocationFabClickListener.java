package com.unbm.andrei.ntviewer.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.unbm.andrei.ntviewer.MapsActivity;

/**
 * Created by andrei.vancea on 2/27/2017.
 */
public class OnAddLocationFabClickListener implements View.OnClickListener {

    private static final String TAG = "FabClickListener";
    private AppCompatActivity activity;

    public OnAddLocationFabClickListener(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "Add new location fab clicked.");
        activity.startActivity(new Intent(activity, MapsActivity.class));
    }
}
