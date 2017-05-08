package com.unbm.andrei.ntviewer.application.network;

import com.unbm.andrei.ntviewer.application.network.models.Complaint;
import com.unbm.andrei.ntviewer.application.network.models.LoggedInUser;
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

    /**
     * This method will return all sites found on the server.
     *
     * @return List&lt;{@link com.unbm.andrei.ntviewer.application.network.models.Site}&gt;
     */
    @GET("/allSites")
    Observable<List<Site>> getAllSites();

    /**
     * By providing your current location this method will return the closest site
     *
     * @param lat latitude of your current location
     * @param lon longitude of your current location
     * @return
     */
    @GET("/closestSite")
    Observable<Site> getClosestSite(@Query("lat") double lat, @Query("lon") double lon);


    /**
     * This method will return given number of Sites
     *
     * @param limit Number of sites to get
     * @return List&lt;{@link com.unbm.andrei.ntviewer.application.network.models.Site}&gt;
     */
    @GET("/sites")
    Observable<List<Site>> getSites(@Query("limit") int limit);


    @GET("/users")
    Observable<LoggedInUser> loginUser(@Query("username") String username, @Query("password") String password);

    @GET("users/getUser")
    Observable<User> getUser(@Query("userId") int userId);

    @GET("/subscribers/requests")
    Observable<List<SRequest>> getSRequests();

    @GET("/subscribers/complaints")
    Observable<List<Complaint>> getComplaints();
}
