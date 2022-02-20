package ru.gb.androidnotes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class NoteViewHolder extends RecyclerView.ViewHolder {
    private final TextView headlineTextView = itemView.findViewById(R.id.headline_text_view);
    private final TextView noteDetailsTextView = itemView.findViewById(R.id.note_details_text_view);
    private final TextView dateTextView = itemView.findViewById(R.id.date_text_view);


    public NoteViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        super(inflater.inflate(R.layout.note, parent, false));
    }

    public void bind(Note note) {
        headlineTextView.setText(note.getHeadline());
        noteDetailsTextView.setText(note.getNoteDetails());
        dateTextView.setText(note.getDate());
    }
}
