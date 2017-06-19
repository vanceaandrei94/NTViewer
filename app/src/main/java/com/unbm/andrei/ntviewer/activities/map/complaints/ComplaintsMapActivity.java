package com.unbm.andrei.ntviewer.activities.map.complaints;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.map.base.MapActivity;
import com.unbm.andrei.ntviewer.activities.map.complaints.dagger.ComplaintsMapModule;
import com.unbm.andrei.ntviewer.activities.map.complaints.dagger.DaggerComplaintsMapComponent;
import com.unbm.andrei.ntviewer.activities.map.complaints.mvp.ComplaintsMapPresenter;
import com.unbm.andrei.ntviewer.activities.map.complaints.mvp.IComplaintsMapView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.Complaint;
import com.unbm.andrei.ntviewer.util.ColorUtil;

import java.util.List;

import javax.inject.Inject;

public class ComplaintsMapActivity extends MapActivity implements IComplaintsMapView {

    public static void start(Context context) {
        Intent intent = new Intent(context, ComplaintsMapActivity.class);
        context.startActivity(intent);
    }

    @Inject
    ComplaintsMapPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerComplaintsMapComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .complaintsMapModule(new ComplaintsMapModule(this))
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
    public void drawCoverage(List<Complaint> complaints) {
        for (Complaint complaint : complaints) {
            map.addCircle(new CircleOptions()
                    .center(new LatLng(complaint.getLat(), complaint.getLon()))
                    .fillColor(ColorUtil.getPriorityColor(complaint.getPriority(), 70))
                    .strokeWidth(0)
                    .radius(25));

        }
    }
}
