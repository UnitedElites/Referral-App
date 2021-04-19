package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Locale;


public class ApptDetialDisplayActivity extends AppCompatActivity implements View.OnClickListener , TextToSpeech.OnInitListener{

    private DatabaseManager myDm;
    Appointment appt;
    TextView ptitle,pdate,ptime,pdetail;
    ImageView image;
    String email;
    String title;
    String speakContent;
    private TextToSpeech textToSpeech;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_appt_display);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setTitle("Details");

        myDm = new DatabaseManager(this);
        myDm.open();
        email = getIntent().getStringExtra("user_email");
        title = getIntent().getStringExtra("title");

        initView();
        appt = myDm.getApptDetail(title,email);
        ptitle.setText(appt.getTitle());
        pdate.setText(appt.getAppoint_date());
        ptime.setText(appt.getDay_time());
        pdetail.setText(appt.getAppoint_detail());

        Bitmap bitmap = BitmapFactory.decodeFile(appt.getImage_url());
        if(bitmap != null){
            bitmap = rotateImage(bitmap,90);
            image.setImageBitmap(bitmap);
        }

        speakContent = appt.getTitle()+",... Date:  "+
                    appt.getAppoint_date()+"... Time:  "+
                    appt.getDay_time()+"... Note:  "+
                    appt.getAppoint_detail();
        textToSpeech = new TextToSpeech(this, this);
    }

    private void initView() {
        //initilization view
        ptitle = (TextView)findViewById(R.id.plantitle);
        pdate = (TextView)findViewById(R.id.planDate);
        ptime = (TextView)findViewById(R.id.daytime);
        pdetail = (TextView)findViewById(R.id.Appt_detail);
        image = (ImageView) findViewById(R.id.showDetailImage);

        Button go_back = findViewById(R.id.back);
        go_back.setOnClickListener(this);
        Button delete_appt = findViewById(R.id.CancelButton);
        delete_appt.setOnClickListener(this);
        Button show = findViewById(R.id.showbigimage);
        show.setOnClickListener(this);
        Button speak = findViewById(R.id.speak);
        speak.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.speak:
                if (textToSpeech != null && !textToSpeech.isSpeaking()) {
                    textToSpeech.setPitch(0.0f);
                    textToSpeech.setSpeechRate(0.6f);
                    textToSpeech.speak(speakContent,
                            TextToSpeech.QUEUE_FLUSH, null);
                }
                break;
            case R.id.showbigimage:
                Intent showimage = new Intent(ApptDetialDisplayActivity.this, ShowBigImage.class);
                showimage.putExtra("title",appt.getTitle());
                showimage.putExtra("user_email",email);
                startActivity(showimage);
                break;

            case R.id.back:

                finish();
                break;

            case R.id.CancelButton:
                if(appt.getImage_url() != null){
                    File deleteFile = new File(appt.getImage_url());
                    deleteFile.delete();
                }
                myDm.delete_appt(title,email);

                ApptListDisplayActivity.apptList.clear();
                ApptListDisplayActivity.apptList.addAll(myDm.getAppt(email));
                ApptListDisplayActivity.adapter.notifyDataSetChanged();
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

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Data lost", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        textToSpeech.stop();
        textToSpeech.shutdown();
    }

}

