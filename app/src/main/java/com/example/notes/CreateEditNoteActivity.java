package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class CreateEditNoteActivity extends AppCompatActivity {

    private static final String TAG = "CreateEditNoteActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_note);

        Button mSaveNoteButton = findViewById(R.id.save_note_button);
        mSaveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateEditNoteActivity.this, NotesActivity.class));
                Log.d(TAG, "Error on activities switching");
            }
        });
    }
}
