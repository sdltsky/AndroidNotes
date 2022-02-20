package ru.gb.androidnotes.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.gb.androidnotes.domain.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private List<Note> data;
    private OnItemClickListener listener;

    public NoteAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<Note> notesList) {
        data = notesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new NoteViewHolder(inflater, parent, listener);
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
