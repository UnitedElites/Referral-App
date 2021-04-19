package com.example.referal_app_version2;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.view.View;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;



public class ShowBigImage extends AppCompatActivity implements View.OnClickListener{

    DatabaseManager myDm;
    Button btnLogin,btnRegister;
    Appointment appt;
    ImageView image;
    String email;
    String title;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showbigimage);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);


        myDm = new DatabaseManager(this);
        myDm.open();

        email = getIntent().getStringExtra("user_email");
        title = getIntent().getStringExtra("title");
        appt = myDm.getApptDetail(title,email);

        initView();
        Bitmap bitmap = BitmapFactory.decodeFile(appt.getImage_url());
        bitmap = rotateImage(bitmap,90);
        image.setImageBitmap(bitmap);

    }

    private void initView() {
        Button go_back = findViewById(R.id.back);
        go_back.setOnClickListener(this);
        image = findViewById(R.id.bigImage);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }

    public Bitmap rotateImage(Bitmap bitmap, float degree) {
        //create new matrix
        Matrix matrix = new Matrix();
        matrix.postRotate(degree);
        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return bmp;
    }
}
