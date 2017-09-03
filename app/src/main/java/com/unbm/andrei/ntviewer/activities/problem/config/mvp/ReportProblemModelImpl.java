package com.unbm.andrei.ntviewer.activities.problem.config.mvp;

import com.unbm.andrei.ntviewer.activities.problem.ReportProblemActivity;
import com.unbm.andrei.ntviewer.application.storage.database.AppDatabase;
import com.unbm.andrei.ntviewer.models.ProblemReport;

/**
 * Created by Andrei on 7/15/2017.
 */

public class ReportProblemModelImpl implements ReportProblemModel {

    private final ReportProblemActivity activity;

    public ReportProblemModelImpl(ReportProblemActivity activity) {
        this.activity = activity;
    }

    public void saveReport(ProblemReport problemReport) {

        AppDatabase.getInstance().saveProblemReport(problemReport);
    }
}
