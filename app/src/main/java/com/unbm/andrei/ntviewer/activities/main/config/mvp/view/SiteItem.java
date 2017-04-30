package com.unbm.andrei.ntviewer.activities.main.config.mvp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.FrameLayout;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;

import butterknife.ButterKnife;

/**
 * Created by Andrei on 4/30/2017.
 */

public class SiteItem extends FrameLayout {

    // TODO: 4/30/2017 bind the views here

    public SiteItem(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.site_list_item, this);
        ButterKnife.bind(this);
    }

    public void setItem(NetworkSite networkSite) {
        // TODO: 4/30/2017 add a network site for showing
    }
}
