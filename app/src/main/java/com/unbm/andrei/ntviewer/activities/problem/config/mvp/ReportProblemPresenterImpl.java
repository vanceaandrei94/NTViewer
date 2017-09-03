package com.unbm.andrei.ntviewer.activities.problem.config.mvp;

import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.models.ProblemReport;
import com.unbm.andrei.ntviewer.util.LocationProvider;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Andrei on 7/15/2017.
 */

public class ReportProblemPresenterImpl implements ReportProblemPresenter<ReportProblemView> {

    private final ReportProblemModel model;
    private ReportProblemView view;

    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ReportProblemPresenterImpl(ReportProblemModel model) {
        this.model = model;
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDestroy() {
        compositeDisposable.dispose();
    }

    public void reportProblem() {
        view.setBusy(true);
        ProblemReport problemReport = new ProblemReport();
        problemReport.setProblemType(view.getViewModel().problemType);
        problemReport.setProblemPriority(view.getViewModel().problemPriority);
        problemReport.setProblemDetails(view.getViewModel().problemDetails);
        problemReport.setReportedAt(view.getViewModel().reportedAt);
        LatLng location = LocationProvider.getInstance().getCurrentLocation();
        problemReport.setLat(location.latitude);
        problemReport.setLon(location.longitude);
        problemReport.setActive(true);
        model.saveReport(problemReport);
        view.setBusy(false);
        view.finishActivity();
    }

    @Override
    public void attachView(ReportProblemView reportProblemView) {
        this.view = reportProblemView;
    }

    @Override
    public void detachView() {
        view = null;
    }
}
