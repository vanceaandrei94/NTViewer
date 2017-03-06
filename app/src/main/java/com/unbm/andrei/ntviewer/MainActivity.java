package com.unbm.andrei.ntviewer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.unbm.andrei.ntviewer.adapters.LocationsListAdapter;
import com.unbm.andrei.ntviewer.listeners.LocationListOnItemClickListener;
import com.unbm.andrei.ntviewer.listeners.NavigationItemSelectedListener;
import com.unbm.andrei.ntviewer.listeners.OnAddLocationFabClickListener;
import com.unbm.andrei.ntviewer.model.NetworkLocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.unbm.andrei.ntviewer.MapsActivity.LOCATION_PERMISSIONS_REQUEST_CODE;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mListView;
    private LocationsListAdapter mAdapter;
    private List<NetworkLocation> networkLocationList;
    private Map<Integer, NetworkLocation> selectedLocations;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        selectedLocations = new HashMap<>();
        setupUI();
        setupListView();
        checkPermissions();
    }

    private void setupListView() {
        networkLocationList = NTViewerApplication.getInstance().getLocationList();
        mAdapter = new LocationsListAdapter(this, R.layout.location_list_item, networkLocationList);
        mListView = (ListView) this.findViewById(R.id.location_names_list);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new LocationListOnItemClickListener(this, mAdapter));
        mListView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                View v = mListView.getChildAt(position);
                makeCheckboxChecked(v, position, checked);
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.menu_action_mode, menu);
                selectedLocations.clear();
                setListHandlesVisibleState(true);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_delete:
                        deleteSelectedLocations();
                        mode.finish();
                        return true;
                    case R.id.action_cancel:
                        mode.finish();
                        return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                setListHandlesVisibleState(false);
                selectedLocations.clear();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void checkPermissions() {
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSIONS_REQUEST_CODE);
        }
    }

    private void setupUI() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnAddLocationFabClickListener(this));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationItemSelectedListener(this, drawer));

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                drawer,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        );
        drawer.addDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        refreshLocationList();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
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

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setListHandlesVisibleState(boolean state) {
        AnimatorSet multiSelectCheckboxAnimator = new AnimatorSet();
        int childCount = mListView.getChildCount();
        ArrayList<Animator> list = new ArrayList<>();
        for (int i = 0; i < childCount; ++i) {
            CheckBox checkBox = (CheckBox) mListView.getChildAt(i).findViewById(
                    R.id.note_checkbox);
            LinearLayout itemContainer = (LinearLayout) mListView.getChildAt(i).findViewById(
                    R.id.item_container);
            if (state) {
                checkBox.setVisibility(View.VISIBLE);
                list.add(ObjectAnimator.ofFloat(checkBox, "x", -checkBox.getWidth(),
                        checkBox.getLeft()));
                list.add(ObjectAnimator.ofFloat(checkBox, "alpha", 0, 1));
                list.add(ObjectAnimator.ofFloat(itemContainer, "x", itemContainer.getLeft(),
                        (float) (checkBox.getWidth() * 0.9)));
            } else {
                selectedLocations.clear();
                checkBox.setVisibility(View.INVISIBLE);
                checkBox.setChecked(false);
                list.add(ObjectAnimator.ofFloat(checkBox, "x", checkBox.getLeft(),
                        -checkBox.getWidth()));
                list.add(ObjectAnimator.ofFloat(checkBox, "alpha", 1, 0));
                list.add(ObjectAnimator.ofFloat(itemContainer, "x",
                        (float) (checkBox.getWidth() * 0.9), itemContainer.getLeft()));
            }
        }
//        multiSelectCheckboxAnimator.addListener(this);
        multiSelectCheckboxAnimator.playTogether(list);
        multiSelectCheckboxAnimator.setDuration(200);
        multiSelectCheckboxAnimator.start();
    }

    private void makeCheckboxChecked(View view, int position, boolean checked) {
        CheckBox checkBox = (CheckBox) view.findViewById(R.id.note_checkbox);
        checkBox.setChecked(checked);
        if (checked) {
            selectedLocations.put(position, networkLocationList.get(position));
        } else {
            selectedLocations.remove(position);
        }
    }

    private void deleteSelectedLocations() {
        for (Integer key : selectedLocations.keySet()) {
            NTViewerApplication.getInstance().getDbOperations().delete(selectedLocations.get(key));
            networkLocationList.remove(selectedLocations.get(key));
            mAdapter.notifyDataSetChanged();
        }
    }

    private void refreshLocationList() {
        List<NetworkLocation> locations = NTViewerApplication.getInstance().getDbOperations().getLocations();
        networkLocationList.clear();
        for (NetworkLocation location : locations) {
            networkLocationList.add(location);
        }
        mAdapter.notifyDataSetChanged();
    }

}
