package ru.gb.androidnotes.data;

import java.util.List;

import ru.gb.androidnotes.domain.Note;

public interface NoteRepository {

    Note getNote(int position);

    List<Note> getNotes();

    void saveNote(Note note);

    void deleteNote(int position);

    long getLastId();
}
