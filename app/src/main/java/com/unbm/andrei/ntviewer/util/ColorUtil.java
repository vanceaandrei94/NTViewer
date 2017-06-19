package com.unbm.andrei.ntviewer.util;

import android.graphics.Color;

/**
 * Created by Andrei on 6/5/2017.
 */

public class ColorUtil {

    public static int getColorFromString(String color, float opacity) {
        int c = Color.parseColor(color);
        return Color.argb((int) (opacity / 100f * 255f), Color.red(c), Color.green(c), Color.blue(c));
    }

    public static int getPriorityColor(int priority, int opacity) {
        if (priority < 40) {
            return Color.argb((int) (opacity / 100f * 255f), 0, 255, 0);
        } else if (priority < 80) {
            return Color.argb((int) (opacity / 100f * 255f), 255, 255, 0);
        } else {
            return Color.argb((int) (opacity / 100f * 255f), 255, 0, 0);
        }
    }
}
