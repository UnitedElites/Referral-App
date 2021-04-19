package com.example.referal_app_version2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CateInfoActivity extends AppCompatActivity implements View.OnClickListener{
    private DatabaseManager myDm;
    private String email;
    private String category;
    private ArrayList<CateInfo> cateList=new ArrayList<CateInfo>();

    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cate_info);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        email = getIntent().getStringExtra("user_email");
        category = getIntent().getStringExtra("category");

        myDm = new DatabaseManager(this);
        myDm.open();

        getCateInfo(category);

        CateAdapter adapter = new CateAdapter(CateInfoActivity.this, R.layout.catesubcontent,cateList);
        ListView listView=(ListView)findViewById(R.id.catelistview);
        listView.setAdapter(adapter);

        initView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(CateInfoActivity.this,CateInfoDetailActivity.class);
                CateInfo cate = (CateInfo) adapter.getItem(position);
                myIntent.putExtra("title",cate.getTitle());
                myIntent.putExtra("user_email",email);
                myIntent.putExtra("category", category);
                startActivity(myIntent);
            }
        });
    }

    private void initView() {
        //initilization view
        Button go_back = findViewById(R.id.back);
        TextView cateTitle = findViewById(R.id.ResultTitle);
        cateTitle.setText(category);
        go_back.setOnClickListener(this);
    }

    private void getCateInfo(String cate){
        cateList = myDm.getCateInfo(cate);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
        }
    }
}
