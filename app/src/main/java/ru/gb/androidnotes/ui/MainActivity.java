package ru.gb.androidnotes.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.androidnotes.R;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private RecyclerView recyclerView;
    private NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.setData(App.INSTANCE.repository.getNotes());
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, DetailNoteActivity.class);
        intent.putExtra(DetailNoteActivity.KEY_ARG, position);
        startActivity(intent);
    }
}