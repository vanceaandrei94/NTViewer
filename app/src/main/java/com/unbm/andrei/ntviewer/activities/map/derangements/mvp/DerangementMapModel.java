package com.unbm.andrei.ntviewer.activities.map.derangements.mvp;

import com.unbm.andrei.ntviewer.models.ProblemReport;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Andrei on 9/3/2017.
 */

public interface DerangementMapModel {
    Observable<List<ProblemReport>> getProblemReports();

    Observable<ProblemReport> getProblemReportInfo(int id);

    Observable<Void> resolveReport(int id);
}
