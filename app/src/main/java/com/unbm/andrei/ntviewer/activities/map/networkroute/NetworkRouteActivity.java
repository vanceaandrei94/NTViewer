package com.unbm.andrei.ntviewer.activities.map.networkroute;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.activities.map.base.MapActivity;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger.DaggerNetworkRouteComponent;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.dagger.NetworkRouteModule;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRoutePresenter;
import com.unbm.andrei.ntviewer.activities.map.networkroute.config.mvp.NetworkRouteView;
import com.unbm.andrei.ntviewer.application.NTViewerApplication;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.LinePoint;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NetworkRoute;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.Node;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeType;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.Route;
import com.unbm.andrei.ntviewer.util.DialogHelper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Andrei on 6/19/2017.
 */

public class NetworkRouteActivity extends MapActivity implements NetworkRouteView {

    private static final String TAG = "NetworkRouteActivity";

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, NetworkRouteActivity.class);
        activity.startActivity(intent);
    }

    private ProgressDialog progressDialog;

    @Inject
    NetworkRoutePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Retrieving data about this node");
        DaggerNetworkRouteComponent.builder()
                .appComponent(NTViewerApplication.get(this).getComponent())
                .networkRouteModule(new NetworkRouteModule(this))
                .build().inject(this);

        presenter.onCreate();
        getSupportActionBar().setTitle(getResources().getString(R.string.network_route_title));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        map.setOnPolygonClickListener(polygon -> presenter.getInfoForNode(String.valueOf(polygon.getTag())));
        map.setOnCircleClickListener(circle -> presenter.getInfoForNode(String.valueOf(circle.getTag())));
//        map.setOnPolygonClickListener(polygon -> Toast.makeText(this, "Polygon Clicked", Toast.LENGTH_SHORT).show());
//        map.setOnCircleClickListener(circle -> Toast.makeText(this, "Circle Clicked", Toast.LENGTH_SHORT).show());
    }

    @Override
    public void drawNetworkRoutes(List<NetworkRoute> routes) {
        Log.d(TAG, "drawing Network Routes");
        for (NetworkRoute networkRoute : routes) {
            for (Route route : networkRoute.getRoutes()) {
                drawRoute(route);
            }
            for (Node node : networkRoute.getNodes()) {
                drawNode(node);
            }
        }
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            progressDialog.show();
        } else {
            progressDialog.dismiss();
        }
    }

    @Override
    public void showNodeInfoPopup(NodeInfo nodeInfo) {
        DialogHelper.showNodeInfoDialog(this, nodeInfo);
    }

    private void drawNode(Node node) {
        NodeType nodeType = NodeType.valueOf(node.getType().toUpperCase());
        switch (nodeType) {
            case BIG_BUILDING:
                map.addPolygon(new PolygonOptions()
                        .clickable(true)
                        .add(new LatLng(node.getLat() - 0.000300, node.getLon() - 0.000250))
                        .add(new LatLng(node.getLat() + 0.000300, node.getLon() - 0.000250))
                        .add(new LatLng(node.getLat() + 0.000300, node.getLon() + 0.000250))
                        .add(new LatLng(node.getLat() - 0.000300, node.getLon() + 0.000250))
                        .strokeWidth(0)
                        .fillColor(nodeType.getColor())
                ).setTag(node.getNodeId());
                break;
            case SWITCH_EPON:
                map.addPolygon(new PolygonOptions()
                        .clickable(true)
                        .fillColor(nodeType.getColor())
                        .strokeWidth(0)
                        .add(new LatLng(node.getLat() - 0.000180, node.getLon() - 0.000140))
                        .add(new LatLng(node.getLat() + 0.000180, node.getLon() - 0.000140))
                        .add(new LatLng(node.getLat(), node.getLon() + 0.000140))
                ).setTag(node.getNodeId());
                break;
            case SWITCH:
                map.addPolygon(new PolygonOptions()
                        .fillColor(nodeType.getColor())
                        .strokeWidth(0)
                        .add(new LatLng(node.getLat() - 0.000180, node.getLon() - 0.000140))
                        .add(new LatLng(node.getLat() + 0.000180, node.getLon() - 0.000140))
                        .add(new LatLng(node.getLat(), node.getLon() + 0.000140))
                ).setTag(node.getNodeId());
                break;
            case SUBSCRIBER:
                map.addCircle(new CircleOptions()
                        .clickable(true)
                        .radius(30)
                        .strokeWidth(0)
                        .fillColor(nodeType.getColor())
                        .center(new LatLng(node.getLat(), node.getLon()))
                ).setTag(node.getNodeId());
                break;
        }
    }

    private void drawRoute(Route route) {
        List<Pair<Double, Double>> points = new ArrayList<>();
        if (route.getLine() != null) {
            for (LinePoint line : route.getLine()) {
                points.add(new Pair<>(line.getLat(), line.getLon()));
            }
        }
        PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.color(route.isRouteOk() ? Color.GREEN : Color.RED);
        polylineOptions.width(8f);
        for (Pair<Double, Double> point : points) {
            polylineOptions.add(new LatLng(point.first, point.second));
        }
        map.addPolyline(polylineOptions);
    }
}
