package com.example.mysqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Student.db";
    private static final String TABLE_NAME = "student_details";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "Name";
    private static final String COLUMN_AGE = "Age";
    private static final String COLUMN_GENDER = "Gender";
    private static final int DATABASE_VERSION = 3;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_NAME +" VARCHAR(255), "+COLUMN_AGE+" INTEGER);";
    private static final String UPDATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+COLUMN_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+ COLUMN_NAME +" VARCHAR(255), "+COLUMN_AGE+" INTEGER, "+COLUMN_GENDER+" VARCHAR(15));";
    private static final String READ_TABLE = "SELECT * FROM "+ TABLE_NAME;
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLE_NAME+" ";
    private Context context;

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context, "On create is called!", Toast.LENGTH_SHORT).show();
            db.execSQL(UPDATE_TABLE);
            System.out.println("\n\n----------CREATE IS CALLED------------\n\n");
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context, "On Update is called!", Toast.LENGTH_SHORT).show();
            System.out.println("\n\n----------UPDATE IS CALLED------------\n\n");

            db.execSQL(DROP_TABLE);
            onCreate(db);
        }catch (Exception e){
            Toast.makeText(context, "Exception: "+ e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public long insert(String name, String age, String gender){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_AGE, age);
        contentValues.put(COLUMN_GENDER, gender);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);

        return id;
    }

    public Cursor displayAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(READ_TABLE, null);

        return cursor;
    }

    public boolean updateData(String id, String name, String age, String gender){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_ID, id);
        contentValues.put(COLUMN_NAME, name);
        contentValues.put(COLUMN_AGE, age);
        contentValues.put(COLUMN_GENDER, gender);

        sqLiteDatabase.update(TABLE_NAME, contentValues, COLUMN_ID+" = ?", new String[]{id});

        return true;
    }

    public int deleteDate(String id){

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME, COLUMN_ID+" = ?", new String[]{id});
    }

    public Cursor showAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(READ_TABLE, null);
        return cursor;
    }
}
