package ru.gb.androidnotes.ui;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

import ru.gb.androidnotes.R;
import ru.gb.androidnotes.domain.Note;

public class DetailNoteActivity extends AppCompatActivity {

    public final static String KEY_ARG = "note_pos_key";
    public final static int NO_DATA_NOTE = -1;

    private Toolbar toolbar;
    private TextView tvToolbarTitle;
    private ImageView ivSave;
    private EditText etTitle;
    private EditText etDescription;

    private Note currNote;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);

        initViews();
        initListeners();
        initData();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);
        tvToolbarTitle = findViewById(R.id.tv_toolbar_title);
        ivSave = findViewById(R.id.iv_save);
        etTitle = findViewById(R.id.et_tile);
        etDescription = findViewById(R.id.et_description);
    }

    private void initListeners() {
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
        ivSave.setOnClickListener(v -> {
            saveNote();
            onBackPressed();
        });
    }

    private void initData() {
        int itemPosition = getIntent().getIntExtra(KEY_ARG, NO_DATA_NOTE);

        if (itemPosition != NO_DATA_NOTE) {
            tvToolbarTitle.setText(R.string.detail_note_add);
            Note note = App.INSTANCE.repository.getNote(itemPosition);
            currNote = note;
            setFields(note);
        } else {
            long lastId = App.INSTANCE.repository.getLastId();
            currNote = new Note(lastId + 1L, "", "", new Date());
        }
    }

    private void setFields(Note note) {
        etTitle.setText(note.getHeadline());
        etDescription.setText(note.getNoteDetails());
    }

    private void saveNote() {
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();

        currNote.setHeadline(title);
        currNote.setNoteDetails(description);

        App.INSTANCE.repository.saveNote(currNote);
        setResult(RESULT_OK);
    }
}
