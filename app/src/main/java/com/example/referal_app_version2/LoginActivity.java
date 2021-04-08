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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    DatabaseManager myDm;
    private EditText email_addr, password;
    private CheckBox remember_login;
    private String userEmail;
    private SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        initView();
        myDm = new DatabaseManager(this);
        myDm.open();
        SharedPreferences sp = getSharedPreferences("user_mes", MODE_PRIVATE);
        editor = sp.edit();
        if(sp.getBoolean("flag",false)){
            String user_read = sp.getString("user","");
            String psw_read = sp.getString("psw","");
            email_addr.setText(user_read);
            password.setText(psw_read);
        }
    }

    private void initView() {
        //initilization view
        email_addr = findViewById(R.id.emailEdit);
        password = findViewById(R.id.passwordEdit);
        remember_login = findViewById(R.id.remember);
        Button btn_Login = findViewById(R.id.logInButton);
        Button btn_forgot = findViewById(R.id.forgetbutton);
        Button btn_back = findViewById(R.id.back);
        //set listener
        btn_Login.setOnClickListener(this);
        btn_forgot.setOnClickListener(this);
        btn_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);//跳转到注册界面
                startActivity(intent);
                finish();
                break;

            case R.id.logInButton:
                String email = email_addr.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(pass)) {
                    ArrayList<User> data = myDm.getAllData();
                    boolean match = false;
                    boolean match2 = false;
                    for (int i = 0; i < data.size(); i++) {
                        User user = data.get(i);
                        if ((email.equals(user.getEmail()) && pass.equals(user.getPassword()))) {
                            userEmail = user.getEmail();
                            match = true;
                            if(remember_login.isChecked()){
                                editor.putBoolean("flag",true);
                                editor.putString("user",user.getEmail());
                                editor.putString("psw",user.getPassword());
                                editor.apply();
                                match2 = true;
                            }else {
                                editor.putString("user",user.getEmail());
                                editor.putString("psw","");
                                editor.clear();
                                editor.apply();
                                match2 = false;
                            }
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        if(match2){
                            Toast.makeText(this, "Remember Successfully", Toast.LENGTH_LONG).show();
                            remember_login.setChecked(true);
                        }
                        Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        //Runnable target;
                        //用线程启动
                        //Thread thread = new Thread(){
                            //@Override
                            //public void run(){
                                //try {
                                    //sleep(2000);//2秒 模拟登录时间
                                    String user_email = userEmail;
                                    Intent intent_login = new Intent(LoginActivity.this, MainActivity.class);//设置自己跳转到成功的界面

                                    intent_login.putExtra("user_email",user_email);
                                    startActivity(intent_login);
                                    finish();
                                //}catch (Exception e){
                                  //  e.printStackTrace();
                               // }
                           // }
                       // };
                       // thread.start();//打开线程
                    } else {
                        Toast.makeText(this, "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Please enter your email or password", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.forgetbutton:
                Intent intent_forgot = new Intent(LoginActivity.this, ForgetPwActivity.class);//跳转到注册界面
                startActivity(intent_forgot);
                finish();
                break;
        }




    }
}
