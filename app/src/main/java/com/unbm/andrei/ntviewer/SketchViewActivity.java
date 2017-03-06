package com.unbm.andrei.ntviewer;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.unbm.andrei.ntviewer.graphics.SceneRenderer;

import org.rajawali3d.view.ISurface;
import org.rajawali3d.view.SurfaceView;

public class SketchViewActivity extends AppCompatActivity implements View.OnTouchListener {

    private SceneRenderer renderer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sketch_view);

        SurfaceView surfaceView = new SurfaceView(this);
        surfaceView.setFrameRate(60.0);
        surfaceView.setRenderMode(ISurface.RENDERMODE_WHEN_DIRTY);
        surfaceView.setOnTouchListener(this);

        addContentView(surfaceView, new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT));

        renderer = new SceneRenderer(this);
        surfaceView.setSurfaceRenderer(renderer);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        renderer.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
