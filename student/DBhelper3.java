package com.example.finalproject;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper3 extends SQLiteOpenHelper {

    public DBhelper3(Context context) {
        super(context, "Userdata2.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails1(roll TEXT primary key,name TEXT,contact TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Userdetails1");
    }

    public Boolean insertuserdata(String roll, String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("roll", roll);
        contentvalues.put("name", name);
        contentvalues.put("contact", contact);
        long result = db.insert("Userdetails1", null, contentvalues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Boolean updateuserdata(String roll, String name, String contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("adress", name);
        contentvalues.put("contact", contact);
        Cursor cursor = db.rawQuery("Select *from Userdetails1 where name =?", new String[]{roll});
        if (cursor.getCount() > 0) {


            long result = db.update("Userdetails1", contentvalues, "name=?", new String[]{name});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }

    }
    public Boolean deletedata(String roll) {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("Select *from Userdetails1 where name =?", new String[]{roll});
        if (cursor.getCount() > 0) {


            long result = db.delete("Userdetails1","name=?", new String[]{roll});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;

        }

    }
    public Cursor getdata() {
        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("Select *from Userdetails1",null);
        return cursor;

    }

}