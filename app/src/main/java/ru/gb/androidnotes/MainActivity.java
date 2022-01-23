package ru.gb.androidnotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private final ArrayList<Note> notesList = new ArrayList<>();

    private static ArrayList<Note> createExampleNotes() {
        final ArrayList<Note> exampleNotes = new ArrayList<>();
        exampleNotes.add(new Note(
                0,
                "заметка",
                "это пример заметки",
                "22.01.2022"
        ));
        exampleNotes.add(new Note(
                1,
                "PIN",
                "PIN-код от сбера - 4444, от ВТБ - 5555",
                "19.01.2022"
        ));
        exampleNotes.add(new Note(
                2,
                "Убрать ёлку",
                "Уже прошёл старый новый год, пора убрать ёлку =)",
                "15.01.2022"
        ));
        exampleNotes.add(new Note(
                3,
                "Книги",
                "больше полугода не читал книг, аудиокниги - не в счёт). Надо поискать интересную литературу",
                "09.01.2022"
        ));
        return exampleNotes;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesList.addAll(createExampleNotes());
    }


}