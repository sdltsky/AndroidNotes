package ru.gb.androidnotes.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.gb.androidnotes.domain.Note;

public class NoteRepositoryImpl implements NoteRepository {

    private static List<Note> notes;

    static {
        notes = new ArrayList<>();
        notes.add(new Note(
                0L,
                "заметка",
                "это пример заметки",
                new Date()
        ));
    }

    @Override
    public Note getNote(int position) {
        return notes.get(position);
    }

    @Override
    public List<Note> getNotes() {
        return notes;
    }

    @Override
    public void saveNote(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            Note tmpNote = notes.get(i);

            if (tmpNote.getId() == note.getId()) {
                notes.set(i, note);
                return;
            }
        }

        notes.add(note);
    }

    @Override
    public void deleteNote(int position) {
        notes.remove(position);
    }

    @Override
    public long getLastId() {
        long resultId = 0L;

        for (int i = 0; i < notes.size(); i++) {
            long tmpId = notes.get(i).getId();

            if (tmpId > resultId) {
                resultId = tmpId;
            }
        }

        return resultId;
    }
}
