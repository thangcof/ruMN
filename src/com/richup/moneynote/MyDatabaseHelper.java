package com.richup.moneynote;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class MyDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "MoneyNote";

    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table Types(_id integer primary key, type text not null);create table Notes ( _id integer primary key,description text, money integer not nul, is_necessary integer, type integer, spending_date text not null, last_modified text not null,FOREIGN KEY(type) REFERENCES types(_id));";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method is called during creation of the database
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    // Method is called during an upgrade of the database,
    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion,
            int newVersion) {
        Log.w(MyDatabaseHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS Notes;");
        onCreate(database);
    }
}