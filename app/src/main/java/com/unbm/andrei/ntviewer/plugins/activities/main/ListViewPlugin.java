package com.unbm.andrei.ntviewer.plugins.activities.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.adapters.LocationsListAdapter;
import com.unbm.andrei.ntviewer.listeners.LocationListOnItemClickListener;
import com.unbm.andrei.ntviewer.model.NetworkLocation;
import com.unbm.andrei.ntviewer.plugins.activities.common.NTViewerBasePlugin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 2/27/2017.
 * <p>
 * ListView Plugin class
 */

public class ListViewPlugin extends NTViewerBasePlugin {

    private ListView mListView;
    private LocationsListAdapter mAdapter;
    private List<NetworkLocation> networkLocationList;

    public ListViewPlugin(AppCompatActivity activity) {
        super(activity);
    }

    /**
     * @param savedInstanceState Setup list items and create the adapter
     */
    @Override
    public void beforeOnCreate(Bundle savedInstanceState) {
        super.beforeOnCreate(savedInstanceState);
        networkLocationList = createTestList();    //TODO get list items from the database
        mAdapter = new LocationsListAdapter(activity, R.layout.location_list_item, networkLocationList);
    }

    /**
     * @param savedInstanceState Setup list view
     */
    @Override
    public void afterOnCreate(Bundle savedInstanceState) {
        super.afterOnCreate(savedInstanceState);
        mListView = (ListView) activity.findViewById(R.id.location_names_list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new LocationListOnItemClickListener(activity, mAdapter));
    }

    private List<NetworkLocation> createTestList() {
        List<NetworkLocation> testLocations = new ArrayList<>();
        testLocations.add(new NetworkLocation("TestLocation1"));
        testLocations.add(new NetworkLocation("TestLocation2"));
        testLocations.add(new NetworkLocation("TestLocation3"));
        return testLocations;
    }
}
