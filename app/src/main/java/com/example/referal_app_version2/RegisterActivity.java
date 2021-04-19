package com.example.referal_app_version2;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
        private EditText user_name, user_email, user_age, user_gender, user_password;
        private DatabaseManager myDm;
        @Override
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.register1);
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            setTitle("User_Register1");

            initView();
            myDm = new DatabaseManager(this);
            myDm.open();

        }

        private void initView() {
            user_name = findViewById(R.id.userNameEdit);
            user_email = findViewById(R.id.emailEdit);
            user_age = findViewById(R.id.ageEdit);
            user_gender = findViewById(R.id.genderEdit);
            user_password = findViewById(R.id.passwordEdit);

        Button btn_register = findViewById(R.id.nextButton);
        Button go_back = findViewById(R.id.back);

        go_back.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nextButton:
                String username = user_name.getText().toString().trim();
                String password = user_password.getText().toString().trim();
                String email = user_email.getText().toString().trim();
                String age = user_age.getText().toString().trim();
                String gender = user_gender.getText().toString().trim();
                //registration check
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(gender)) {
                    boolean flag = false;
                    ArrayList<User> data = myDm.getAllData();
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if ((email.equals(user.getEmail()) )) {
                            flag = true;
                        }
                    }

                    if(flag == false){
                        myDm.add_1(username,email, age, gender,password);
                        Intent intent1 = new Intent(RegisterActivity.this, Register_emerActivity.class);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                    }
                    else{
                        Toast.makeText(this, "Email Exists", Toast.LENGTH_SHORT).show();
                    }

                }else{
                    Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

