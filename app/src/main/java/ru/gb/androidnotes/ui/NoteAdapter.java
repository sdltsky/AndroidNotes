package ru.gb.androidnotes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.gb.androidnotes.domain.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private ArrayList<Note> data;

    public void setData(ArrayList<Note> notesList) {
        data = notesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new NoteViewHolder(inflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.bind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
