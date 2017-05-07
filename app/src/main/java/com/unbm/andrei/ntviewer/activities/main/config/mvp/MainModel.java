package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.siteinfo.SiteInfoActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.SRequest;
import com.unbm.andrei.ntviewer.application.network.models.Site;
import com.unbm.andrei.ntviewer.models.User;

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

    public void startViewProfileActivity(User user) {
        // start profile activity
    }

    public void startViewRequestsActivity(List<SRequest> sRequests) {
    }

    public void startViewComplaintsActivity() {
    }

    public User getLoggedInUserInfo() {
        return null;
    }

    public Observable<User> getCurrentUserInfo() {
        int userId = preferences.getInt(USER_ID_KEY, -1);
        return service.getUser(userId);
    }

    public Observable<List<SRequest>> getSubscribeRequests() {
        return service.getSRequests();
    }


}
