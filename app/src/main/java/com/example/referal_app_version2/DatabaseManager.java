package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

import java.util.ArrayList;

import static com.example.referal_app_version2.DatabaseHelper.DATABASE_TABLE;
import static com.example.referal_app_version2.DatabaseHelper.KEY_ROWID;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERNAME;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USEREMAIL;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERAGE;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERGENDER;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERPASSWORD;
import static com.example.referal_app_version2.DatabaseHelper.KEY_EMERGENCYEMAIL;
import static com.example.referal_app_version2.DatabaseHelper.KEY_EMERGENCYPHONE;


public class DatabaseManager {

    Context context;
    private DatabaseHelper myDatabaseHelper;
    private SQLiteDatabase myDatabase;

    public DatabaseManager(Context context){
        this.context = context;
    }

    public DatabaseManager open() throws SQLException{
        myDatabaseHelper = new DatabaseHelper(context);
        myDatabase = myDatabaseHelper.getWritableDatabase();
        return this;
    }

    void add_1(String name, String email, String age, String gender, String password){
        myDatabase.execSQL("INSERT INTO Users (user_name,user_email,user_age, user_gender, user_password,emergency_email,emergency_phone) VALUES(?,?,?,?,?,'default','default_2')",new Object[]{name, email,age, gender,password});

    }

    void update_eme(String email, String emer_email, String emer_phone){
        myDatabase.execSQL("UPDATE Users SET emergency_email = ?, emergency_phone = ? WHERE user_email = ?",new Object[]{emer_email,emer_phone,email});
    }

    void update_pw(String email, String password){
        myDatabase.execSQL("UPDATE Users SET user_password = ? WHERE user_email = ?",new Object[]{password,email});

    }

    ArrayList<User> getAllData(){
        ArrayList<User> list = new ArrayList<User>();
        @SuppressLint("Recycle") Cursor cursor = myDatabase.query("Users",null,null,null,null,null,"user_name DESC");
        while(cursor.moveToNext()){
            String email = cursor.getString(cursor.getColumnIndex("user_email"));
            String name = cursor.getString(cursor.getColumnIndex("user_name"));
            String gender = cursor.getString(cursor.getColumnIndex("user_gender"));
            String age = cursor.getString(cursor.getColumnIndex("user_age"));
            String password = cursor.getString(cursor.getColumnIndex("user_password"));
            String emer_email = cursor.getString(cursor.getColumnIndex("emergency_email"));
            String emer_phone = cursor.getString(cursor.getColumnIndex("emergency_phone"));


            list.add(new User(email, name, gender, age, password, emer_email, emer_phone));
        }
        return list;
    }


    // close the database
    public void close(){
        myDatabaseHelper.close();
    }


}