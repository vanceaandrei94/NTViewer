package com.unbm.andrei.ntviewer.service.api;

import com.unbm.andrei.ntviewer.model.NetworkSite;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrei on 4/15/2017.
 */

public interface INetworkServiceProvider {

    // TODO: 4/16/2017 Change this
    String BASE_URI = "http://192.168.3.10";

    /**
     * get the closest NetworkSite to the user that makes the call
     *
     * @param lat Current user lat
     * @param lon Current user lon
     * @return
     */
    @GET("networks")
    Observable<NetworkSite> getClosestNetworkSite(@Query("lat") double lat, @Query("lon") double lon);

    @GET("allSites")
    Observable<List<NetworkSite>> getAllSites();
}
