package ru.gb.androidnotes.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.gb.androidnotes.R;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private static final int KEY_DETAIL_NOTE_RESULT = 666;

    private RecyclerView recyclerView;
    private NoteAdapter adapter;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
        initRecycler();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recycler_view);
        fab = findViewById(R.id.fab);
    }

    private void initListeners() {
        fab.setOnClickListener(v -> addNote());
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(App.INSTANCE.repository.getNotes());
    }

    @Override
    public void onItemClick(int position) {
        goToDetailNote(position);
    }

    @Override
    public void onItemDeleteClick(int position) {
        App.INSTANCE.repository.deleteNote(position);
        adapter.setData(App.INSTANCE.repository.getNotes());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == KEY_DETAIL_NOTE_RESULT && resultCode == RESULT_OK) {
            adapter.setData(App.INSTANCE.repository.getNotes());
        }
    }

    private void addNote() {
        goToDetailNote(DetailNoteActivity.NO_DATA_NOTE);
    }

    private void goToDetailNote(int position) {
        Intent intent = new Intent(this, DetailNoteActivity.class);
        intent.putExtra(DetailNoteActivity.KEY_ARG, position);
        startActivityForResult(intent, KEY_DETAIL_NOTE_RESULT);
    }
}