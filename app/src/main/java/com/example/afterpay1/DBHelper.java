package com.example.afterpay1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static  final String DATABASE_NAME="AFTERPAYDB";
    private static  final int DATABASE_VERSION=1;
     static Contract.StudentTable  stobj;
    static final  String CREATE_TABLE="create table "+stobj.TABLE_NAME+"("+stobj.COLLEGE_ID+" varchar(12) primary key,"+stobj.NAME+" varchar(30),"+
            stobj.MOBILE+" varchar(12),"+stobj.EMAIL+" varchar(40),"+stobj.ADDRESS+" varchar(155));";
    public  DBHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public long adduser(String id,String name,String mobile,String email,String address,SQLiteDatabase db)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(stobj.COLLEGE_ID,id);
        contentValues.put(stobj.NAME,name);
        contentValues.put(stobj.MOBILE,mobile);
        contentValues.put(stobj.EMAIL,email);
        contentValues.put(stobj.ADDRESS,address);
        long c=db.insert(stobj.TABLE_NAME,null,contentValues);
        db.close();
        return c;
    }

    public Cursor showUsers(SQLiteDatabase db)
    {
        String[] projections ={stobj.COLLEGE_ID,stobj.NAME};
       return db.query(stobj.TABLE_NAME,projections,null,null,null,null,null);

    }
    public void deleteUser(String id,SQLiteDatabase db)
    {
        String selection=stobj.COLLEGE_ID+" LIKE ?";
        String[] selection_args={id};
        db.delete(stobj.TABLE_NAME,selection,selection_args);

    }
    public Cursor getUserDetail(SQLiteDatabase db,String id)
    {
        String[] projections ={stobj.COLLEGE_ID,stobj.NAME,stobj.MOBILE,stobj.EMAIL,stobj.ADDRESS};
        String selection=stobj.COLLEGE_ID+" LIKE ?";
        String[] selection_args={id};
        Cursor cursor = db.query(stobj.TABLE_NAME,projections,selection,selection_args,null,null,null);
        return cursor;

    }
}
