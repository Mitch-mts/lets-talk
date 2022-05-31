package com.example.lets_talk.api_connector;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenIntercepter implements Interceptor {
    private String token;

    public void setAuthToken(String token){
        Log.i("just kidding", "");
        this.token = token;
    }

    public String getAuthToken(){
        Log.i("token from main::", token);
        return this.token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i("im in intercept","");
        Log.i("token from main::", getAuthToken());
        Request request = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + getAuthToken())
                        .build();
        return chain.proceed(request);
    }
}
