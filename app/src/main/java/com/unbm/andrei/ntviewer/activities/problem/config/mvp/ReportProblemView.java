package com.unbm.andrei.ntviewer.activities.problem.config.mvp;

import com.unbm.andrei.ntviewer.activities.problem.ReportProblemViewModel;

/**
 * Created by Andrei on 7/15/2017.
 */

public interface ReportProblemView {

    void setBusy(boolean busy);

    ReportProblemViewModel getViewModel();

    void finishActivity();
}
