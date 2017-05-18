package com.unbm.andrei.ntviewer.application.network;

import com.unbm.andrei.ntviewer.application.network.models.Complaint;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
import com.unbm.andrei.ntviewer.application.network.models.NetworkProviders;
import com.unbm.andrei.ntviewer.application.network.models.SRequest;
import com.unbm.andrei.ntviewer.application.network.models.Site;
import com.unbm.andrei.ntviewer.models.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Andrei on 4/30/2017.
 */

public interface NTVService {

    String BASE_URL = "http://provider-name.ro/services/ntviewer/";

    @GET("/users")
    Observable<LoggedInUser> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("users/getUser")
    Observable<User> getUser(@Query("userId") int userId);

    @GET("/subscribers/requests")
    Observable<List<SRequest>> getSRequests();

    @GET("/subscribers/complaints")
    Observable<List<Complaint>> getComplaints();


    @GET("/coverage/providers")
    Observable<List<NetworkProviders>> getProviders();
}
