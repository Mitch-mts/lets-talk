package com.example.lets_talk.api_connector;

import android.widget.Toast;

import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthToken {

    public void getAuthToken(){
        TokenRequest tokenRequest = TokenRequest.createTokenRequest(Constants.USERNAME, Constants.PASSWORD);

        RetrofitClient client = new RetrofitClient(Constants.TOKEN_URL);

        Call<TokenResponse> token_call = client.getCribbApiService().authToken(tokenRequest);

        token_call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                TokenResponse tokenResponse = response.body();
                String token = tokenResponse.getToken();
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(null, "An error has occured:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
