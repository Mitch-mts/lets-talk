package com.example.lets_talk.api_connector;


import com.example.lets_talk.utils.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hp on 25/3/2019.
 */
public class RetrofitClient {
    private static RetrofitClient retrofitClient = null;
    private static CribbApiService cribbApiService;
    TokenIntercepter tokenIntercepter = new TokenIntercepter();

    OkHttpClient client = new OkHttpClient.Builder()
                        .addInterceptor(tokenIntercepter)
                        .build();

    public static CribbApiService makeCribbAPIService(){
        return new Retrofit.Builder()
                .client(getInstance().client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.USER_MANAGEMENT_BASE_URL)
                .build().create(CribbApiService.class);
    }

    public RetrofitClient() {
    }

    public RetrofitClient(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cribbApiService = retrofit.create(CribbApiService.class);
    }

    public CribbApiService getCribbApiService(){
        return cribbApiService;
    }

    public static synchronized RetrofitClient getInstance(){
        if(retrofitClient == null){
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

}
