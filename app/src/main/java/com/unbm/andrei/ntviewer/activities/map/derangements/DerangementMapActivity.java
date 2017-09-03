package com.unbm.andrei.ntviewer.activities.map.derangements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

public class DerangementMapActivity extends MapActivity implements DerangementMapView, GoogleMap.OnCircleClickListener, DialogHelper.ProblemReportPopup.OnDialogButtonsListener {

    private HashMap<Integer, Circle> derangementsCircleMap = new HashMap<>();

    public static void start(Context context) {
        Intent intent = new Intent(context, DerangementMapActivity.class);
        context.startActivity(intent);
    }

    @Inject
    DerangementMapPresenter<DerangementMapView> presenter;

    private Circle c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerDerangementMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .derangementMapModule(new DerangementMapModule(this))
                .build().inject(this);
        presenter.attachView(this);
        presenter.onCreate();
        getSupportActionBar().setTitle("Coverage Map");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);
        map.setOnCircleClickListener(this);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView();
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void drawDerangements(List<ProblemReport> derangements) {
        for (ProblemReport derangement : derangements) {
            Circle circle = map.addCircle(new CircleOptions()
                    .center(new LatLng(derangement.getLat(), derangement.getLon()))
                    .radius(50)
                    .fillColor(ColorUtil.getPriorityColor(derangement.getProblemPriority(), 70))
                    .strokeWidth(0)
                    .clickable(true));
            circle.setTag(derangement.getId());
            derangementsCircleMap.put(derangement.getId(), circle);
        }
    }

    @Override
    public void showDerangementInfo(ProblemReport problemReport) {
        DialogHelper.ProblemReportPopup prp = new DialogHelper.ProblemReportPopup(this, problemReport);
        prp.showProblemReportInfo();
    }

    @Override
    public void onCircleClick(Circle circle) {
        presenter.onShowDerangementInfo(circle.getTag());
    }

    @Override
    public void onResolveButtonClick(int id) {
        c = derangementsCircleMap.get(id);
        presenter.onResolveDerangement(id);
    }

    @Override
    public void showResolvedSuccess() {
        c.remove();
        Toast.makeText(this, "Derangement resolved", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorResolvingDerangement() {
        Toast.makeText(this, "Failed to resolve derangement, please try again later.", Toast.LENGTH_SHORT).show();
    }
}
