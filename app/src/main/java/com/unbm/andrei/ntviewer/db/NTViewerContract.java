package com.unbm.andrei.ntviewer.db;

import android.provider.BaseColumns;

/**
 * Created by andrei.vancea on 3/6/2017.
 */

public class NTViewerContract {

    private NTViewerContract() {
    }

    public static class LocationsTable implements BaseColumns {
        public static final String TABLE_NAME = "locations";
        public static final String COLUMN_NAME_LOCATION_NAME = "name";
        public static final String COLUMN_NAME_IP_ADDR = "ip";
        public static final String COLUMN_NAME_LAT = "lat";
        public static final String COLUMN_NAME_LON = "lon";
        public static final String[] PROJECTION = {_ID, COLUMN_NAME_LOCATION_NAME, COLUMN_NAME_LAT, COLUMN_NAME_LON};
    }

}
