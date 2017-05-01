package com.unbm.andrei.ntviewer.activities.siteinfo.config.mvp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.unbm.andrei.ntviewer.R;

import butterknife.ButterKnife;

/**
 * Created by Andrei on 5/1/2017.
 */

public class SiteView extends FrameLayout {


    public SiteView(@NonNull Context context) {
        super(context);
        inflate(getContext(), R.layout.activity_site_info, this);
        ButterKnife.bind(this);
    }

}
