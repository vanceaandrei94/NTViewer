package com.unbm.andrei.ntviewer.plugins.activities.common;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public abstract class NTViewerBasePlugin extends Plugin {

    public AppCompatActivity activity;

    public NTViewerBasePlugin(AppCompatActivity activity) {
        this.activity = activity;
    }
}
