package com.example.lets_talk.custom;


import retrofit2.http.POST;

/**
 * Created by Hp on 28/2/2019.
 */
public interface LocationService {
        @POST("/v1/user")
        void getLocation(Location locationCallback);
}
