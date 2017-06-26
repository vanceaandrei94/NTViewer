package com.unbm.andrei.ntviewer.application.network.models.networkroute;

import android.graphics.Color;

/**
 * Created by Andrei on 6/21/2017.
 */

public enum NodeType {

    BIG_BUILDING("big_building", Color.argb(100, 255, 0, 0)),
    SWITCH_EPON("switch_epon", Color.argb(100,255, 165, 0)),
    SWITCH("switch", Color.argb(100, 0, 0, 255)),
    SUBSCRIBER("subscriber", Color.argb(100, 0, 255, 0));

    private String value;
    private int color;

    NodeType(String value, int color) {
        this.value = value;
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public int getColor() {
        return color;
    }

}
