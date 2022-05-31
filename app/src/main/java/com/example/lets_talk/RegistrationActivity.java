package com.example.lets_talk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lets_talk.api_connector.RetrofitClient;
import com.example.lets_talk.custom.MessageResponse;
import com.example.lets_talk.custom.TokenRequest;
import com.example.lets_talk.custom.TokenResponse;
import com.example.lets_talk.custom.UserRegistration;
import com.example.lets_talk.utils.Constants;
import com.example.lets_talk.utils.Responsee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationActivity extends AppCompatActivity {
    TextView letstalk;
    TextView goLogin;
    Button register;
    Spinner spinner;
    private static String token;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        letstalk = findViewById(R.id.letstalk);
        goLogin = findViewById(R.id.go_login);
        register = findViewById(R.id.register);
        spinner = findViewById(R.id.gender_spinner);
        datePicker = findViewById(R.id.datePicker1);

        Typeface custom_fonts = Typeface.createFromAsset(getAssets(), "fonts/ArgonPERSONAL-Regular.otf");
        letstalk.setTypeface(custom_fonts);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        goLogin.setOnClickListener(v -> {
            Intent it = new Intent(RegistrationActivity.this, LoginActivity.class);
            startActivity(it);
            finish();
        });

        register.setOnClickListener(v -> getToken());

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
                    registerUser();
                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, "Failed to get token:: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void registerUser(){
        EditText user = findViewById(R.id.user);
        EditText firstname = findViewById(R.id.firstname);
        EditText lastname = findViewById(R.id.lastname);
        EditText email = findViewById(R.id.email);
        EditText mobileNumber = findViewById(R.id.mobileNumber);
        EditText location = findViewById(R.id.location);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.pass);
        DatePicker datePicker = findViewById(R.id.datePicker1);

        String username = user.getText().toString().trim();
        String firstName = firstname.getText().toString().trim();
        String surname = lastname.getText().toString().trim();
        String sex = spinner.getSelectedItem().toString().trim();
//        String dateOfBirth = dob.getText().toString().trim();
        String emailAddress = email.getText().toString().trim();
        String mobile = mobileNumber.getText().toString().trim();
        String residence = location.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String confirmPass = confirmPassword.getText().toString().trim();
        String dateOfBirth = datePicker.getDayOfMonth() + "-" +  datePicker.getMonth() + "-" + datePicker.getYear();
        Log.i("dob::", dateOfBirth);

        isPasswordValid(pass, confirmPass);

        ProgressDialog pd = new ProgressDialog(RegistrationActivity.this);
        pd.setMessage("Loading...");
        pd.show();


        UserRegistration userRegistration = UserRegistration.of(username,
                firstName,
                surname,
                emailAddress,
                pass,
                residence,
                dateOfBirth,
                sex,
                mobile,
                confirmPass);
        Log.i("registration request::", userRegistration.toString());

        RetrofitClient signup_client = new RetrofitClient(Constants.LOGIN_URL);
        Call<Responsee<MessageResponse>> signup_call = signup_client.getCribbApiService()
                .createAccount("Bearer " + token, userRegistration);

        signup_call.enqueue(new Callback<Responsee<MessageResponse>>() {
            @Override
            public void onResponse(Call<Responsee<MessageResponse>> call, Response<Responsee<MessageResponse>> response) {
                Log.i("success response::", String.valueOf(response.isSuccessful()));
                if (response.isSuccessful()){
                    pd.dismiss();
                    Toast.makeText(RegistrationActivity.this, "Account Created Successfully", Toast.LENGTH_LONG).show();

                    Intent it = new Intent(RegistrationActivity.this, ActivationActivity.class);
                    startActivity(it);
                    finish();

                }else{
                    pd.dismiss();
                    Toast.makeText(RegistrationActivity.this, "Account creation failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Responsee<MessageResponse>> call, Throwable t) {
                Toast.makeText(RegistrationActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void isPasswordValid(String password, String confirPassword) {
        if(password.length() < 8){
            Toast.makeText(RegistrationActivity.this, "Invalid password length", Toast.LENGTH_LONG).show();
        }
        if(!password.equals(confirPassword)){
            Toast.makeText(RegistrationActivity.this, "Passwords do not match", Toast.LENGTH_LONG).show();
        }
    }

}