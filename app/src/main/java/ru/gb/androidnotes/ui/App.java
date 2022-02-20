package ru.gb.androidnotes.ui;

import android.app.Application;

import ru.gb.androidnotes.data.NoteRepository;
import ru.gb.androidnotes.data.NoteRepositoryImpl;

public class App extends Application {

    public final NoteRepository repository;

    {
        repository = new NoteRepositoryImpl();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }

    public static App INSTANCE;
}
