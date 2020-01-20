package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateEditNoteActivity extends AppCompatActivity {

    private static final String TAG = "CreateEditNoteActivity";
    @BindView(R.id.note_title)
    EditText etTitle;

    @BindView(R.id.note_content)
    EditText etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_edit_note);
        ButterKnife.bind(this);

        Button mSaveNoteButton = findViewById(R.id.save_note_button);
        mSaveNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
                startActivity(new Intent(CreateEditNoteActivity.this, NotesActivity.class));
                Log.d(TAG, "Error on activities switching");
            }
        });
    }

    private void saveNote(){

        String title = etTitle.getText().toString();
        String note_text = etNote.getText().toString();

        if(title.equals("") || note_text.equals("")){
            showToast("Please fill all the fields before saving");
        }else{
            DatabaseHandler db = new DatabaseHandler(this);
            Note note = new Note(title,note_text);
            db.addNote(note);
            db.close();

            Intent i = new Intent(CreateEditNoteActivity.this,NotesActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);
        }
    }


    private void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_add_note,menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        if(id == R.id.action_save){
//            saveNote();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
