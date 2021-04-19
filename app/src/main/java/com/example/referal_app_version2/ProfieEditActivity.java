package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfieEditActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseManager myDm;
    String email,title;
    EditText upt_input;
    int flag = 0;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_edit);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        title = getIntent().getStringExtra("title");
        email = getIntent().getStringExtra("user_email");
        flag = getIntent().getIntExtra("flag",0);
        myDm = new DatabaseManager(this);
        myDm.open();
        initView();
    }
    private void initView() {
        //initilization view
        TextView cateTitle = findViewById(R.id.upt_title);
        cateTitle.setText(title);

        upt_input = findViewById(R.id.input_edit);

        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(this);

        Button back = findViewById(R.id.back);
        back.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();

            case R.id.submit:
                String input = upt_input.getText().toString().trim();
                if (flag == 1){
                    myDm.update_name(email, input);
                }

                if (flag == 2){
                    myDm.update_age(email,input);
                }

                if (flag == 3){
                    myDm.update_gender(email,input);
                }

                if (flag == 4){
                    myDm.update_email(email,input);
                }

                if (flag == 5){
                    myDm.update_phone(email,input);
                }

                ProfileActivity.data = myDm.getAllData();
                for (int i = 0; i < ProfileActivity.data.size(); i++) {
                    ProfileActivity.pUser = ProfileActivity.data.get(i);
                    if ((email.equals(ProfileActivity.pUser.getEmail()))) {
                        ProfileActivity.pName.setText(ProfileActivity.pUser.getName());
                        ProfileActivity.pPhone.setText(ProfileActivity.pUser.getEmer_phone());
                        ProfileActivity.pEmail.setText(ProfileActivity.pUser.getEmer_email());
                        ProfileActivity.pAge.setText(ProfileActivity.pUser.getAge());
                        ProfileActivity.pGender.setText(ProfileActivity.pUser.getGender());
                    }
                }
                finish();
                break;
        }
    }


}

