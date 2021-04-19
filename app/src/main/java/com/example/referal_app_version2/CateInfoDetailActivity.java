package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CateInfoDetailActivity extends AppCompatActivity implements View.OnClickListener, TextToSpeech.OnInitListener{

    private DatabaseManager myDm;
    CateInfo cate;
    TextView ctitle,cphone,cemail,cAddress;
    String email;
    String title;
    String category;

    String speakContent;
    private TextToSpeech textToSpeech;

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_category_info);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        myDm = new DatabaseManager(this);
        myDm.open();
        email = getIntent().getStringExtra("user_email");
        title = getIntent().getStringExtra("title");
        category = getIntent().getStringExtra("category");


        initView();

        cate = myDm.getCateDetail(title,category);
        ctitle.setText(cate.getTitle());
        cphone.setText(cate.getPhone());
        cemail.setText(cate.getEmail());
        cAddress.setText(cate.getAddress());

        speakContent ="Title: "+ cate.getTitle()+
                "... Phone Numer: "+ cate.getPhone() +
                "... Email or Website: "+ cate.getEmail()+
                "... Address: "+  cate.getAddress();
        textToSpeech = new TextToSpeech(this, this);
    }
    private void initView() {
        //initilization view
        ctitle = (TextView)findViewById(R.id.cate_title);
        cphone = (TextView)findViewById(R.id.cate_phone);
        cemail = (TextView)findViewById(R.id.cate_email);
        cAddress = (TextView)findViewById(R.id.cate_address);

        Button go_back = findViewById(R.id.back);
        go_back.setOnClickListener(this);
        Button give_call = findViewById(R.id.cate_give_call);
        give_call.setOnClickListener(this);
        Button add_appointment = findViewById(R.id.cate_book_Button);
        add_appointment.setOnClickListener(this);
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
            case R.id.back:

                finish();
                break;
            case R.id.cate_give_call:
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+ cate.getPhone()));
                startActivity(callIntent);
                break;
            case R.id.cate_book_Button:
                Intent trans_add = new Intent(CateInfoDetailActivity.this, NewAppointmentActivity.class);
                trans_add.putExtra("user_email",email);
                startActivity(trans_add);
                break;

        }
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = textToSpeech.setLanguage(Locale.US);
            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Toast.makeText(this, "Lost data", Toast.LENGTH_SHORT).show();
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
