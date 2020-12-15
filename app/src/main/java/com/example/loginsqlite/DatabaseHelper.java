package com.example.loginsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Login.db";
    public static final String TABLE_NAME = "user_teble";
    public static final String COL_USER_ID = "ID";
    public static final String COL_USER_NAME = " NAME";
    public static final String COL_USER_MONUMBER = "MOBILE NUMBER";
    public static final String COL_USER_EMAIL = "EMAIL";
    public static final String COL_USER_CITY = "CITY";
    public static final String COL_USER_PASSWORD = "PASSWORD";

    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME +"(" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,NUMBER INTEGER,EMAIL TEXT,CITY TEXT,PASSWORD TEXT)";

    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);

    }

    public boolean addUser(String name,String monumber,String email,String city,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_USER_NAME,name);
        values.put(COL_USER_MONUMBER,monumber);
        values.put(COL_USER_EMAIL,email);
        values.put(COL_USER_CITY,city);
        values.put(COL_USER_PASSWORD,password);

        long result= db.insert(TABLE_NAME,null,values);

        if(result==-1){
            return false;
        }
        else{
            return true;
        }


    }


}
