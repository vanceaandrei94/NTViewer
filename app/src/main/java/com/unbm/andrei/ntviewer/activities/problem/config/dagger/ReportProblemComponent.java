package com.unbm.andrei.ntviewer.activities.problem.config.dagger;

import com.unbm.andrei.ntviewer.activities.problem.ReportProblemActivity;
import com.unbm.andrei.ntviewer.application.dagger.AppComponent;

import dagger.Component;

/**
 * Created by Andrei on 4/30/2017.
 */
@ReportProblemScope
@Component(modules = ReportProblemModule.class, dependencies = AppComponent.class)
public interface ReportProblemComponent {

    void inject(ReportProblemActivity activity);
}
