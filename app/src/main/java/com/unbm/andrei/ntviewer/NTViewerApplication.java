package com.unbm.andrei.ntviewer;

import android.app.Application;
import android.location.Location;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerApplication extends Application {

    private static NTViewerApplication app;
    private Location lastKnownLocation;

    public static NTViewerApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public Location getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(Location lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }
}
