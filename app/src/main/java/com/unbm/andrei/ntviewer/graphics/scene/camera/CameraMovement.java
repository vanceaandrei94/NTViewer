package com.unbm.andrei.ntviewer.graphics.scene.camera;

import org.rajawali3d.cameras.Camera;

/**
 * Created by andrei.vancea on 3/3/2017.
 * <p>
 * Class for updating camera position/lookAt
 */
public class CameraMovement {

    private Camera camera;


    public CameraMovement(Camera camera) {
        this.camera = camera;
    }

    public void initCameraMovement(float x, float y) {
        //TODO set the camera parameters and other variables needed for camera movement
    }

    public void moveCamera(float x, float y) {
        //TODO move camera
    }

    public void resetCameraMovement(float x, float y) {
        //TODO reset camera paramaters and other variables needed for camera movement
    }
}
