package com.example.student3.aadasd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("RRRR", "Creating database...");
        db.execSQL("CREATE TABLE teachers (id integer primary key autoincrement, name varchar(100), grade varchar(20), subject varchar(20));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("RRRR", "Creating database...");
        db.execSQL("CREATE TABLE teachers (id integer primary key autoincrement, name varchar(100), grade varchar(20), subject varchar(20));");
    }
}
