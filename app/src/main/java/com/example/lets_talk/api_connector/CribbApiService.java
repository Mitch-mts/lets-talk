package com.example.lets_talk.api_connector;


import com.example.lets_talk.custom.Hotel;
import com.example.lets_talk.custom.MessageResponse;
import com.example.lets_talk.custom.ResetPasswordRequest;
import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.custom.UserAccount;
import com.example.lets_talk.custom.UserLoginRequest;
import com.example.lets_talk.custom.UserRegistration;
import com.example.lets_talk.utils.Responsee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CribbApiService {

    @POST("/authenticate")
    Call<TokenResponse> authToken(@Body TokenRequest tokenRequest);

    @POST("/v1/user/login")
    Call<MessageResponse> login(@Header("Authorization") String token, @Body UserLoginRequest userLoginRequest);

    @POST("/v1/sign-up")
    Call<Responsee<MessageResponse>> createAccount(@Header("Authorization") String token, @Body UserRegistration userRegistration);

    @POST("/v1/user/reset-password")
    Call<Responsee<MessageResponse>> resetPassword(@Header("Authorization") String token,
                                                   @Query("username") String username,
                                                   @Body ResetPasswordRequest resetPasswordRequest);

    @GET("/v1/admin/{userId}")
    Call<Responsee<UserAccount>> getUserAccount(@Header("Authorization") String token, @Path("userId") Long userId);

    @GET("/v1/admin")
    Call<Responsee<List<UserAccount>>> getUserAccounts();

//    @POST("/v1/user/forgot-password")
//    Call<MessageResponse> forgetPassword(@Header("Authorization") String token, @Query("email") String email);
    @POST("/v1/user/forgot-password")
    Call<MessageResponse> forgetPassword(@Query("email") String email);

    @GET("/v1/sign-up/confirm-account")
    Call<Responsee<MessageResponse>> verifyToken(@Header("Authorization") String token,
                                                   @Query("username") String username,
                                                   @Query("verificationToken") String verificationToken);

    @GET("/v1/admin/hotel/list")
    Call<Responsee<List<Hotel>>> getHotels(@Header("Authorization") String token);

}