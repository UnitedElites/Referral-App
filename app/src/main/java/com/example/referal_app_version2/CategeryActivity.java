package com.example.referal_app_version2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class CategeryActivity extends AppCompatActivity{
    String email;
    DatabaseManager myDm;
    Button btnGP,btnDental, btnHairCut, btnLibrary, btnSocialWorker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cate1);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);



        myDm = new DatabaseManager(this);
        myDm.open();

        email = myDm.getEmail();

        btnGP = (Button)findViewById(R.id.gp);
        btnGP.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Intent Intent1 = new Intent(CategeryActivity.this,CateInfoActivity.class);
                Intent1.putExtra("user_email",email);
                Intent1.putExtra("category","GP/Doctor");
                startActivity(Intent1);


            }
        });

        btnDental = (Button)findViewById(R.id.dental);
        btnDental.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(CategeryActivity.this,CateInfoActivity.class);
                Intent1.putExtra("user_email",email);
                Intent1.putExtra("category","Dental");
                startActivity(Intent1);

            }
        });

        btnHairCut = (Button)findViewById(R.id.hairCut);
        btnHairCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(CategeryActivity.this,CateInfoActivity.class);
                Intent1.putExtra("user_email",email);
                Intent1.putExtra("category","Hair Cut");
                startActivity(Intent1);

            }
        });

        btnLibrary = (Button)findViewById(R.id.library);
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(CategeryActivity.this,CateInfoActivity.class);
                Intent1.putExtra("user_email",email);
                Intent1.putExtra("category","Library");
                startActivity(Intent1);

            }
        });

        btnSocialWorker = (Button)findViewById(R.id.socialWorker);
        btnSocialWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent1 = new Intent(CategeryActivity.this,CateInfoActivity.class);
                Intent1.putExtra("user_email",email);
                Intent1.putExtra("category","Social Worker");
                startActivity(Intent1);

            }
        });

        Button btn_barHome_c = findViewById(R.id.barMain);
        btn_barHome_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main2Intent = new Intent(CategeryActivity.this, HomePageActivity.class);//跳转到注册界面
                main2Intent.putExtra("user_email",email);
                startActivity(main2Intent);
                finish();
            }
        });

        Button btn_barReminder_c = findViewById(R.id.barReminder);
        btn_barReminder_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reminder2Intent = new Intent(CategeryActivity.this, ApptListDisplayActivity.class);
                reminder2Intent.putExtra("user_email",email);
                startActivity(reminder2Intent);
                finish();
            }
        });

        Button btn_barProfile_c = findViewById(R.id.barProfile);
        btn_barProfile_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profile2Intent = new Intent(CategeryActivity.this, ProfileActivity.class);//跳转到注册界面
                profile2Intent.putExtra("user_email",email);
                startActivity(profile2Intent);
                finish();
            }
        });






    }

}
