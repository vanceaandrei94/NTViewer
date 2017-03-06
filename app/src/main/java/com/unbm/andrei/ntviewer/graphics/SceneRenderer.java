package com.unbm.andrei.ntviewer.graphics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.graphics.scene.objects.CubeObjects;
import com.unbm.andrei.ntviewer.graphics.scene.objects.Light;
import com.unbm.andrei.ntviewer.graphics.scene.objects.ParsedObject;

import org.rajawali3d.Object3D;
import org.rajawali3d.cameras.ArcballCamera;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.renderer.Renderer;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class SceneRenderer extends Renderer {

    private CubeObjects cubeObjects;
    private Cube cube;
    Object3D sceneObjects;
    Object3D falcon;

    public SceneRenderer(Context context) {
        super(context);
    }

    @Override
    protected void initScene() {
        sceneObjects = new Object3D();

        //LIGHT
        Light light = new Light(getCurrentScene());
        light.addLight(new Vector3(-2f, 30f, 50f), new Vector3(0, 0f, -1f), new Vector3(1f, 1f, 1f), 1f);
//        light.addLight(new Vector3(2f, -40f, 50f), new Vector3(0, 0, -50f), new Vector3(0, 1f, 0), 1f);
        //CAMERA
        ArcballCamera arcball = new ArcballCamera(mContext, ((Activity) mContext).findViewById(R.id.activity_sketch_view));
        arcball.setPosition(0, 4f, 0);
        arcball.setLookAt(0, 0, -10f);
        getCurrentScene().replaceAndSwitchCamera(getCurrentCamera(), arcball);

        //OBJECTS
        cubeObjects = new CubeObjects(sceneObjects);
        cubeObjects.addCube(1, Color.GREEN, new Vector3(0, -1, -8));
        cube = cubeObjects.getCubes().get(0);

        ParsedObject parsedObject = new ParsedObject(mContext, mTextureManager);
        falcon = parsedObject.parseObject();
        if (falcon != null) {
            falcon.setPosition(new Vector3(0, 2, -4f));
            sceneObjects.addChild(falcon);
        }

        getCurrentScene().addChild(sceneObjects);
    }

    @Override
    protected void onRender(long ellapsedRealtime, double deltaTime) {
        super.onRender(ellapsedRealtime, deltaTime);
        cube.rotate(Vector3.Axis.Y, 1.0f);
        cube.rotate(Vector3.Axis.X, 0.5f);
        cube.rotate(Vector3.Axis.Z, 0.2f);

        falcon.rotate(Vector3.Axis.Y, 1.0f);
        falcon.rotate(Vector3.Axis.X, 0.5f);
        falcon.rotate(Vector3.Axis.Z, 0.2f);
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

}
