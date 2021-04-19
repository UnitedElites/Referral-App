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
import static com.example.referal_app_version2.DatabaseHelper.DATABASE_TABLE_2;
import static com.example.referal_app_version2.DatabaseHelper.DATABASE_TABLE_3;
import static com.example.referal_app_version2.DatabaseHelper.DATABASE_TABLE_4;
import static com.example.referal_app_version2.DatabaseHelper.KEY_ROWID;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERNAME;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USEREMAIL;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERAGE;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERGENDER;
import static com.example.referal_app_version2.DatabaseHelper.KEY_USERPASSWORD;
import static com.example.referal_app_version2.DatabaseHelper.KEY_EMERGENCYEMAIL;
import static com.example.referal_app_version2.DatabaseHelper.KEY_EMERGENCYPHONE;

import static com.example.referal_app_version2.DatabaseHelper.KEY_DOD;
import static com.example.referal_app_version2.DatabaseHelper.KEY_appdetail;
import static com.example.referal_app_version2.DatabaseHelper.KEY_apptime;
import static com.example.referal_app_version2.DatabaseHelper.KEY_title;

import static com.example.referal_app_version2.DatabaseHelper.KEY_cate;
import static com.example.referal_app_version2.DatabaseHelper.KEY_infoaddress;
import static com.example.referal_app_version2.DatabaseHelper.KEY_infoemail;
import static com.example.referal_app_version2.DatabaseHelper.KEY_infophone;
import static com.example.referal_app_version2.DatabaseHelper.KEY_infotitle;

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
        myDatabase.execSQL("INSERT INTO User (user_name,user_email,user_age, user_gender, user_password,emergency_email,emergency_phone) VALUES(?,?,?,?,?,'default','default_2')",new Object[]{name, email,age, gender,password});

    }

    void add_2(String email, String a_title, String appoint_date ,String day_time, String appoint_detail,String path){
        myDatabase.execSQL("INSERT INTO Appointment (user_email,title, appoint_date,day_time,appoint_detail,appt_image) VALUES(?,?,?,?,?,?)",new Object[]{ email,a_title,appoint_date, day_time,appoint_detail,path});

    }

    void update_img(String title, String imageurl){
        myDatabase.execSQL("UPDATE Appointment SET appt_image = ? WHERE title = ?",new Object[]{imageurl,title});
    }


    void update_eme(String email, String emer_email, String emer_phone){
        myDatabase.execSQL("UPDATE User SET emergency_email = ?, emergency_phone = ? WHERE user_email = ?",new Object[]{emer_email,emer_phone,email});
    }

    void update_pw(String email, String password){
        myDatabase.execSQL("UPDATE User SET user_password = ? WHERE user_email = ?",new Object[]{password,email});

    }

    void update_name(String email,String name){
        myDatabase.execSQL("UPDATE User SET user_name = ? WHERE user_email = ?",new Object[]{name,email});
    }

    void update_age(String email,String age){
        myDatabase.execSQL("UPDATE User SET user_age = ? WHERE user_email = ?",new Object[]{age,email});
    }

    void update_gender(String email,String gender){
        myDatabase.execSQL("UPDATE User SET user_gender = ? WHERE user_email = ?",new Object[]{gender,email});
    }

    void update_email(String email,String sosemail){
        myDatabase.execSQL("UPDATE User SET emergency_email = ? WHERE user_email = ?",new Object[]{sosemail,email});
    }

    void update_phone(String email,String phone){
        myDatabase.execSQL("UPDATE User SET emergency_phone = ? WHERE user_email = ?",new Object[]{phone,email});
    }

    void delete_appt(String title,String email){
        myDatabase.execSQL("DELETE from Appointment WHERE user_email = ? AND title = ?", new Object[]{email,title});
    }

    void savelogin(String email){
        myDatabase.execSQL("INSERT INTO loginemail (user_email) VALUES(?)",new Object[]{email});
    }

    void delete_all(){
        myDatabase.execSQL(" DELETE From " + DATABASE_TABLE_4 );
    }

    String getEmail(){
        String email = null;
        String query = "Select * from " + DATABASE_TABLE_4;
        Cursor cursor = myDatabase.rawQuery(query,null);
        while(cursor.moveToNext()) {
            email = cursor.getString(cursor.getColumnIndex("user_email"));
        }

        return email;

    }


    ArrayList<User> getAllData(){
        ArrayList<User> list = new ArrayList<User>();
        @SuppressLint("Recycle") Cursor cursor = myDatabase.query("User",null,null,null,null,null,"user_name DESC");
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

    ArrayList<Appointment> getAppt(String email){
        ArrayList<Appointment> apptData= new ArrayList<Appointment>();
        String query = "Select * from " + DATABASE_TABLE_2 + " Where "+ KEY_USEREMAIL + " = '" + email +"'";
        @SuppressLint("Recycle") Cursor cursor = myDatabase.rawQuery(query,null);
        while(cursor.moveToNext()) {
            String email_2 = cursor.getString(cursor.getColumnIndex("user_email"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String appt_date = cursor.getString(cursor.getColumnIndex("appoint_date"));
            String time = cursor.getString(cursor.getColumnIndex("day_time"));
            String detail = cursor.getString(cursor.getColumnIndex("appoint_detail"));
            String imgaeUrl = cursor.getString(cursor.getColumnIndex("appt_image"));
            apptData.add(new Appointment(email_2,title, appt_date, time, detail, imgaeUrl));
        }

        return apptData;
    }

    public Appointment getApptDetail(String title,String email){
        SQLiteDatabase myDatabase = myDatabaseHelper.getReadableDatabase();
        String query = "Select * from " + DATABASE_TABLE_2 + " Where "+ KEY_title + " = '" + title + "' AND " + KEY_USEREMAIL + " = '" + email +"'" ;
        Cursor cursor = myDatabase.rawQuery(query,null);
        Appointment appt = new Appointment();
        if(cursor.moveToFirst()){
            appt.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            appt.setAppoint_date(cursor.getString(cursor.getColumnIndex("appoint_date")));
            appt.setDay_time(cursor.getString(cursor.getColumnIndex("day_time")));
            appt.setAppoint_detail(cursor.getString(cursor.getColumnIndex("appoint_detail")));
            appt.setImage_url(cursor.getString(cursor.getColumnIndex("appt_image")));
        }

        return appt;
    }




    ArrayList<CateInfo> getCateInfo(String cate){
        ArrayList<CateInfo> cateData= new ArrayList<CateInfo>();
        String query = "Select * from " + DATABASE_TABLE_3 + " Where "+ KEY_cate+" = '" + cate+"'";
        @SuppressLint("Recycle") Cursor cursor = myDatabase.rawQuery(query,null);
        while(cursor.moveToNext()) {
            String cate_1 = cursor.getString(cursor.getColumnIndex("category"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            cateData.add(new CateInfo(cate_1,title, address, email, phone));
        }

        return cateData;
    }

    public CateInfo getCateDetail(String title,String type){
        SQLiteDatabase myDatabase = myDatabaseHelper.getReadableDatabase();
        String query = "Select * from " + DATABASE_TABLE_3 + " Where "+ KEY_title + " = '" + title + "' AND " + KEY_cate + " = '" + type+"'"  ;
        Cursor cursor = myDatabase.rawQuery(query,null);
        CateInfo cate = new CateInfo();
        if(cursor.moveToFirst()){
            cate.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            cate.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
            cate.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            cate.setAddress(cursor.getString(cursor.getColumnIndex("address")));
        }

        return cate;
    }

    ArrayList<CateInfo> searchCateInfo(String input){
        ArrayList<CateInfo> cateData= new ArrayList<CateInfo>();
        String query = "Select * from " + DATABASE_TABLE_3 + " Where "+ KEY_infotitle + " Like '%" + input + "%' or "
                                                                        + KEY_infoaddress + " Like '%" + input + "%' or "
                                                                        + KEY_infoemail + " Like '%" + input + "%' or "
                                                                        + KEY_infophone + " Like '%" + input +"%' ";
        @SuppressLint("Recycle") Cursor cursor = myDatabase.rawQuery(query,null);
        while(cursor.moveToNext()) {
            String cate_1 = cursor.getString(cursor.getColumnIndex("category"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String phone = cursor.getString(cursor.getColumnIndex("phone"));
            cateData.add(new CateInfo(cate_1,title, address, email, phone));
        }

        return cateData;
    }



    // close the database
    public void close(){
        myDatabaseHelper.close();
    }


}