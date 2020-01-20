package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Console;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button mLoginButton;
    private Button mSignUpButton;

//    private EditText mLogin;
//    private EditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Success");

//        User admin = new User("van@mail.buff", "password");

//        ArrayList<User> users = new ArrayList<>();
//        users.add(admin);

//        mLogin = findViewById(R.id.login);
//        mPassword = findViewById(R.id.password);
//
//        String username = mLogin.getText().toString();
//        String password = mPassword.getText().toString();

        mSignUpButton = findViewById(R.id.signUpButton);
        mSignUpButton.setOnClickListener(v -> {
//            if(username.equals("") && password.equals("")){
//                showToast("Please fill all the fields before saving");
//            }else{
//                users.add(new User(username, password));
                startActivity(new Intent(MainActivity.this, NotesActivity.class));
                Log.d(TAG, "Activities switching success");
//                    DatabaseHandler db = new DatabaseHandler(this);
//                    Note note = new Note(title,note_text);
//                    db.addNote(note);
//                    db.close();
//
//                    Intent i = new Intent(CreateEditNoteActivity.this,NotesActivity.class);
//                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    startActivity(i);
//            }
        });

        mLoginButton = findViewById(R.id.loginButton);
        mLoginButton.setOnClickListener(v -> {
//            if (username.equals(admin.getUsername()) && password.equals(admin.getUsername())) {
                startActivity(new Intent(MainActivity.this, NotesActivity.class));
                Log.d(TAG, "Activities switching success");
//            }else {
//                Log.d(TAG, "Invalid login and/or password");
//            }


        });
    }

//    private void showToast(String msg){
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT);
//    }
}
