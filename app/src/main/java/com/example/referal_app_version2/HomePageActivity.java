package com.example.referal_app_version2;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity implements View.OnClickListener{
    User u;
    private String email,phone_num;
    DatabaseManager myDm;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        myDm = new DatabaseManager(this);
        myDm.open();
        ArrayList<User> data = myDm.getAllData();
        email = myDm.getEmail();

        phone_num = getEmerPhone(data);

        if(shouldAskPermissions()){
            askPermissions();
        }

        initView();
    }
    private String getEmerPhone(ArrayList<User> data){
        String EmerPhone = null;
        for (int i = 0; i < data.size(); i++) {
            User user = data.get(i);
            if ((email.equals(user.getEmail()) )) {
                EmerPhone = user.getEmer_phone();
            }
        }
        return EmerPhone;
    }

    private void initView() {
        //initilization view
        Button btn_Search = findViewById(R.id.searchButton);
        Button btn_Reminder = findViewById(R.id.reminderButton);
        Button btn_Category = findViewById(R.id.cateButton);
        Button btn_Profile = findViewById(R.id.profileButton);
        Button btn_SOS = findViewById(R.id.sosButton);

        Button btn_barHome = findViewById(R.id.barMain);
        Button btn_barReminder = findViewById(R.id.barReminder);
        Button btn_barCategory = findViewById(R.id.barCate);
        Button btn_barProfile = findViewById(R.id.barProfile);
        //set listener
        btn_Search.setOnClickListener(this);
        btn_Reminder.setOnClickListener(this);
        btn_Category.setOnClickListener(this);
        btn_Profile.setOnClickListener(this);
        btn_SOS.setOnClickListener(this);

        btn_barReminder.setOnClickListener(this);
        btn_barCategory.setOnClickListener(this);
        btn_barProfile.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.searchButton:
                Intent searchIntent = new Intent(HomePageActivity.this, SearchActivity.class);
                startActivity(searchIntent);
                break;


            case R.id.cateButton:
                Intent cat1Intent = new Intent(HomePageActivity.this, CategeryActivity.class);
                startActivity(cat1Intent);
                finish();
                break;
            case R.id.barCate:
                Intent cat2Intent = new Intent(HomePageActivity.this, CategeryActivity.class);
                startActivity(cat2Intent);
                finish();
                break;

            case R.id.reminderButton:
                Intent reminder1Intent = new Intent(HomePageActivity.this, ApptListDisplayActivity.class);
                startActivity(reminder1Intent);
                finish();
                break;
            case R.id.barReminder:
                Intent reminder2Intent = new Intent(HomePageActivity.this, ApptListDisplayActivity.class);
                startActivity(reminder2Intent);
                finish();
                break;

            case R.id.profileButton:
                Intent profile1Intent = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(profile1Intent);
                finish();
                break;
            case R.id.barProfile:
                Intent profile2Intent = new Intent(HomePageActivity.this, ProfileActivity.class);
                startActivity(profile2Intent);
                finish();
                break;

            case R.id.sosButton:
                Intent callIntent = new Intent();
                callIntent.setAction(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ phone_num));
                startActivity(callIntent);
                break;
        }

    }

    protected boolean shouldAskPermissions(){
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    protected void askPermissions(){
        String[] permissions = {
                "android.permission.CALL_PHONE"
        };
        int requestCode = 200;
        requestPermissions(permissions,requestCode);
    }
}