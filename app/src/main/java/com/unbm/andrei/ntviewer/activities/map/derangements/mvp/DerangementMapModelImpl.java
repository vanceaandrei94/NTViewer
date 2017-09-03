package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import android.app.Activity;

import com.unbm.andrei.ntviewer.application.network.NTVService;
import com.unbm.andrei.ntviewer.application.storage.database.AppDatabase;
import com.unbm.andrei.ntviewer.models.ProblemReport;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by andrei.vancea on 5/8/2017.
 */

public class DerangementMapModelImpl implements DerangementMapModel {

    private final Activity activity;

    private final NTVService service;

    public DerangementMapModelImpl(Activity activity, NTVService service) {
        this.activity = activity;
        this.service = service;
    }

    public Observable<List<ProblemReport>> getProblemReports() {
        List<ProblemReport> reports = AppDatabase.getInstance().getAllReports();
        List<ProblemReport> activeReports = new ArrayList<>();
        for (ProblemReport report : reports) {
            if (report.isActive()) {
                activeReports.add(report);
            }
        }
        Observable<ProblemReport> observable = Observable.fromIterable(activeReports);
        if (reports.size() < 1) {
            return Observable.empty();
        }
        return observable.buffer(reports.size());
    }

    public Observable<ProblemReport> getProblemReportInfo(int id) {
        ProblemReport problemReport = AppDatabase.getInstance().getReportById(id);
        return Observable.just(problemReport);
    }

    public Observable<Void> resolveReport(int id) {
        AppDatabase.getInstance().resolveReport(id);
        return Observable.empty();
    }
}
