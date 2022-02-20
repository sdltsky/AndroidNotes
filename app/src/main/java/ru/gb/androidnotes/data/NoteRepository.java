package ru.gb.androidnotes.data;

import java.util.List;

import ru.gb.androidnotes.domain.Note;

public interface NoteRepository {

    public Note getNote(int position);

    public List<Note> getNotes();
}
