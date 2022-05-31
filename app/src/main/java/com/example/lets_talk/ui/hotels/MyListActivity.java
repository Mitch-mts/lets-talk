package com.example.lets_talk.ui.hotels;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lets_talk.R;
import com.example.lets_talk.api_connector.RetrofitClient;
import com.example.lets_talk.custom.Hotel;
import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.utils.Constants;
import com.example.lets_talk.utils.Responsee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyListActivity extends AppCompatActivity {
    String token;
    List<Hotel> hotels;
    String[] mobileArray = {"Android", "IOS", "Windows Mobile", "Blackberry", "Linux", "Symbian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

//        getToken();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_view_data, mobileArray);
        ListView listView = findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }

    public void getToken(){
        Log.i("In get token", "");
        TokenRequest tokenRequest = TokenRequest.createTokenRequest(Constants.USERNAME, Constants.PASSWORD);
        RetrofitClient token_client = new RetrofitClient(Constants.TOKEN_URL);

        Call<TokenResponse> token_call = token_client.getCribbApiService().authToken(tokenRequest);

        token_call.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                Log.i("token first::", String.valueOf(response.code()));
                if (response.isSuccessful()){
                    token = response.body().getToken();
                    Log.i("token first::", token);
                    getHotelDetails();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(MyListActivity.this, "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getHotelDetails(){
        ProgressDialog pd = new ProgressDialog(MyListActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        RetrofitClient hotel_client = new RetrofitClient(Constants.HOTELS_BASE_URL);
        Call<Responsee<List<Hotel>>> hotels_call = hotel_client.getCribbApiService().getHotels("Bearer " + token);

        hotels_call.enqueue(new Callback<Responsee<List<Hotel>>>() {
            @Override
            public void onResponse(Call<Responsee<List<Hotel>>> call, Response<Responsee<List<Hotel>>> response) {
                Log.i("in enqueue", "");
                Log.i("hotel data::{}", String.valueOf(response.body().getResult().size()));
                hotels = response.body().getResult();
            }

            @Override
            public void onFailure(Call<Responsee<List<Hotel>>> call, Throwable t) {
                Toast.makeText(MyListActivity.this, "Failed to retrieve hotel data:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}