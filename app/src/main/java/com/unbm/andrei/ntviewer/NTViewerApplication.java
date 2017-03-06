package com.unbm.andrei.ntviewer;

import android.app.Application;

import com.unbm.andrei.ntviewer.db.DBOperations;
import com.unbm.andrei.ntviewer.model.NetworkLocation;

import java.util.List;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerApplication extends Application {

    private static NTViewerApplication app;
    private DBOperations dbOperations;
    private List<NetworkLocation> locations;

    public static NTViewerApplication getInstance() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        dbOperations = new DBOperations(this);
        this.locations = dbOperations.getLocations();
    }

    public List<NetworkLocation> getLocationList() {
        return locations;
    }

    public DBOperations getDbOperations() {
        return dbOperations;
    }
}
