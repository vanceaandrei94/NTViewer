package com.unbm.andrei.ntviewer.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Andrei on 8/26/2017.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        PriorityType.PRIORITY_URGENT,
        PriorityType.PRIORITY_BLOCKED,
        PriorityType.PRIORITY_LOW,
        PriorityType.PRIORITY_HIGH
})

public @interface PriorityType {

    int PRIORITY_URGENT = 0;
    int PRIORITY_BLOCKED = 1;
    int PRIORITY_LOW = 2;
    int PRIORITY_HIGH = 3;

}
