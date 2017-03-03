package com.unbm.andrei.ntviewer.graphics.scene.objects;


import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.math.vector.Vector3;
import org.rajawali3d.primitives.Cube;
import org.rajawali3d.scene.Scene;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrei.vancea on 3/3/2017.
 */

public class CubeObjects {

    private Scene scene;
    private List<Cube> cubes;

    public CubeObjects(Scene scene) {
        this.scene = scene;
        cubes = new ArrayList<>();
    }

    public void addCube(float size, int color, Vector3 position) {
        Cube cube = new Cube(size);
        Material material = new Material();
        material.setColor(color);
        material.enableLighting(true);
        material.setDiffuseMethod(new DiffuseMethod.Lambert());
        cube.setMaterial(material);
        cube.setPosition(position);
        cubes.add(cube);
        scene.addChild(cube);
    }

    public List<Cube> getCubes() {
        return cubes;
    }
}
