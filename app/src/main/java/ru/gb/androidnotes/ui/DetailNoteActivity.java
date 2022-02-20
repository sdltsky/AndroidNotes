package ru.gb.androidnotes.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.gb.androidnotes.R;
import ru.gb.androidnotes.domain.Note;

public class DetailNoteActivity extends AppCompatActivity {

    private TextView tvInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);

        tvInfo = findViewById(R.id.tv_info);
        int itemPosition = getIntent().getIntExtra(KEY_ARG, 0);
        Note note = App.INSTANCE.repository.getNote(itemPosition);
        setFields(note);
    }

    private void setFields(Note note) {
        tvInfo.setText(note.getNoteDetails());
    }

    public final static String KEY_ARG = "note_pos_key";
}
