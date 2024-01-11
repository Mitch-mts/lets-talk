package com.example.lets_talk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lets_talk.api_connector.RetrofitClient;
import com.example.lets_talk.custom.MessageResponse;
import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.utils.Constants;
import com.example.lets_talk.utils.Responsee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ActivationActivity extends AppCompatActivity {
    TextView letstalk;
    Button submitReset;
    TextView skip;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation);

        letstalk = findViewById(R.id.letstalk);
        submitReset = findViewById(R.id.verify_account);
        skip = findViewById(R.id.go_dashboard);

        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");
        letstalk.setTypeface(custom_fonts);

        skip.setOnClickListener(v -> {
            Intent it = new Intent(ActivationActivity.this, LoginActivity.class);
            startActivity(it);
            finish();
        });

        submitReset.setOnClickListener(v -> verifyAccount());
    }

    public void getToken(){
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
                    verifyAccount();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(ActivationActivity.this, "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void verifyAccount(){
        EditText verify_Token = findViewById(R.id.verification_token);
        EditText user_token = findViewById(R.id.user_token);

        String verificationToken = verify_Token.getText().toString().trim();
        String username = user_token.getText().toString().trim();
        Log.i("verificationToken::", verificationToken);

        ProgressDialog pd = new ProgressDialog(ActivationActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        RetrofitClient verify_token_client = new RetrofitClient(Constants.SIGN_UP);
//        Call<Responsee<MessageResponse>> verify_token_call = verify_token_client.getCribbApiService().verifyToken("Bearer " + token,
//                username,
//                verificationToken);
        Call<Responsee<MessageResponse>> verify_token_call = verify_token_client.getCribbApiService().verifyToken(verificationToken);

        verify_token_call.enqueue(new Callback<Responsee<MessageResponse>>() {
            @Override
            public void onResponse(Call<Responsee<MessageResponse>> call, Response<Responsee<MessageResponse>> response) {
                Log.i("result success::", String.valueOf(response.isSuccessful()));
                if (response.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(ActivationActivity.this, "Account Verified", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(ActivationActivity.this,LoginActivity.class);
                    startActivity(it);
                    finish();

                } else{
                    pd.dismiss();
                    Toast.makeText(ActivationActivity.this, "Could not verify Account", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(ActivationActivity.this,LoginActivity.class);
                    startActivity(it);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<Responsee<MessageResponse>> call, Throwable t) {
                Toast.makeText(ActivationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}