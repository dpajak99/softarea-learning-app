package com.softarea.learningapp.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.softarea.learningapp.model.Note;

public class DBManager {
    private DBHelper helper;
    private SQLiteDatabase db;

    public DBManager(Context context) {
        helper = new DBHelper(context);
        db = helper.getWritableDatabase();
    }

    public void addNote(Note note) {
        db.beginTransaction();
        try {
            db.execSQL("INSERT INTO NOTES VALUES(?,?, ?, ?)",
                    new Object[]{note.getTitle(), note.getContent(),
                            note.getCreatedAt(), note.getAuthor().getFullName()});
            db.setTransactionSuccessful();
            Log.i("TEST", "Inserted: " + note.toString());
        } finally {
            db.endTransaction();
        }
    }

    public void closeDB() {
        db.close();
    }
}
