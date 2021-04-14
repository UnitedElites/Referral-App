package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{
    User u;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.searchButton:
                Intent searchIntent = new Intent(HomePageActivity.this, SearchActivity.class);//跳转到注册界面
                startActivity(searchIntent);

            case R.id.cateButton:
            case R.id.barCate:
                Intent catIntent = new Intent(HomePageActivity.this, CatActivity.class);//跳转到注册界面
                startActivity(catIntent);

            case R.id.reminderButton:
            case R.id.barReminder:
                Intent reminderIntent = new Intent(HomePageActivity.this, ReminderActivity.class);//跳转到注册界面
                startActivity(reminderIntent);

            case R.id.profileButton:
            case R.id.barProfile:
                Intent profileIntent = new Intent(HomePageActivity.this, ProfileActivity.class);//跳转到注册界面
                startActivity(profileIntent);

            case R.id.sosButton:
                if(u.getEmer_email().contains(null)&&u.getEmer_phone().contains(null)){
                    Toast.makeText(this, "Contact can not be done due to missing information", Toast.LENGTH_LONG).show();
                }
                String response = "Emergency phone number is "+u.getEmer_phone()+" and email is "+u.getEmer_email();

                Toast.makeText(this, response, Toast.LENGTH_LONG).show();
        }

    }
}
