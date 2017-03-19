package com.unbm.andrei.ntviewer.db;

import android.provider.BaseColumns;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerContract {

    private NTViewerContract() {
    }

    public static class LocationsTable implements BaseColumns {
        public static final String LOCATIONS_TABLE_NAME = "locations";
        public static final String COLUMN_NAME_LOCATION_NAME = "name";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LON = "lon";
        public static final String COLUMN_NAME_NETWORK_ID = "network_id";
        public static final String[] PROJECTION_GET_LOCATIONS = {_ID, COLUMN_NAME_LOCATION_NAME, COLUMN_NAME_LAT, COLUMN_NAME_LON, COLUMN_NAME_NETWORK_ID};
    }

    public static class NetworksTable implements BaseColumns {
        public static final String NETWORKS_TABLE_NAME = "networks";
        public static final String COLUMN_NAME_NETWORK_NAME = "name";
        public static final String COLUMN_NAME_ENDPOINT_ADDRESS = "endpoint";
        public static final String COLUMN_NAME_ADDED_AT = "added_at";
        public static final String COLUMN_NAME_LOCATION_ID = "location_id";
        public static final String[] PROJECTION_GET_NETWORKS = {_ID, COLUMN_NAME_NETWORK_NAME, COLUMN_NAME_ENDPOINT_ADDRESS, COLUMN_NAME_ADDED_AT, COLUMN_NAME_LOCATION_ID};
    }

    public static class NetworkNodeTable implements BaseColumns {
        public static final String NETWORK_NODES_TABLE_NAME = "networknodes";
        public static final String COLUMN_NAME_NODE_NAME = "name";
        public static final String COLUMN_NAME_NODE_TYPE = "type";
        public static final String COLUMN_NAME_NODE_IP = "ip";
        public static final String COLUMN_NAME_NODE_MAC = "mac";
        public static final String COLUMN_NAME_NODE_LAST_ACTIVE = "active";
        public static final String COLUMN_NAME_NODE_2DFILE = "file_2d";
        public static final String COLUMN_NAME_NODE_3DFILE = "file_3d";
        public static final String COLUMN_NAME_NODE_ADDED_AT = "added_at";
        public static final String COLUMN_NAME_NETWORK_ID = "network_id";
        public static final String[] PROJECTION_GET_NODES = {_ID, COLUMN_NAME_NODE_NAME, COLUMN_NAME_NETWORK_ID, COLUMN_NAME_NODE_ADDED_AT, COLUMN_NAME_NODE_TYPE, COLUMN_NAME_NODE_IP, COLUMN_NAME_NODE_MAC, COLUMN_NAME_NODE_LAST_ACTIVE, COLUMN_NAME_NODE_2DFILE, COLUMN_NAME_NODE_3DFILE};
    }
}
