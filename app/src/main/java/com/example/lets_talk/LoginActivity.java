package com.example.lets_talk;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lets_talk.api_connector.RetrofitClient;
import com.example.lets_talk.custom.MessageResponse;
import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.custom.UserLoginRequest;
import com.example.lets_talk.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private static String token;
    TextView letTalk;
    Button login;
    Button register;
    EditText cUsername;
    EditText cPassword;
    TextView forgot_password;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        letTalk = findViewById(R.id.letTalk);
        forgot_password = findViewById(R.id.forgot_password);

        /*text manipulation on the screen*/
        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");
        letTalk.setTypeface(custom_fonts);

        forgot_password.setOnClickListener(v -> {
            Intent it = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(it);
            finish();
        });

        cUsername = findViewById(R.id.username);
        cPassword = findViewById(R.id.password);

        /* the below statements make use of lambda expressions */
//        login.setOnClickListener(v -> getToken());

        login.setOnClickListener(v -> {
//            getToken();
            attemptLogin1();
        });

        register.setOnClickListener(v -> {
            Intent it = new Intent(LoginActivity.this, RegistrationActivity.class);
            startActivity(it);
            finish();
        });
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
                    attemptLogin();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void attemptLogin1(){
        Intent it = new Intent(LoginActivity.this,MainDashboardActivity.class);
        startActivity(it);
        finish();
    }


    public void attemptLogin(){ 
        EditText userName = findViewById(R.id.username);
        EditText passWord = findViewById(R.id.password);
        View focusView = null;

        /* error handling */
        cUsername.setError(null);
        cPassword.setError(null);

        String username = userName.getText().toString().trim();
        String password = passWord.getText().toString().trim();


        ProgressDialog pd = new ProgressDialog(LoginActivity.this);
        pd.setMessage("Loading...");
        pd.show();

        UserLoginRequest loginRequest = UserLoginRequest.createUserLoginRequest(username, password);

        RetrofitClient login_client = new RetrofitClient(Constants.LOGIN_URL);
        Call<MessageResponse> login_call = login_client.getCribbApiService().login("Bearer " + token, loginRequest);

        Log.i("login username::", loginRequest.getUsername());
        Log.i("login password::", loginRequest.getPassword());

        login_call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                Log.i("response success::", String.valueOf(response.isSuccessful()));
                if(response.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(LoginActivity.this, "Welcome " + ("\ud83d\ude01"), Toast.LENGTH_LONG).show();

                    Intent it = new Intent(LoginActivity.this,MainDashboardActivity.class);
                    startActivity(it);
                    finish();

                }else{
                    pd.dismiss();
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }


    private boolean isPasswordValid(String password) {
        return password.length() < 8;
    }


}