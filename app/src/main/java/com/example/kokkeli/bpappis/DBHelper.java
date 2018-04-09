package com.example.kokkeli.bpappis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "SQLiteTaskukirjat.db";
    private static final int DATABASE_VERSION = 2;

    public static final String BOOK_TABLE_NAME = "person";
    public static final String BOOK_COLUMN_ID = "_id";
    public static final String BOOK_COLUMN_NAME = "name";
    public static final String BOOK_COLUMN_NUMBER = "number";
    public static final String BOOK_COLUMN_YEAR = "year";
    public static final String BOOK_COLUMN_RATING = "rating";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME , null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE " + BOOK_TABLE_NAME +
                        "(" + BOOK_COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        BOOK_COLUMN_NAME + " TEXT, " +
                        BOOK_COLUMN_NUMBER + " INTEGER, " +
                        BOOK_COLUMN_YEAR + " INTEGER," +
                        BOOK_COLUMN_RATING + " INTEGER)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BOOK_TABLE_NAME);
        onCreate(db);
    }

    public boolean insertBook(String name, int number, int year, int rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(BOOK_COLUMN_NAME, name);
        contentValues.put(BOOK_COLUMN_NUMBER, number);
        contentValues.put(BOOK_COLUMN_YEAR, year);
        contentValues.put(BOOK_COLUMN_RATING, rating);

        db.insert(BOOK_TABLE_NAME, null, contentValues);
        return true;
    }
/*
    public int numberOfRows() {
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, BOOK_TABLE_NAME);
        return numRows;
    }

    public boolean updatePerson(Integer id, String name, String gender, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BOOK_COLUMN_NAME, name);
        contentValues.put(BOOK_COLUMN_NUMBER, gender);
        contentValues.put(BOOK_COLUMN_YEAR, age);
        db.update(BOOK_TABLE_NAME, contentValues, BOOK_COLUMN_ID + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }*/

    public Integer deleteBook(Integer id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(BOOK_TABLE_NAME,
                BOOK_COLUMN_ID + " = ? ",
                new String[] { Integer.toString(id) });
    }
/*
    public Cursor getPerson(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery("SELECT * FROM " + BOOK_TABLE_NAME + " WHERE " +
                BOOK_COLUMN_ID + "=?", new String[]{Integer.toString(id)});
        return res;
    }
*/
    public Cursor getAllBooks() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "SELECT * FROM " + BOOK_TABLE_NAME, null );
        return res;
    }
}