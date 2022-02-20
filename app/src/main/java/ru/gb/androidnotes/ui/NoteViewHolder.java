package ru.gb.androidnotes.ui;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.androidnotes.R;
import ru.gb.androidnotes.domain.Note;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView headlineTextView = itemView.findViewById(R.id.headline_text_view);
    private final TextView noteDetailsTextView = itemView.findViewById(R.id.note_details_text_view);
    private final TextView dateTextView = itemView.findViewById(R.id.date_text_view);
    private final OnItemClickListener listener;


    public NoteViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent, OnItemClickListener listener) {
        super(inflater.inflate(R.layout.note, parent, false));
        this.listener = listener;
    }

    public void bind(Note note) {
        headlineTextView.setText(note.getHeadline());
        noteDetailsTextView.setText(note.getNoteDetails());
        dateTextView.setText(note.getDate());
        itemView.setOnClickListener(v -> listener.onItemClick(getAdapterPosition()));
    }
}
