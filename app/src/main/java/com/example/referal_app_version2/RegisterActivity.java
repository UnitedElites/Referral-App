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
        /**
         * 注册页面能点击的就三个地方
         * top处返回箭头、刷新验证码图片、注册按钮
         */
        go_back.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back://返回登录界面
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.nextButton://注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = user_name.getText().toString().trim();
                String password = user_password.getText().toString().trim();
                String email = user_email.getText().toString().trim();
                String age = user_age.getText().toString().trim();
                String gender = user_gender.getText().toString().trim();
                //注册验证
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(age) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(gender)) {
                    //判断两次密码是否一致

                        //将用户名和密码加入到数据库中
                        myDm.add_1(username,email, age, gender,password);
                        Intent intent1 = new Intent(RegisterActivity.this, Register_emerActivity.class);
                        intent1.putExtra("email",email);
                        startActivity(intent1);
                        finish();

                }
                //else {
                    //Toast.makeText(this, "注册信息不完善,注册失败", Toast.LENGTH_SHORT).show();
                //}
                break;
        }
    }
}

