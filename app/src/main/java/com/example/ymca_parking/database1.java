package com.example.ymca_parking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class database1 extends SQLiteOpenHelper {
    public static final String DBname= "login.db";
    public static final String tabel1="logindetails";
    public static final String tabel2="parkingdetails";

    public database1(Context context) {
        super(context, "login.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username int primary key,password TEXT,phone TEXT)");
                //"registration VARCHAR,entrydate DATE,entrytime TIME,exitdate DATE,exittime TIME)");
        MyDB.execSQL("create table parking(username int primary key,registration VARCHAR,entrydate DATE,entrytime TIME,exitdate DATE," +
              "exittime TIME )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
        MyDB.execSQL("drop Table if exists parking");

    }
    public boolean insertparking1(String username, String registration, String entrydate, String entrytime, String exitdate, String exittime)
    {
        SQLiteDatabase MyDB=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
       // contentValues.put("username",username);
        contentValues.put("registration",registration);
        contentValues.put("entrydate",entrydate);
        contentValues.put("entrytime",entrytime);
        contentValues.put("exitdate",exitdate);
        contentValues.put("exittime",exittime);
        Cursor cursor=MyDB.rawQuery("select * from users where username=?",new String[]{username});
        if(cursor.getCount()>0)
        {
            // Cursor result=MyDB.rawQuery("Update users Set registration=?,entrydate=?,entrytime=?,exitdate=?,exittime=? where username=?",new String[]{registration,entrydate,entrytime,exitdate,exittime,username});
            long result=MyDB.update("users",contentValues,"username=?",new String[]{username});
            if (result==-1)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return false;
        }


    }

    public Boolean insertparkingdata(String username,String registration, String entrydate,String entrytime,String exitdate,String exittime)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("username",username);
        contentValues.put("registration",registration);
        contentValues.put("entrydate",entrydate);
        contentValues.put("entrytime",entrytime);
        contentValues.put("exitdate",exitdate);
        contentValues.put("exittime",exittime);
        long result=Mydb.insert("parking",null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean updatedata(String username,String password,String phone) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("password", password);
        contentValues.put("phone", phone);
        Cursor cursor = MyDB.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0)
        {
        long result = MyDB.update("users", contentValues, "username=?", new String[]{username});
        if (result == -1)
            return false;
        else
            return true;
        }
        else
        {
            return false;
        }

    }

    public Boolean deletedata(String username)
    {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0)
        {
            long result = MyDB.delete("users", "username=?", new String[]{username});
            if (result == -1)
                return false;
            else
                return true;
        }
        else
        {
            return false;
        }

    }



    public Boolean insertData(String username, String password,String phone){
        SQLiteDatabase MyDB= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        Long result=MyDB.insert("users",null,contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username,String password){
        SQLiteDatabase MyDB=this.getWritableDatabase();
        Cursor cursor=MyDB.rawQuery("Select * from users where username=? and password=?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Cursor getdata(String username)
    {
        SQLiteDatabase Mydb=this.getWritableDatabase();
        Cursor cursor=Mydb.rawQuery("select * from users where username=? ",new String[]{username});
        return cursor;
    }
}
