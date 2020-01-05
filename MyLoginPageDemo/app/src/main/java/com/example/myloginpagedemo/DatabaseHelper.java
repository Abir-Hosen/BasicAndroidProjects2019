package com.example.myloginpagedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "user.db";
    private static final String TABLE_NAME = "user_details";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    private static final int DATABASE_VERSION = 2;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+COLUMN_NAME+" VARCHAR(255), "+COLUMN_EMAIL+" VARCHAR(255), "+COLUMN_USERNAME+" VARCHAR(255), "+COLUMN_PASSWORD+" VARCHAR(255));";
    private static final String READ_TABLE = "SELECT * FROM "+TABLE_NAME;
    private static final String UPDATE_TABLE = "";
    private static final String DELETE_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    private static final String READ_TABLE_BY_EMAIL = "SELECT * FROM "+TABLE_NAME+" WHERE "+COLUMN_EMAIL+"= ?";
    private static final String UPDATE_TABLE_DATA_BY_EMAIL = "";
    private static final String DELETE_TABLE_DATA_BY_EMAIL = "";

    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            System.out.println("------------------------ON CREATE IS CALLED-------------------------");
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "Database Table created successfully!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            System.out.println("------------------------ON CREATE IS CALLED WITH EXCEPTION-------------------------");
            Toast.makeText(context, "Database Table creation failed!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            System.out.println("------------------------ON UPGRADE IS CALLED-------------------------");
            db.execSQL(DELETE_TABLE);
            onCreate(db);
            Toast.makeText(context, "Database Table upgraded successfully!", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            System.out.println("------------------------ON UPGRADE IS CALLED WITH EXCEPTION-------------------------");
            Toast.makeText(context, "Database Table upgrade failed!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public long insert(String name, String email, String userName, String password){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_EMAIL, email);
        contentValues.put(COLUMN_USERNAME, userName);
        contentValues.put(COLUMN_PASSWORD, password);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        return id;
    }

    public boolean findEmail(String email, String user){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        boolean result = false;

        if (cursor.getCount()==0){
            Toast.makeText(context, "No data found!", Toast.LENGTH_LONG).show();
            result = false;
        }else {
            while (cursor.moveToNext()){
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                if (data1.equals(email) || data2.equals(user)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public boolean findPassword(String user, String password){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLE_NAME, null);
        boolean result = false;

        if (cursor.getCount()==0){
            Toast.makeText(context, "No data found!", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()){
                String data1 = cursor.getString(2);
                String data2 = cursor.getString(3);
                String data3 = cursor.getString(4);
                if (data1.equals(user) || data2.equals(user) && data3.equals(password)){
                    result = true;
                    break;
                }
            }
        }
        return result;
    }


}
