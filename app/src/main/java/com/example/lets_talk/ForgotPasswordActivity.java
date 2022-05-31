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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPasswordActivity extends AppCompatActivity {
    TextView letstalk;
    TextView resetPassword;
    Button submitReset;
    private static String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        letstalk = findViewById(R.id.letstalk);
        resetPassword = findViewById(R.id.go_login);
        submitReset = findViewById(R.id.reset_password);

        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");
        letstalk.setTypeface(custom_fonts);

        resetPassword.setOnClickListener(v -> {
            Intent it = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
            startActivity(it);
            finish();
        });

        submitReset.setOnClickListener(v -> getToken());
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
                    resetAccountPassword();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void resetAccountPassword(){
        EditText email = findViewById(R.id.email);

        String emailAddress = email.getText().toString().trim();
        Log.i("email address::", emailAddress);

        ProgressDialog pd = new ProgressDialog(ForgotPasswordActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        RetrofitClient reset_password_client = new RetrofitClient(Constants.USER_MANAGEMENT_BASE_URL);
        Call<MessageResponse> reset_password_call = reset_password_client.getCribbApiService().forgetPassword("Bearer " + token, emailAddress);

        reset_password_call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                Log.i("success::", String.valueOf(response.isSuccessful()));
                Log.i("mesage::", String.valueOf(response.code()));
                if (response.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(ForgotPasswordActivity.this,
                            response.body().getMessage() + ", please check your email for your new password",
                            Toast.LENGTH_LONG).show();

                    Intent it = new Intent(ForgotPasswordActivity.this, LoginActivity.class);
                    startActivity(it);
                    finish();

                }else{
                    pd.dismiss();
                    Toast.makeText(ForgotPasswordActivity.this, "Reset process failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Toast.makeText(ForgotPasswordActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}