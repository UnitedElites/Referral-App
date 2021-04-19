package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.speech.RecognizerIntent;
import android.content.ActivityNotFoundException;
import android.widget.Toast;

import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private DatabaseManager myDm;
    private static final int REQUEST_CODE = 100;
    String email, title;
    EditText search_input;
    Intent intent;


    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        title = getIntent().getStringExtra("title");
        email = getIntent().getStringExtra("user_email");
        myDm = new DatabaseManager(this);
        myDm.open();
        search_input = findViewById(R.id.searchEdit);

        if(shouldAskPermissions()){
            askPermissions();
        }
        initView();
    }

    private void initView() {
        //initilization view

        search_input = findViewById(R.id.searchEdit);

        Button search_button = findViewById(R.id.SearchButton);
        search_button.setOnClickListener(this);
        Button back = findViewById(R.id.back);
        back.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SearchButton:
                String input = search_input.getText().toString().trim();
                Intent SearchIntent = new Intent(SearchActivity.this, SearchResultActivity.class);
                SearchIntent.putExtra("hints", input);
                startActivity(SearchIntent);
                break;

            case R.id.back:
                finish();
                break;
        }
    }


    public void on_mic(View v)
    {
        intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(this,"error to start" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    search_input.setText(result.get(0));

                }
                break;
            }

        }
    }

    protected boolean shouldAskPermissions(){
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    protected void askPermissions(){
        String[] permissions = {
                "android.permission.RECORD_AUDIO"
        };
        int requestCode = 100;
        requestPermissions(permissions,requestCode);
    }


}
