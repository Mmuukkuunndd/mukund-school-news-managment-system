package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper5 extends SQLiteOpenHelper {

    public dbhelper5(Context context) {
        super(context, "User1.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table Userdetails(news TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Userdetails");
    }

    public Boolean insertuserdata(String news) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("news", news);

        long result = db.insert("Userdetails", null, contentvalues);
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
        Cursor cursor = db.rawQuery("Select *from Userdetails where name =?", new String[]{roll});
        if (cursor.getCount() > 0) {


            long result = db.update("Userdetails", contentvalues, "name=?", new String[]{name});
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


        Cursor cursor = db.rawQuery("Select *from Userdetails where name =?", new String[]{roll});
        if (cursor.getCount() > 0) {


            long result = db.delete("Userdetails", "name=?", new String[]{roll});
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


        Cursor cursor = db.rawQuery("Select *from Userdetails", null);
        return cursor;
    }
}