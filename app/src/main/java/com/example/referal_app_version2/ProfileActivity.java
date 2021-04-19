package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    public static ArrayList<User> data;
    public static User pUser;
    private DatabaseManager myDm;
    public static TextView pName,pPhone,pEmail,pGender,pAge;
    String email;



    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);



        myDm = new DatabaseManager(this);
        myDm.open();
        email = myDm.getEmail();
        initView();

            data = myDm.getAllData();
            for (int i = 0; i < data.size(); i++) {
                pUser = data.get(i);
                if ((email.equals(pUser.getEmail()))) {
                    pName.setText(pUser.getName());
                    pPhone.setText(pUser.getEmer_phone());
                    pEmail.setText(pUser.getEmer_email());
                    pAge.setText(pUser.getAge());
                    pGender.setText(pUser.getGender());
                }
            }


    }
    private void initView() {
        //initilization view
        pName = (TextView)findViewById(R.id.pName);
        pAge = (TextView)findViewById(R.id.pAge);
        pPhone = (TextView)findViewById(R.id.pPhone);
        pGender= (TextView)findViewById(R.id.pGender);
        pEmail= (TextView)findViewById(R.id.pEmail);

        Button log_out = findViewById(R.id.logoutButton);
        log_out.setOnClickListener(this);
        Button ch_pw = findViewById(R.id.ch_pwButton);
        ch_pw.setOnClickListener(this);
        Button editName = findViewById(R.id.editName);
        editName.setOnClickListener(this);
        Button editAge = findViewById(R.id.editAge);
        editAge.setOnClickListener(this);
        Button editPhone = findViewById(R.id.editPhone);
        editPhone.setOnClickListener(this);
        Button editEmail = findViewById(R.id.editEmail);
        editEmail.setOnClickListener(this);
        Button editGender = findViewById(R.id.editGender);
        editGender.setOnClickListener(this);

        Button btn_barHome_p = findViewById(R.id.barMain);
        Button btn_barReminder_p = findViewById(R.id.barReminder);
        Button btn_barCategory_p = findViewById(R.id.barCate);


        btn_barReminder_p.setOnClickListener(this);
        btn_barCategory_p.setOnClickListener(this);
        btn_barHome_p.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editName:
                Intent editNIntent = new Intent(ProfileActivity.this, ProfieEditActivity.class);
                editNIntent.putExtra("user_email",email);
                editNIntent.putExtra("title","Name");
                editNIntent.putExtra("flag",1);
                startActivity(editNIntent);
                break;
            case R.id.editAge:
                Intent editAIntent = new Intent(ProfileActivity.this, ProfieEditActivity.class);
                editAIntent.putExtra("user_email",email);
                editAIntent.putExtra("title","Age");
                editAIntent.putExtra("flag",2);
                startActivity(editAIntent);
                break;
            case R.id.editGender:
                Intent editGIntent = new Intent(ProfileActivity.this, ProfieEditActivity.class);
                editGIntent.putExtra("user_email",email);
                editGIntent.putExtra("title","Gender");
                editGIntent.putExtra("flag",3);
                startActivity(editGIntent);
                break;
            case R.id.editEmail:
                Intent editEIntent = new Intent(ProfileActivity.this, ProfieEditActivity.class);
                editEIntent.putExtra("user_email",email);
                editEIntent.putExtra("title","Email");
                editEIntent.putExtra("flag",4);
                startActivity(editEIntent);
                break;
            case R.id.editPhone:
                Intent editPIntent = new Intent(ProfileActivity.this, ProfieEditActivity.class);
                editPIntent.putExtra("user_email",email);
                editPIntent.putExtra("title","Phone");
                editPIntent.putExtra("flag",5);
                startActivity(editPIntent);
                break;

            case R.id.barCate:
                Intent cat2Intent = new Intent(ProfileActivity.this, CategeryActivity.class);
                cat2Intent.putExtra("user_email",email);
                startActivity(cat2Intent);
                finish();
                break;

            case R.id.barReminder:
                Intent reminder2Intent = new Intent(ProfileActivity.this, ApptListDisplayActivity.class);
                reminder2Intent.putExtra("user_email",email);
                startActivity(reminder2Intent);
                finish();
                break;

            case R.id.barMain:
                Intent main2Intent = new Intent(ProfileActivity.this, HomePageActivity.class);
                main2Intent.putExtra("user_email",email);
                startActivity(main2Intent);
                finish();
                break;

            case R.id.logoutButton:
                Intent logoutIntent = new Intent(ProfileActivity.this, MainActivity.class);
                myDm.delete_all();
                startActivity(logoutIntent);
                break;

            case R.id.ch_pwButton:
                Intent ch_pwIntent = new Intent(ProfileActivity.this, ForgetPwActivity.class);
                ch_pwIntent.putExtra("user_email",email);
                startActivity(ch_pwIntent);
                break;


        }
    }

}
