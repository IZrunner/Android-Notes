package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button mLoginButton;
    private Button mSignUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSignUpButton = findViewById(R.id.signUpButton);
        mSignUpButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NotesActivity.class));
            Log.d(TAG, "Activities switching success");
        });

        mLoginButton = findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NotesActivity.class));
            Log.d(TAG, "Activities switching success");
        });
    }
}