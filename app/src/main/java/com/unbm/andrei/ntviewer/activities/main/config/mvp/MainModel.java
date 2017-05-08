package com.unbm.andrei.ntviewer.activities.main.config.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.unbm.andrei.ntviewer.activities.main.MainActivity;
import com.unbm.andrei.ntviewer.activities.sitesmap.SitesMapActivity;
import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.Complaint;
import com.unbm.andrei.ntviewer.application.network.models.SRequest;
import com.unbm.andrei.ntviewer.application.network.models.Site;
import com.unbm.andrei.ntviewer.models.User;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

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
        // TODO: 5/8/2017 make ProfileActivity and start it from here
    }

    public void startViewRequestsActivity(List<SRequest> sRequests) {
        // TODO: 5/8/2017 make SubscribeRequestsActivity and start it from here
    }

    public void startViewComplaintsActivity(List<Complaint> complaints) {
        // TODO: 5/8/2017 make ComplaintsActivity and start it from here
    }

    public void startSitesMapActivity(List<Site> sites) {
        SitesMapActivity.start(activity, sites);
    }

    public Observable<User> getCurrentUserInfo() {
        int userId = preferences.getInt(USER_ID_KEY, -1);
        return service.getUser(userId);
    }


    public Observable<List<SRequest>> getSubscribeRequests() {
        return service.getSRequests();
    }

    public Observable<List<Site>> getAllSites() {
        return service.getAllSites();
    }

    public Observable<List<Complaint>> getComplaints() {
        return service.getComplaints();
    }
}
