package com.unbm.andrei.ntviewer.activities.problem.config.dagger;

import com.unbm.andrei.ntviewer.activities.problem.ReportProblemActivity;
import com.unbm.andrei.ntviewer.activities.problem.config.mvp.ReportProblemModel;
import com.unbm.andrei.ntviewer.activities.problem.config.mvp.ReportProblemPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Andrei on 4/30/2017.
 */

@Module
public class ReportProblemModule {

    private final ReportProblemActivity activity;

    public ReportProblemModule(ReportProblemActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ReportProblemScope
    public ReportProblemModel provideModel() {
        return new ReportProblemModel(activity);
    }

    @Provides
    @ReportProblemScope
    public ReportProblemPresenter providePresenter(ReportProblemModel model) {
        return new ReportProblemPresenter(model);
    }
}
