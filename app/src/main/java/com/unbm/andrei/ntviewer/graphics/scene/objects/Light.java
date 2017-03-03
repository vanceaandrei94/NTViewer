package com.unbm.andrei.ntviewer.graphics.scene.objects;

import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.scene.Scene;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class Light {
    private Scene scene;

    public Light(Scene scene) {
        this.scene = scene;
    }

    public void addLight(Vector3 position, Vector3 direction, Vector3 color, float power) {
        DirectionalLight directionalLight = new DirectionalLight(direction.x, direction.y, direction.z);
        directionalLight.setPosition(position);
        directionalLight.setColor(color);
        directionalLight.setPower(power);
        scene.addLight(directionalLight);
    }
}
