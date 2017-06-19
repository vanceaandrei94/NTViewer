package com.unbm.andrei.ntviewer.activities.map.complaints.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.network.models.Complaint;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class ComplaintsMapModel {

    private final Activity activity;

    private final NTVService service;

    public ComplaintsMapModel(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<Complaint>> getComplaints() {
        return service.getComplaints();
    }
}
