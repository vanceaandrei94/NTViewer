package com.unbm.andrei.ntviewer.application.network;

import com.unbm.andrei.ntviewer.application.network.models.Derangement;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProvider;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NetworkRoute;
import com.unbm.andrei.ntviewer.application.network.models.networkroute.NodeInfo;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrei on 4/30/2017.
 */

public interface NTVService {

    String BASE_URL = "http://provider-name.ro/services/ispManager/";

    @GET("/users")
    Observable<LoggedInUser> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("/coverage/providers")
    Observable<List<NetworkProvider>> getProviders();

    @GET("/coverage/complaints")
    Observable<List<Derangement>> getComplaints();

    @GET("/networkRoutes")
    Observable<List<NetworkRoute>> getNetworkRoutes();

    @GET("/networkRoutes/nodeInfo")
    Observable<NodeInfo> getNodeInfo(@Query("nodeId") String id);
}
