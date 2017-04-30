package com.unbm.andrei.ntviewer.application.network;

import com.unbm.andrei.ntviewer.application.network.models.NetworkSite;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Andrei on 4/30/2017.
 */

public interface SitesProviderService {

    String BASE_URL = "http://provider-name.ro/services/ntviewer";

    @GET("/allSites")
    Observable<List<NetworkSite>> getAllNetworkSites();
}
