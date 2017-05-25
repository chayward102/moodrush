package com.mrush.chayward102.moodrush;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by chayward102 on 11/03/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "quizList.db";
    public static final String TABLE_NAME = "quizList_data2";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEM1";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (QuestionNumber  INTEGER , QuestionAnswer INTEGER)";
        db.execSQL(createTable);
    }

/*
    public int getSum(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor sumData = db.rawQuery("SELECT SUM(QuestionAnswer) AS \"SUM\"  FROM " + TABLE_NAME, null);
        sumData.moveToFirst();
        return sumData.getInt(sumData.getColumnIndex("SUM"));
    }
*/
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean  answerQuestion(int questionID, int answer)
    {
        SQLiteDatabase db = this.getWritableDatabase();

            db.execSQL("INSERT INTO " + TABLE_NAME + " (\"QuestionNumber\",\"QuestionAnswer\") VALUES ("+questionID+","+answer+");");

        return false;
    }

    public boolean addData(int item1) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2, item1);

        long result = db.insert(TABLE_NAME, null, contentValues);
        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }
}