package com.example.lets_talk.ui.hotels;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HotelsFragment#} factory method to
 * create an instance of this fragment.
 */
public class HotelsFragment extends ListFragment {
    String token;
    String[] hotelsList = {"Android", "IOS", "Windows Mobile", "Blackberry", "linux"};

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hotels, container, false);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_view_data, hotelsList);
        setListAdapter(adapter);
        return view;
    }


//    public void getToken(){
//        TokenRequest tokenRequest = TokenRequest.createTokenRequest(Constants.USERNAME, Constants.PASSWORD);
//        RetrofitClient token_client = new RetrofitClient(Constants.TOKEN_URL);
//
//        Call<TokenResponse> token_call = token_client.getCribbApiService().authToken(tokenRequest);
//
//        token_call.enqueue(new Callback<TokenResponse>() {
//            @Override
//            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
//                Log.i("token first::", String.valueOf(response.code()));
//                if (response.isSuccessful()){
//                    token = response.body().getToken();
//                    Log.i("token first::", token);
//                    getHotelDetails();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<TokenResponse> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }

//    public void getHotelDetails(){
//        ProgressDialog pd = new ProgressDialog(getActivity());
//        pd.setMessage("Loading...");
//        pd.show();
//
//        RetrofitClient hotel_client = new RetrofitClient(Constants.HOTELS_BASE_URL);
//        Call<Responsee<List<Hotel>>> hotels_call = hotel_client.getCribbApiService().getHotels("Bearer " + token);
//
//        hotels_call.enqueue(new Callback<Responsee<List<Hotel>>>() {
//            @Override
//            public void onResponse(Call<Responsee<List<Hotel>>> call, Response<Responsee<List<Hotel>>> response) {
//                Log.i("in enqueue", "");
//                Log.i("hotel data::{}", response.body().getResult().toString());
//                hotelsList = response.body().getResult();
//            }
//
//            @Override
//            public void onFailure(Call<Responsee<List<Hotel>>> call, Throwable t) {
//                Toast.makeText(getActivity(), "Failed to retrieve hotel data:: " + t.getMessage(), Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }

}