package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.storage.database.AppDatabase;
import com.unbm.andrei.ntviewer.models.ProblemReport;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class DerangementMapModel {

    private final Activity activity;

    private final NTVService service;

    public DerangementMapModel(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<ProblemReport>> getProblemReports() {
        List<ProblemReport> reports = AppDatabase.getInstance().getAllReports();
        Observable<ProblemReport> observable = Observable.fromIterable(reports);
        if (reports.size() < 1) {
            return Observable.empty();
        }
        return observable.buffer(reports.size());
    }

    public Observable<ProblemReport> getProblemReportInfo(int id) {
        ProblemReport problemReport = AppDatabase.getInstance().getReportById(id);
        return Observable.just(problemReport);
    }
}
