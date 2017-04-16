package com.unbm.andrei.ntviewer.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.unbm.andrei.ntviewer.R;
import com.unbm.andrei.ntviewer.model.NetworkSite;

/**
 * Created by andrei.vancea on 2/27/2017.
 */

public class SiteListAdapter extends ArrayAdapter<NetworkSite> {

    private static final String SERVER_AVAILABLE = "available";
    private static final String SERVER_UNAVAILABLE = "unavailable";

    public SiteListAdapter(Context context, int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater li;
            li = LayoutInflater.from(getContext());
            v = li.inflate(R.layout.location_list_item, null);
        }

        NetworkSite location = getItem(position);

        TextView name = (TextView) v.findViewById(R.id.list_location_name);
        TextView availability = (TextView) v.findViewById(R.id.list_server_availability);
        if (name != null) {
            name.setText("testName");
        }

        return v;
    }
}
