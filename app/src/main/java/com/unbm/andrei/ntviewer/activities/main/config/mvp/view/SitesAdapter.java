package com.unbm.andrei.ntviewer.activities.main.config.mvp.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;
import com.unbm.andrei.ntviewer.application.network.models.Site;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrei on 4/30/2017.
 */

public class SitesAdapter extends BaseAdapter {

    private final List<Site> siteList = new ArrayList<>(0);

    @Override
    public int getCount() {
        return siteList.size();
    }

    @Override
    public Object getItem(int position) {
        return siteList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SiteItem siteItem;
        if (convertView == null) {
            siteItem = new SiteItem(parent.getContext());
        } else {
            siteItem = (SiteItem) convertView;
        }
        siteItem.setItem(siteList.get(position).getNetworkSite());
        return siteItem;
    }

    public void swapData(List<Site> sites) {
        siteList.clear();
        if (sites != null && !sites.isEmpty()) {
            siteList.addAll(sites);
        }
        notifyDataSetChanged();
    }
}
