package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.coveragemap.CoverageMapActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 4/30/2017.
 */

public class MainModel {

    private static final String USER_LOGIN_PREFS = "userLogin";
    private static final String USER_ID_KEY = "user_id";
    private NTVService service;
    private Activity activity;
    private SharedPreferences preferences;


    public MainModel(NTVService service, MainActivity activity) {
        this.service = service;
        this.activity = activity;
        preferences = activity.getSharedPreferences(USER_LOGIN_PREFS, Context.MODE_PRIVATE);

    }

    public void startMapCoverageActivity() {
        CoverageMapActivity.start(activity);
    }


}
