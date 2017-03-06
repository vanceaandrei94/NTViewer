package com.unbm.andrei.ntviewer.listeners;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.SketchViewActivity;

/**
 * Created by andrei.vancea on 3/6/2017.
 */
public class ShowSnackBarOnMarkerClickListener implements GoogleMap.OnMarkerClickListener {

    private static final String ACTION_VIEW_SKETCH = "View Sketch";

    private Activity activity;

    public ShowSnackBarOnMarkerClickListener(Activity activity) {
        this.activity = activity;
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        //TODO get location info to display the 3D sketch model
        Snackbar snackbar = Snackbar.make(activity.findViewById(R.id.map), marker.getTitle(), Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(Color.GREEN);
        snackbar.setAction(ACTION_VIEW_SKETCH, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.startActivity(new Intent(activity, SketchViewActivity.class));
            }
        });
        snackbar.show();
        return true;
    }
}
