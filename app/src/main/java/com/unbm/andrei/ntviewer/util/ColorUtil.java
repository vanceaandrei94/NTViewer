package com.unbm.andrei.ntviewer.util;

import android.graphics.Color;

import com.unbm.andrei.ntviewer.models.PriorityType;

/**
 * Created by Andrei on 6/5/2017.
 */

public class ColorUtil {

    public static int getColorFromString(String color, float opacity) {
        int c = Color.parseColor(color);
        return Color.argb((int) (opacity / 100f * 255f), Color.red(c), Color.green(c), Color.blue(c));
    }

    public static int getPriorityColor(@PriorityType int priority, int opacity) {

        switch (priority) {
            default:
            case PriorityType.PRIORITY_LOW:
                return Color.argb((int) (opacity / 100f * 255f), 255, 0, 0);
            case PriorityType.PRIORITY_BLOCKED:
            case PriorityType.PRIORITY_URGENT:
                return Color.argb((int) (opacity / 100f * 255f), 0, 255, 0);
            case PriorityType.PRIORITY_HIGH:
                return Color.argb((int) (opacity / 100f * 255f), 255, 255, 0);
        }
    }
}
