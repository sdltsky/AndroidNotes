package ru.gb.androidnotes.data;

import java.util.ArrayList;
import java.util.List;

import ru.gb.androidnotes.domain.Note;

public class NoteRepositoryImpl implements NoteRepository {

    private static List<Note> notes;

    static {
        notes = new ArrayList<>();
        notes.add(new Note(
                0,
                "заметка",
                "это пример заметки",
                "22.01.2022"
        ));
        notes.add(new Note(
                1,
                "PIN",
                "PIN-код от сбера - 4444, от ВТБ - 5555",
                "19.01.2022"
        ));
        notes.add(new Note(
                2,
                "Убрать ёлку",
                "Уже прошёл старый новый год, пора убрать ёлку =)",
                "15.01.2022"
        ));
        notes.add(new Note(
                3,
                "Книги",
                "больше полугода не читал книг, аудиокниги - не в счёт). Надо поискать интересную литературу",
                "09.01.2022"
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
}
