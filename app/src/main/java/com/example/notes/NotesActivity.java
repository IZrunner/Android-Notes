package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotesActivity extends AppCompatActivity {
    private static final String TAG = "NotesActivity";
    @BindView(R.id.notes_list)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter;
    List<Note> notesList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        initViews();
        loadNotes();

//        FloatingActionButton mFAB = findViewById(R.id.floating_action_button);
//        mFAB.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                startActivity(new Intent(NotesActivity.this, CreateEditNoteActivity.class));
//                Log.d(TAG, "Error on activities switching");
//            }
//        });
    }

    private void initViews() {

        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){
        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();
        if(notesList.size() != 0){
            adapter = new NotesAdapter(this,notesList);
            rvNotes.setAdapter(adapter);
        }


    }

    @OnClick(R.id.floating_action_button)
    public void addNote(){
        Intent i = new Intent(NotesActivity.this,CreateEditNoteActivity.class);
        startActivity(i);
    }
}
