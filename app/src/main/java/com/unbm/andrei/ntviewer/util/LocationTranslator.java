package com.unbm.andrei.ntviewer.util;

import com.google.android.gms.maps.model.LatLng;
import com.unbm.andrei.ntviewer.application.network.models.GeoLocation;

/**
 * Created by Andrei on 8/17/2017.
 */

public class LocationTranslator {

    public static LatLng translateGeoLocationIntoLatLng(GeoLocation geoLocation) {
        return new LatLng(geoLocation.getLat(), geoLocation.getLon());
    }
}
