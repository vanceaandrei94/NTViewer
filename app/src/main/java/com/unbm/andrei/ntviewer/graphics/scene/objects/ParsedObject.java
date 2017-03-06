package com.unbm.andrei.ntviewer.graphics.scene.objects;

import android.content.Context;
import android.graphics.Color;
import android.opengl.GLES20;

import com.unbm.andrei.ntviewer.R;

import org.rajawali3d.Object3D;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.loader.ParsingException;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.ATexture;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.materials.textures.TextureManager;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class ParsedObject {

    private Context context;
    private TextureManager manager;

    public ParsedObject(Context context, TextureManager manager) {
        this.context = context;
        this.manager = manager;
    }

    public Object3D parseObject() {
        LoaderOBJ loaderOBJ = new LoaderOBJ(context.getResources(), manager, R.raw.shuttle_obj);
        try {
            loaderOBJ.parse();
            Object3D parsedObject = loaderOBJ.getParsedObject();
            Material material = new Material();
            material.setColor(Color.GREEN);
            material.enableLighting(true);
            material.setDiffuseMethod(new DiffuseMethod.Lambert());
            material.setColorInfluence(0);
//            parsedObject.setDrawingMode(GLES20.GL_LINES);
            parsedObject.setMaterial(material);
            parsedObject.setScale(0.01f);
            return parsedObject;
        } catch (ParsingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
