package com.example.lab_05;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Bakery.db";
    public DBHelper(Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table user(username TEXT primary key, password TEXT,ph TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists user");
    }

    public Boolean insertData(String username, String password,String ph){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("ph", ph);
        long result = MyDB.insert("user", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where username = ?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkusernamepassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from user where username = ? and password = ?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean updateuserdata(String username, String password,String ph) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password", password);
        contentValues.put("ph",ph);
        // You can add more fields to update if needed

        // Use the correct column name in the where clause
        Cursor cursor = DB.rawQuery("Select * from user where username = ?", new String[]{username});
        if (cursor.getCount() > 0) {
            long result = DB.update("user", contentValues, "username=?", new String[]{username}); // Change "name" to "username"
            if (result == -1) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    public String getUsername() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT username FROM user LIMIT 1", null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("username");
            if (columnIndex != -1) {
                return cursor.getString(columnIndex);
            }
        }
        return null; // Return null if no username found
    }

    // Method to get the password from the database
    public String getPassword() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT password FROM user LIMIT 1", null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("password");
            if (columnIndex != -1) {
                return cursor.getString(columnIndex);
            }
        }
        return null; // Return null if no password found
    }
    public String getPh() {
        SQLiteDatabase MyDB = this.getReadableDatabase();
        Cursor cursor = MyDB.rawQuery("SELECT ph FROM user LIMIT 1", null);
        if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex("ph");
            if (columnIndex != -1) {
                return cursor.getString(columnIndex);
            }
        }
        return null; // Return null if no password found
    }
}