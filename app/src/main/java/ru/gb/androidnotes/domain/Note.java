package ru.gb.androidnotes.domain;

import java.util.Date;

public class Note {

    private final long id;
    private String headline;
    private String noteDetails;
    private Date date;

    public Note(long id, String headline, String noteDetails, Date date) {
        this.id = id;
        this.headline = headline;
        this.noteDetails = noteDetails;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getNoteDetails() {
        return noteDetails;
    }

    public void setNoteDetails(String noteDetails) {
        this.noteDetails = noteDetails;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
