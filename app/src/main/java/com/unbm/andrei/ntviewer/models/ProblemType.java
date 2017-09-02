package com.unbm.andrei.ntviewer.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by Andrei on 8/26/2017.
 */

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        ProblemType.PROBLEM_TYPE_EQUIPMENT_INSTALL,
        ProblemType.PROBLEM_TYPE_DECOMISSION_ISP_EQ,
        ProblemType.PROBLEM_TYPE_DECOMISSION_SUB_EQ,
        ProblemType.PROBLEM_TYPE_MALFUNCTION,
        ProblemType.PROBLEM_TYPE_NEW_CONTRACT
})
public @interface ProblemType {

    int PROBLEM_TYPE_EQUIPMENT_INSTALL = 0;
    int PROBLEM_TYPE_DECOMISSION_ISP_EQ = 1;
    int PROBLEM_TYPE_DECOMISSION_SUB_EQ = 2;
    int PROBLEM_TYPE_MALFUNCTION = 3;
    int PROBLEM_TYPE_NEW_CONTRACT = 4;

}
