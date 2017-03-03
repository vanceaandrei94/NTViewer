package com.unbm.andrei.ntviewer.graphics;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;

import com.unbm.andrei.ntviewer.graphics.scene.camera.CameraMovement;
import com.unbm.andrei.ntviewer.graphics.scene.objects.CubeObjects;
import com.unbm.andrei.ntviewer.graphics.scene.objects.Light;

import org.rajawali3d.cameras.Camera;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.renderer.Renderer;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class SceneRenderer extends Renderer {

    private CubeObjects cubeObjects;
    private Cube cube;
    private Camera mCamera;
    private CameraMovement cameraMovement;

    public SceneRenderer(Context context) {
        super(context);
    }

    @Override
    protected void initScene() {

        cameraMovement = new CameraMovement(getCurrentCamera());
//        LIGHT
        Light light = new Light(getCurrentScene());
        light.addLight(new Vector3(0, 10f, 0), new Vector3(0, 0, -10f), new Vector3(1f, 1f, 1f), 1f);

//        CAMERA
        mCamera = getCurrentCamera();
        mCamera.setPosition(0, 4f, 0);
        mCamera.setLookAt(0, 0, -10f);

        //OBJECTS
        cubeObjects = new CubeObjects(getCurrentScene());
        cubeObjects.addCube(1, Color.GREEN, new Vector3(0, -1, -8));
        cube = cubeObjects.getCubes().get(0);
    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        cube.rotate(Vector3.Axis.Y, 1.0f);
        cube.rotate(Vector3.Axis.X, 0.5f);
        cube.rotate(Vector3.Axis.Z, 0.2f);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //TODO init camera movement
                cameraMovement.initCameraMovement(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                //TODO move camera
                cameraMovement.moveCamera(event.getX(), event.getY());
                break;
            case MotionEvent.ACTION_UP:
                //TODO reset camera movement
                cameraMovement.resetCameraMovement(event.getX(), event.getY());
                break;
        }
        try {
            //Small delay to keep touch events from overflowing and decreasing performance
            Thread.sleep(15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
