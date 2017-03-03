package com.unbm.andrei.ntviewer.listeners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.unbm.andrei.ntviewer.SketchViewActivity;
import com.unbm.andrei.ntviewer.adapters.LocationsListAdapter;

/**
 * Created by andrei.vancea on 2/27/2017.
 */
public class LocationListOnItemClickListener implements AdapterView.OnItemClickListener {

    private static final String TAG = "ListViewClickedListener";
    private AppCompatActivity activity;
    private LocationsListAdapter adapter;

    public LocationListOnItemClickListener(AppCompatActivity activity, LocationsListAdapter mAdapter) {
        this.activity = activity;
        this.adapter = mAdapter;
    }

    /**
     * Each item starts the 3D Sketch View Activity for showing the 3D model of the network topology it holds
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(TAG, "ListView Item clicked!");
        //TODO send data associated with the list item location
        //get the data by making a http request to the server that holds the data
        //start activity only if the request succeeds else show a message that the network isn't available
        activity.startActivity(new Intent(activity, SketchViewActivity.class));
    }
}
