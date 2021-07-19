package com.example.ymca_parking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

public class vehicle extends SQLiteOpenHelper {

    public vehicle(Context context) {
        super(context,"vehicle.db", null , 1);


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create Table parkingdetails(username int primary key,registration varchar,entrydate date,entrytime time," +
                "exitdate date,exittime time)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop Table if exists registration ");
    }


    public Boolean insertdata(String username,String registration, String entrydate,String entrytime,String exitdate,String exittime)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("registration",registration);
        contentValues.put("entrydate",entrydate);
        contentValues.put("entrytime",entrytime);
        contentValues.put("exitdate",exitdate);
        contentValues.put("exittime",exittime);
        long result=db.insert("parkingdetails",null,contentValues);
        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean updatetdata(String registration, String entrydate,String entrytime,String exitdate,String exittime)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("entrydate",entrydate);
        contentValues.put("entrytime",entrytime);
        contentValues.put("exitdate",exitdate);
        contentValues.put("exittime",exittime);
        Cursor cursor=db.rawQuery("Select * from parkingdetails where registration=?",new String[]{registration});
        if (cursor.getCount()>0)
        {
            long result = db.update("parkingdetails",  contentValues,"registration=?",new String[]{registration});
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        }
        else {
            return false;
        }
    }

    public Cursor getdata(String username)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from parkingdetails where username=? ",new String[]{username});
        return cursor;
    }


    public Cursor dataparking(String registration)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from parkingdetails where registration=? ",new String[]{registration});
        return cursor;
    }

    public Boolean checkregistration(String registration)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from parkingdetails where registration =?",new String[]{registration});
        if (cursor.getCount()>0)
            return true;
        else
            return false;

    }




}
