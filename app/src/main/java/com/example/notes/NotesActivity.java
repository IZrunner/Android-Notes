package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotesActivity extends AppCompatActivity {
    private static final String TAG = "NotesActivity";
    @BindView(R.id.notes_list) //needed view; use ButterKnife instead of
                               // View someView = (View) findViewById(R.id.someView)
    RecyclerView rvNotes;

    RecyclerView.Adapter adapter; //adapter to get notes
    List<Note> notesList; //all our notes to be put into RecyclerView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        ButterKnife.bind(this); //to make ButterKnife work

        initViews(); //make notes visible
        loadNotes(); //load notes from DB
    }

    private void initViews() {
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadNotes(){
        DatabaseHandler db = new DatabaseHandler(this);

        notesList = db.getAllNotes();
        if(notesList.size() != 0){
            adapter = new NotesAdapter(this,notesList); //push raw data to adapter
            rvNotes.setAdapter(adapter); //set adapter to RecyclerView (make notes visible)
        }
    }

    @OnClick(R.id.floating_action_button)
    public void addNote(){
        Intent i = new Intent(NotesActivity.this,CreateEditNoteActivity.class);
        startActivity(i);
    }
}
