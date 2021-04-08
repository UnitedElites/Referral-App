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
public class ChangePwActivity extends AppCompatActivity implements View.OnClickListener {
    DatabaseManager myDm;
    private EditText new_pw, confirm_pw;
    private String userEmail;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepw);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        userEmail = getIntent().getStringExtra("user_email");
        myDm = new DatabaseManager(this);
        myDm.open();
        initView();


    }

    private void initView() {
        //initilization view
        new_pw = findViewById(R.id.newPwEdit);
        confirm_pw = findViewById(R.id.confirmPwEdit);
        Button btn_Finish = findViewById(R.id.finishButton_change);
        Button btn_back = findViewById(R.id.back);
        //set listener
        btn_Finish.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(ChangePwActivity.this, ForgetPwActivity.class);//跳转到注册界面
                startActivity(intent);
                finish();
                break;

            case R.id.finishButton_change:
                String new_pass = new_pw.getText().toString().trim();
                String confirm_pass = confirm_pw.getText().toString().trim();
                if (!TextUtils.isEmpty(new_pass) && !TextUtils.isEmpty(confirm_pass)) {
                        if (new_pass.equals(confirm_pass)) {
                            myDm.update_pw(userEmail,new_pass);
                            Toast.makeText(this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                        //Runnable target;
                        //用线程启动
                        //Thread thread = new Thread(){
                        //@Override
                        //public void run(){
                        //try {
                        //sleep(2000);//2秒 模拟登录时间
                        //String user_email = userEmail;
                            Intent intent_login = new Intent(ChangePwActivity.this, LoginActivity.class);//设置自己跳转到成功的界面

                        //intent_login.putExtra("user_email", user_email);
                            startActivity(intent_login);
                            finish();
                        //}catch (Exception e){
                        //  e.printStackTrace();
                        // }
                        // }
                        // };
                        // thread.start();//打开线程
                        } else {
                            Toast.makeText(this, "Password not match", Toast.LENGTH_SHORT).show();
                        }

                } else {
                    Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}