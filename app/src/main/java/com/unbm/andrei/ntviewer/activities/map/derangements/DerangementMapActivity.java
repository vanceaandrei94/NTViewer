package com.unbm.andrei.ntviewer.activities.map.derangements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.activities.map.base.MapActivity;
import com.unbm.andrei.ntviewer.activities.map.derangements.dagger.DaggerDerangementMapComponent;
import com.unbm.andrei.ntviewer.activities.map.derangements.dagger.DerangementMapModule;
import com.unbm.andrei.ntviewer.activities.map.derangements.mvp.DerangementMapPresenter;
import com.unbm.andrei.ntviewer.activities.map.derangements.mvp.DerangementMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.models.ProblemReport;
import com.unbm.andrei.ntviewer.util.ColorUtil;
import com.unbm.andrei.ntviewer.util.DialogHelper;

import java.util.List;

import javax.inject.Inject;

public class DerangementMapActivity extends MapActivity implements DerangementMapView, GoogleMap.OnCircleClickListener {

    public static void start(Context context) {
        Intent intent = new Intent(context, DerangementMapActivity.class);
        context.startActivity(intent);
    }

    @Inject
    DerangementMapPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerDerangementMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .derangementMapModule(new DerangementMapModule(this))
                .build().inject(this);

        presenter.onCreate();
        getSupportActionBar().setTitle("Coverage Map");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void drawDerangements(List<ProblemReport> derangements) {
        for (ProblemReport derangement : derangements) {
            Circle circle = map.addCircle(new CircleOptions()
                    .center(new LatLng(derangement.getLat(), derangement.getLon()))
                    .fillColor(ColorUtil.getPriorityColor(derangement.getProblemPriority(), 70))
                    .strokeWidth(0)
                    .clickable(true)
                    .radius(25));
            circle.setTag(derangement.getId());
        }
    }

    @Override
    public void showDerangementInfo(ProblemReport problemReport) {
        DialogHelper.showProblemReportInfo(this, problemReport);
    }

    @Override
    public void onCircleClick(Circle circle) {
        presenter.onShowDerangementInfo(circle.getTag());
    }
}
