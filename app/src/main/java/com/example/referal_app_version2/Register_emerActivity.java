package com.example.referal_app_version2;

import android.os.Bundle;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register_emerActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText emer_email,emer_phone;
    private DatabaseManager myDm;
    public String email;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setTitle("User_Register2");

        email = getIntent().getStringExtra("email");
        myDm = new DatabaseManager(this);
        myDm.open();

        initView();


    }

    private void initView() {
        emer_email = findViewById(R.id.emer_emailEdit);
        emer_phone = findViewById(R.id.emer_phoneEdit);

        Button btn_register_2 = findViewById(R.id.finishButton);
        Button go_back = findViewById(R.id.back);

        go_back.setOnClickListener(this);
        btn_register_2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.finishButton:
                String emergency_email = emer_email.getText().toString().trim();
                String emergency_phone = emer_phone.getText().toString().trim();
                //registration check
                if (!TextUtils.isEmpty(emergency_email) && !TextUtils.isEmpty(emergency_phone)) {
                    myDm.update_eme(email,emergency_email,emergency_phone);
                    Intent intent_regFinish = new Intent(Register_emerActivity.this, LoginActivity.class);
                    startActivity(intent_regFinish);
                    finish();
                    Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(this, "Register Failed", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}