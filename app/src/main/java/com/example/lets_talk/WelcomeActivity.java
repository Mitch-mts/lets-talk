package com.example.lets_talk;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {
    Button loginn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        loginn = findViewById(R.id.loginn);

        loginn.setOnClickListener(v -> {
            ProgressDialog pd = new ProgressDialog(WelcomeActivity.this);
            pd.setMessage("Loading...");
            pd.show();

            Intent it = new Intent(WelcomeActivity.this, LoginActivity.class);
            startActivity(it);
            finish();

            pd.dismiss();
        });
    }
}