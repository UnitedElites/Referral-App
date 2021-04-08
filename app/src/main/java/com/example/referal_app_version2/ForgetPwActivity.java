package com.example.referal_app_version2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
public class ForgetPwActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseManager myDm;
    private EditText email_addr, age, gender;
    private String userEmail;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpw);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        initView();
        myDm = new DatabaseManager(this);
        myDm.open();

    }

    private void initView() {
        //initilization view
        email_addr = findViewById(R.id.emailEdit_check);
        age = findViewById(R.id.ageEdit_check);
        gender = findViewById(R.id.genderEdit_check);
        Button btn_Next = findViewById(R.id.nextButton);
        Button btn_back = findViewById(R.id.back);
        //set listener
        btn_Next.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(ForgetPwActivity.this, LoginActivity.class);//跳转到注册界面
                startActivity(intent);
                finish();
                break;

            case R.id.nextButton:
                String email = email_addr.getText().toString().trim();
                String age_temp = age.getText().toString().trim();
                String gender_temp = gender.getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(age_temp) && !TextUtils.isEmpty(gender_temp)) {
                    ArrayList<User> data = myDm.getAllData();
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if ((email.equals(user.getEmail()) && age_temp.equals(user.getAge()) && gender_temp.equals(user.getGender()))) {
                            userEmail = user.getEmail();
                            match = true;

                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(this, "Passed Check", Toast.LENGTH_LONG).show();
                        //Runnable target;
                        //用线程启动
                        //Thread thread = new Thread(){
                            //@Override
                            //public void run(){
                                //try {
                                    //sleep(2000);//2秒 模拟登录时间
                                    String user_email = userEmail;
                                    Intent intent_changePw = new Intent(ForgetPwActivity.this, ChangePwActivity.class);//设置自己跳转到成功的界面

                                    intent_changePw.putExtra("user_email",user_email);
                                    startActivity(intent_changePw);
                                    finish();
                                //}catch (Exception e){
                                    //e.printStackTrace();
                               // }
                            //}
                       // };
                        //thread.start();//打开线程
                    } else {
                        Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
