package com.unbm.andrei.ntviewer.activities.main.config.mvp.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.DrawableUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Andrei on 4/30/2017.
 */

public class SiteItem extends FrameLayout {

    private static final String QUALITY_GOOD = "good";
    private static final String QUALITY_AVERAGE = "average";
    private static final String QUALITY_BAD = "bad";

    // TODO: 4/30/2017 bind the views here
    @BindView(R.id.site_name)
    TextView siteName;

    @BindView(R.id.site_quality)
    TextView siteQuality;

    @BindView(R.id.site_badge)
    View siteBadge;

    public SiteItem(@NonNull Context context) {
        super(context);
        inflate(context, R.layout.site_list_item, this);
        ButterKnife.bind(this);
    }

    public void setItem(NetworkSite networkSite) {
        siteName.setText(networkSite.getName());
        String quality = networkSite.getQuality();
        switch (quality) {
            case QUALITY_GOOD:
                siteQuality.setText(QUALITY_GOOD);
                siteBadge.setBackgroundResource(R.drawable.badge_good);
                break;
            case QUALITY_AVERAGE:
                siteQuality.setText(QUALITY_AVERAGE);
                siteBadge.setBackgroundResource(R.drawable.badge_average);
                break;
            case QUALITY_BAD:
                siteQuality.setText(QUALITY_BAD);
                siteBadge.setBackgroundResource(R.drawable.badge_bad);
                break;
        }
    }
}
